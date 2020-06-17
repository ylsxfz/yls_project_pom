package com.yls.core.jpql;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import java.io.Serializable;

/**
 * @Author yls
 * @Date 2020/3/22 13:21
 * @Description 查询条件  and or 大于 小于 等于...
 * @Version 1.0
 **/
public class BaseFilter implements Serializable {

    private static final long serialVersionUID = -8712382358441065075L;

    /**
     * @Author yls
     * @Description 枚举
     * @Date 2020/3/22 13:25
     **/
    public enum Operator {

        // 等于
        eq(" = "),

        // 不等于
        ne(" != "),

        // 大于
        gt(" > "),

        // 小于
        lt(" < "),

        // 大于等于
        ge(" >= "),

        // 小于等于
        le(" <= "),

        // 类似
        like(" like "),

        // 包含
        in(" in "),

        // 为Null
        isNull(" is NULL "),

        // 不为Null
        isNotNull(" is not NULL ");
        Operator(String operator) {
            this.operator = operator;
        }

        private String operator;

        public String getOperator() {
            return operator;
        }

        public void setOperator(String operator) {
            this.operator = operator;
        }
    }

    // 默认是否忽略大小写
    private static final boolean DEFAULT_IGNORE_CASE = false;

    // 属性
    private String property;

    // 运算符
    private Operator operator;

    // 值
    private Object value;

    // 是否忽略大小写
    private Boolean ignoreCase = DEFAULT_IGNORE_CASE;

    /**
     * 构造方法
     */
    public BaseFilter() {
    }

    /**
     * @Author yls
     * @Description
     * @Date 2020/3/22 14:21
     * @param property 属性
     * @param operator 运算法
     * @param value 属性值
     * @return
     **/
    public BaseFilter(String property, Operator operator, Object value) {
        this.property = property;
        this.operator = operator;
        this.value = value;
    }

    /**
     * @Author yls
     * @Description
     * @Date 2020/3/22 14:22
     * @param property 属性
     * @param operator 运算符
     * @param value 值
     * @param ignoreCase 忽略大小写
     * @return
     **/
    public BaseFilter(String property, Operator operator, Object value, boolean ignoreCase) {
        this.property = property;
        this.operator = operator;
        this.value = value;
        this.ignoreCase = ignoreCase;
    }

    /**
     * @Author yls
     * @Description 等于
     * @Date 2020/3/22 14:22
     * @param property 属性
     * @param value 值
     * @return com.spring.yls_extjs6.base.jpql.BaseFilter
     **/
    public static BaseFilter eq(String property, Object value) {
        return new BaseFilter(property, Operator.eq, value);
    }

    /**
     * @Author yls
     * @Description 等于
     * @Date 2020/3/22 14:23
     * @param property 属性
     * @param value 值
     * @param ignoreCase 忽略大小写
     * @return com.spring.yls_extjs6.base.jpql.BaseFilter
     **/
    public static BaseFilter eq(String property, Object value, boolean ignoreCase) {
        return new BaseFilter(property, Operator.eq, value, ignoreCase);
    }

    /**
     * @Author yls
     * @Description 不等于
     * @Date 2020/3/22 14:23
     * @param property 属性
     * @param value 值
     * @return com.spring.yls_extjs6.base.jpql.BaseFilter
     **/
    public static BaseFilter ne(String property, Object value) {
        return new BaseFilter(property, Operator.ne, value);
    }

    /**
     * @Author yls
     * @Description 不等于
     * @Date 2020/3/22 14:23
     * @param property 属性
     * @param value 值
     * @param ignoreCase 忽略大小写
     * @return com.spring.yls_extjs6.base.jpql.BaseFilter
     **/
    public static BaseFilter ne(String property, Object value, boolean ignoreCase) {
        return new BaseFilter(property, Operator.ne, value, ignoreCase);
    }

    /**
     * @Author yls
     * @Description 大于
     * @Date 2020/3/22 14:24
     * @param property 属性
     * @param value 值
     * @return com.spring.yls_extjs6.base.jpql.BaseFilter
     **/
    public static BaseFilter gt(String property, Object value) {
        return new BaseFilter(property, Operator.gt, value);
    }

    /**
     * @Author yls
     * @Description 小于
     * @Date 2020/3/22 14:24
     * @param property 属性
     * @param value 值
     * @return com.spring.yls_extjs6.base.jpql.BaseFilter
     **/
    public static BaseFilter lt(String property, Object value) {
        return new BaseFilter(property, Operator.lt, value);
    }

    /**
     * @Author yls
     * @Description 大于等于
     * @Date 2020/3/22 14:24
     * @param property 属性
     * @param value 值
     * @return com.spring.yls_extjs6.base.jpql.BaseFilter
     **/
    public static BaseFilter ge(String property, Object value) {
        return new BaseFilter(property, Operator.ge, value);
    }

    /**
     * @Author yls
     * @Description 小于等于
     * @Date 2020/3/22 14:25
     * @param property 属性
     * @param value 值
     * @return com.spring.yls_extjs6.base.jpql.BaseFilter
     **/
    public static BaseFilter le(String property, Object value) {
        return new BaseFilter(property, Operator.le, value);
    }

    /**
     * @Author yls
     * @Description 相似（模糊查询）
     * @Date 2020/3/22 14:25
     * @param property 属性
     * @param value 值
     * @return com.spring.yls_extjs6.base.jpql.BaseFilter
     **/
    public static BaseFilter like(String property, Object value) {
        return new BaseFilter(property, Operator.like, value);
    }

    /**
     * @Author yls
     * @Description 包含
     * @Date 2020/3/22 14:26
     * @param property 属性
     * @param value 值
     * @return com.spring.yls_extjs6.base.jpql.BaseFilter
     **/
    public static BaseFilter in(String property, Object value) {
        return new BaseFilter(property, Operator.in, value);
    }

    /**
     * @Author yls
     * @Description 返回为null筛选
     * @Date 2020/3/22 14:26
     * @param property 属性
     * @return com.spring.yls_extjs6.base.jpql.BaseFilter
     **/
    public static BaseFilter isNull(String property) {
        return new BaseFilter(property, Operator.isNull, null);
    }

    /**
     * @Author yls
     * @Description 返回不为null的筛选
     * @Date 2020/3/22 14:26
     * @param property 属性
     * @return com.spring.yls_extjs6.base.jpql.BaseFilter
     **/
    public static BaseFilter isNotNull(String property) {
        return new BaseFilter(property, Operator.isNotNull, null);
    }

    /**
     * @Author yls
     * @Description 忽略大小写
     * @Date 2020/3/22 14:27
     * @param
     * @return com.spring.yls_extjs6.base.jpql.BaseFilter
     **/
    public BaseFilter ignoreCase() {
        this.ignoreCase = true;
        return this;
    }

    /**
     * @Description 获取属性
     * @return java.lang.String
     **/
    public String getProperty() {
        return property;
    }

    /**
     * @param property 设置属性
     * @return void
     **/
    public void setProperty(String property) {
        this.property = property;
    }

    /**
     * @Description 获取运算符
     * @return com.spring.yls_extjs6.base.jpql.BaseFilter.Operator
     **/
    public Operator getOperator() {
        return operator;
    }

    /**
     * @Description 设置运算符
     * @param operator 运算符
     * @return void
     **/
    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    /**
     * @Description 获取值
     * @return java.lang.Object
     **/
    public Object getValue() {
        return value;
    }

    /**
     * @Description 设置值
     * @param value 值
     * @return void
     **/
    public void setValue(Object value) {
        this.value = value;
    }

    /**
     * @Description 获取是否忽略大小写
     * @return 是否忽略大小写
     */
    public Boolean getIgnoreCase() {
        return ignoreCase;
    }

    /**
     * @Description 设置是否忽略大小写
     * @param ignoreCase 是否忽略大小写
     */
    public void setIgnoreCase(Boolean ignoreCase) {
        this.ignoreCase = ignoreCase;
    }

    /**
     * @Description 重写equals方法
     * @param obj 对象
     * @return 是否相等
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        BaseFilter other = (BaseFilter) obj;
        return new EqualsBuilder().append(getProperty(), other.getProperty()).append(getOperator(), other.getOperator()).append(getValue(), other.getValue()).isEquals();
    }

    /**
     * @Description 重写hashCode方法
     * @return HashCode
     */
    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(getProperty()).append(getOperator()).append(getValue()).toHashCode();
    }

}
