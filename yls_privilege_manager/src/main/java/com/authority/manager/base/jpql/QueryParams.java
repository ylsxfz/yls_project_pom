package com.authority.manager.base.jpql;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.CollectionUtils;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @Author yls
 * @Date 2020/3/22 13:27
 * @Description 解析查询条件：and、or、order
 * @Version 1.0
 **/
public class QueryParams<T> implements Specification<T> {
    //属性分隔符
    private static final String PROPERTY_SEPARATOR = ".";
    //and条件
    private List<BaseFilter> andBaseFilters = new ArrayList<>();

    public static String getPropertySeparator() {
        return PROPERTY_SEPARATOR;
    }

    /**
     * 功能描述:
     * 〈过滤空值的字段〉
     *
     * @author : yls
     * @date : 2020/7/2 12:08
     * @return : java.util.List<com.jw.mailserver.base.jpql.BaseFilter>
     */
    public List<BaseFilter> getAndBaseFilters() {
        List<BaseFilter> addResultFiler = new ArrayList<>();
        andBaseFilters.forEach(baseFilter -> {
            if (!BaseFilter.Operator.isNull.equals(baseFilter.getOperator())){
                Object value = baseFilter.getValue();
                if (value != null && value instanceof String){
                    String s = value.toString().trim();
                    if (!"".equals(s)){
                        addResultFiler.add(baseFilter);
                    }
                }
            }
        });
        return addResultFiler;
    }

    /**
     * 功能描述:
     * 〈过滤空值得字段〉
     *
     * @author : yls
     * @date : 2020/7/2 12:09
     * @return : java.util.List<com.jw.mailserver.base.jpql.BaseFilter>
     */
    public List<BaseFilter> getOrBaseFilters() {
        List<BaseFilter>  orResultFiler = new ArrayList<>();
        orBaseFilters.forEach(baseFilter -> {
            if (!BaseFilter.Operator.isNull.equals(baseFilter.getOperator())){
                Object value = baseFilter.getValue();
                if (value != null && value instanceof String){
                    String s = value.toString().trim();
                    if (!"".equals(s)){
                        orResultFiler.add(baseFilter);
                    }
                }
            }
        });
        return orResultFiler;
    }

    public List<BaseOrder> getBaseOrders() {
        return baseOrders;
    }

    // or条件
    private List<BaseFilter> orBaseFilters = new ArrayList<>();
    //排序属性
    private List<BaseOrder> baseOrders = new ArrayList<>();


    /**
     * @param path
     * @param propertyPath 属性路径
     * @return javax.persistence.criteria.Path<X>
     * @Author yls
     * @Description 获取属性
     * @Date 2020/3/22 13:46
     **/
    private <X> Path<X> getPath(Path<?> path, String propertyPath) {
        if (path == null || StringUtils.isEmpty(propertyPath)) {
            return (Path<X>) path;
        }
        String property = StringUtils.substringBefore(propertyPath, PROPERTY_SEPARATOR);
        return getPath(path.get(property), StringUtils.substringAfter(propertyPath, PROPERTY_SEPARATOR));
    }

    /**
     * @param root
     * @param criteriaQuery
     * @param criteriaBuilder
     * @return javax.persistence.criteria.Predicate
     * @Author yls
     * @Description 构造最终条件
     * @Date 2020/3/22 13:44
     **/
    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        Predicate restrictions = criteriaBuilder.and(toAndPredicate(root, criteriaBuilder));
        if (!orBaseFilters.isEmpty()) {
            restrictions = criteriaBuilder.and(restrictions, toOrPredicate(root, criteriaBuilder));
        }
        criteriaQuery.orderBy(toOrders(root, criteriaBuilder));
        return restrictions;
    }

    /**
     * @param root
     * @param criteriaBuilder
     * @return javax.persistence.criteria.Predicate
     * @Author yls
     * @Description 分析and条件
     * @Date 2020/3/22 13:48
     **/
    private Predicate toAndPredicate(Root<T> root, CriteriaBuilder criteriaBuilder) {
        Predicate restrictions = criteriaBuilder.conjunction();
        if (root == null || CollectionUtils.isEmpty(andBaseFilters)) {
            return restrictions;
        }
        for (BaseFilter baseFilter : andBaseFilters) {
            if (baseFilter == null) {
                continue;
            }
            String property = baseFilter.getProperty();
            BaseFilter.Operator operator = baseFilter.getOperator();
            Object value = baseFilter.getValue();
            Object maxValue = baseFilter.getMaxValue();
            Object minValue = baseFilter.getMinValue();
            Boolean ignoreCase = baseFilter.getIgnoreCase();
            Path<?> path = getPath(root, property);
            if (path == null) {
                continue;
            }
            //根据运算符生成相应条件
            switch (operator) {
                case eq:
                    if (value != null) {
                        if (BooleanUtils.isTrue(ignoreCase) && String.class.isAssignableFrom(path.getJavaType()) && value instanceof String) {
                            restrictions = criteriaBuilder.and(restrictions, criteriaBuilder.equal(criteriaBuilder.lower((Path<String>) path), ((String) value).toLowerCase()));
                        } else {
                            restrictions = criteriaBuilder.and(restrictions, criteriaBuilder.equal(path, value));
                        }
                    } else {
                        restrictions = criteriaBuilder.and(restrictions, path.isNull());
                    }
                    break;
                case ne:
                    if (value != null) {
                        if (BooleanUtils.isTrue(ignoreCase) && String.class.isAssignableFrom(path.getJavaType()) && value instanceof String) {
                            restrictions = criteriaBuilder.and(restrictions, criteriaBuilder.notEqual(criteriaBuilder.lower((Path<String>) path), ((String) value).toLowerCase()));
                        } else {
                            restrictions = criteriaBuilder.and(restrictions, criteriaBuilder.notEqual(path, value));
                        }
                    } else {
                        restrictions = criteriaBuilder.and(restrictions, path.isNotNull());
                    }
                    break;
                case gt:
                    if (Number.class.isAssignableFrom(path.getJavaType()) && value instanceof Number) {
                        restrictions = criteriaBuilder.and(restrictions, criteriaBuilder.gt((Path<Number>) path, (Number) value));
                    }
                    break;
                case lt:
                    if (Number.class.isAssignableFrom(path.getJavaType()) && value instanceof Number) {
                        restrictions = criteriaBuilder.and(restrictions, criteriaBuilder.lt((Path<Number>) path, (Number) value));
                    }
                    break;
                case ge:
                    if (Number.class.isAssignableFrom(path.getJavaType()) && value instanceof Number) {
                        restrictions = criteriaBuilder.and(restrictions, criteriaBuilder.ge((Path<Number>) path, (Number) value));
                    }
                    break;
                case le:
                    if (Number.class.isAssignableFrom(path.getJavaType()) && value instanceof Number) {
                        restrictions = criteriaBuilder.and(restrictions, criteriaBuilder.le((Path<Number>) path, (Number) value));
                    }
                    break;
                case like:
                    if (String.class.isAssignableFrom(path.getJavaType()) && value instanceof String) {
                        if (BooleanUtils.isTrue(ignoreCase)) {
                            restrictions = criteriaBuilder.and(restrictions, criteriaBuilder.like(criteriaBuilder.lower((Path<String>) path), ((String) value).toLowerCase()));
                        } else {
                            restrictions = criteriaBuilder.and(restrictions, criteriaBuilder.like((Path<String>) path, (String) value));
                        }
                    }
                    break;
                case in:
                    restrictions = criteriaBuilder.and(restrictions, path.in(value));
                    break;
                case isNull:
                    restrictions = criteriaBuilder.and(restrictions, path.isNull());
                    break;
                case isNotNull:
                    restrictions = criteriaBuilder.and(restrictions, path.isNotNull());
                    break;
                case between:
                    restrictions = criteriaBuilder.and(restrictions,criteriaBuilder.between((Path<String>) path,(String)minValue,(String) maxValue));
                    break;
                case lessThanOrEqualTo:
                    if (value instanceof Date){
                        restrictions = criteriaBuilder.and(restrictions,criteriaBuilder.lessThanOrEqualTo((Path<Date>)path,(Date) value));
                    }else if (value instanceof String){
                        restrictions = criteriaBuilder.and(restrictions,criteriaBuilder.lessThanOrEqualTo((Path<String>)path,(String)value));
                    }
                    break;
                case greaterThanOrEqualTo:
                    if (value instanceof Date){
                        restrictions = criteriaBuilder.and(restrictions,criteriaBuilder.greaterThanOrEqualTo((Path<Date>)path,(Date)value));
                    }else if (value instanceof String){
                        restrictions = criteriaBuilder.and(restrictions,criteriaBuilder.greaterThanOrEqualTo((Path<String>)path,(String)value));
                    }
                    break;
            }
        }
        return restrictions;
    }

    /**
     * @param root
     * @param criteriaBuilder
     * @return javax.persistence.criteria.Predicate
     * @Author yls
     * @Description 分析or条件
     * @Date 2020/3/22 13:49
     **/
    private Predicate toOrPredicate(Root<T> root, CriteriaBuilder criteriaBuilder) {
        Predicate restrictions = criteriaBuilder.disjunction();
        if (root == null || CollectionUtils.isEmpty(orBaseFilters)) {
            return restrictions;
        }
        for (BaseFilter baseFilter : orBaseFilters) {
            if (baseFilter == null) {
                continue;
            }
            String property = baseFilter.getProperty();
            BaseFilter.Operator operator = baseFilter.getOperator();
            Object value = baseFilter.getValue();
            Object maxValue = baseFilter.getMaxValue();
            Object minValue = baseFilter.getMinValue();
            Boolean ignoreCase = baseFilter.getIgnoreCase();
            Path<?> path = getPath(root, property);
            if (path == null) {
                continue;
            }
            switch (operator) {
                case eq:
                    if (value != null) {
                        if (BooleanUtils.isTrue(ignoreCase) && String.class.isAssignableFrom(path.getJavaType()) && value instanceof String) {
                            restrictions = criteriaBuilder.or(restrictions, criteriaBuilder.equal(criteriaBuilder.lower((Path<String>) path), ((String) value).toLowerCase()));
                        } else {
                            restrictions = criteriaBuilder.or(restrictions, criteriaBuilder.equal(path, value));
                        }
                    } else {
                        restrictions = criteriaBuilder.or(restrictions, path.isNull());
                    }
                    break;
                case ne:
                    if (value != null) {
                        if (BooleanUtils.isTrue(ignoreCase) && String.class.isAssignableFrom(path.getJavaType()) && value instanceof String) {
                            restrictions = criteriaBuilder.or(restrictions, criteriaBuilder.notEqual(criteriaBuilder.lower((Path<String>) path), ((String) value).toLowerCase()));
                        } else {
                            restrictions = criteriaBuilder.or(restrictions, criteriaBuilder.notEqual(path, value));
                        }
                    } else {
                        restrictions = criteriaBuilder.or(restrictions, path.isNotNull());
                    }
                    break;
                case gt:
                    if (Number.class.isAssignableFrom(path.getJavaType()) && value instanceof Number) {
                        restrictions = criteriaBuilder.or(restrictions, criteriaBuilder.gt((Path<Number>) path, (Number) value));
                    }
                    break;
                case lt:
                    if (Number.class.isAssignableFrom(path.getJavaType()) && value instanceof Number) {
                        restrictions = criteriaBuilder.or(restrictions, criteriaBuilder.lt((Path<Number>) path, (Number) value));
                    }
                    break;
                case ge:
                    if (Number.class.isAssignableFrom(path.getJavaType()) && value instanceof Number) {
                        restrictions = criteriaBuilder.or(restrictions, criteriaBuilder.ge((Path<Number>) path, (Number) value));
                    }
                    break;
                case le:
                    if (Number.class.isAssignableFrom(path.getJavaType()) && value instanceof Number) {
                        restrictions = criteriaBuilder.or(restrictions, criteriaBuilder.le((Path<Number>) path, (Number) value));
                    }
                    break;
                case like:
                    if (String.class.isAssignableFrom(path.getJavaType()) && value instanceof String) {
                        if (BooleanUtils.isTrue(ignoreCase)) {
                            restrictions = criteriaBuilder.or(restrictions, criteriaBuilder.like(criteriaBuilder.lower((Path<String>) path), ((String) value).toLowerCase()));
                        } else {
                            restrictions = criteriaBuilder.or(restrictions, criteriaBuilder.like((Path<String>) path, (String) value));
                        }
                    }
                    break;
                case in:
                    restrictions = criteriaBuilder.or(restrictions, path.in(value));
                    break;
                case isNull:
                    restrictions = criteriaBuilder.or(restrictions, path.isNull());
                    break;
                case isNotNull:
                    restrictions = criteriaBuilder.or(restrictions, path.isNotNull());
                    break;
                case between:
                    restrictions = criteriaBuilder.or(restrictions,criteriaBuilder.between((Path<String>) path,(String) minValue,(String) maxValue));
                    break;
                case lessThanOrEqualTo:
                    if (value instanceof Date){
                        restrictions = criteriaBuilder.or(restrictions,criteriaBuilder.lessThanOrEqualTo((Path<Date>)path,(Date)value));
                    }else if (value instanceof String){
                        restrictions = criteriaBuilder.or(restrictions,criteriaBuilder.lessThanOrEqualTo((Path<String>)path,(String)value));
                    }
                    break;
                case greaterThanOrEqualTo:
                    if (value instanceof Date){
                        restrictions = criteriaBuilder.or(restrictions,criteriaBuilder.greaterThanOrEqualTo((Path<Date>)path,(Date) value));
                    }else if (value instanceof String){
                        restrictions = criteriaBuilder.or(restrictions,criteriaBuilder.greaterThanOrEqualTo((Path<String>)path,(String)value));
                    }
                    break;
            }
        }
        return restrictions;
    }

    /**
     * @param root
     * @param criteriaBuilder
     * @return java.util.List<javax.persistence.criteria.Order>
     * @Author yls
     * @Description 分析排序条件
     * @Date 2020/3/22 13:49
     **/
    private List<Order> toOrders(Root<T> root, CriteriaBuilder criteriaBuilder) {
        List<Order> orderList = new ArrayList<Order>();
        if (root == null || CollectionUtils.isEmpty(baseOrders)) {
            return orderList;
        }
        for (BaseOrder baseOrder : baseOrders) {
            if (baseOrder == null) {
                continue;
            }
            String property = baseOrder.getProperty();
            BaseOrder.Direction direction = baseOrder.getDirection();
            Path<?> path = getPath(root, property);
            if (path == null || direction == null) {
                continue;
            }
            switch (direction) {
                case asc:
                    orderList.add(criteriaBuilder.asc(path));
                    break;
                case desc:
                    orderList.add(criteriaBuilder.desc(path));
                    break;
            }
        }
        return orderList;
    }

    /**
     * 添加一个and条件
     *
     * @param baseFilter 该条件
     * @return 链式调用
     */
    public QueryParams and(BaseFilter baseFilter) {
        this.andBaseFilters.add(baseFilter);
        return this;
    }

    /**
     * 添加多个and条件
     *
     * @param baseFilter 该条件
     * @return 链式调用
     */
    public QueryParams and(BaseFilter... baseFilter) {
        this.andBaseFilters.addAll(Arrays.asList(baseFilter));
        return this;
    }

    /**
     * 添加一个or条件
     *
     * @param baseFilter 该条件
     * @return 链式调用
     */
    public QueryParams or(BaseFilter baseFilter) {
        this.orBaseFilters.add(baseFilter);
        return this;
    }

    /**
     * 添加多个or条件
     *
     * @param baseFilter 该条件
     * @return 链式调用
     */
    public QueryParams or(BaseFilter... baseFilter) {
        this.orBaseFilters.addAll(Arrays.asList(baseFilter));
        return this;
    }

    /**
     * 升序字段
     *
     * @param property 该字段对应变量名
     * @return 链式调用
     */
    public QueryParams orderASC(String property) {
        this.baseOrders.add(BaseOrder.asc(property));
        return this;
    }

    /**
     * 降序字段
     *
     * @param property 该字段对应变量名
     * @return 链式调用
     */
    public QueryParams orderDESC(String property) {
        this.baseOrders.add(BaseOrder.desc(property));
        return this;
    }

    /**
     * 清除所有条件
     *
     * @return 该实例
     */
    public QueryParams clearAll() {
        if (!this.andBaseFilters.isEmpty()) this.andBaseFilters.clear();
        if (!this.orBaseFilters.isEmpty()) this.orBaseFilters.clear();
        if (!this.baseOrders.isEmpty()) this.baseOrders.clear();
        return this;
    }

    /**
     * 清除and条件
     *
     * @return 该实例
     */
    public QueryParams clearAnd() {
        if (!this.andBaseFilters.isEmpty()) this.andBaseFilters.clear();
        return this;
    }

    /**
     * 清除or条件
     *
     * @return 该实例
     */
    public QueryParams clearOr() {
        if (!this.orBaseFilters.isEmpty()) this.andBaseFilters.clear();
        return this;
    }

    /**
     * 清除order条件
     *
     * @return 该实例
     */
    public QueryParams clearOrder() {
        if (!this.baseOrders.isEmpty()) this.baseOrders.clear();
        return this;
    }
}
