package com.yls.core.sql;

import com.yls.core.jpql.BaseFilter;
import com.yls.core.jpql.QueryParams;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author yls
 * @Date 2020/3/24 10:33
 * @Description 解析SQL查询
 * @Version 1.0
 **/
public class NativeSQL {
    private static Logger logger = LoggerFactory.getLogger(NativeSQL.class);

    /**
     * @Author yls
     * @Description 全字段查询
     * @Date 2020/3/24 12:45
     * @param tableName 表名
     * @return java.lang.String
     **/
    public static String getSqlByAllCols(String tableName){
        return "select * from "+tableName+" where 1=1 ";
    }

    /**
     * @Author yls
     * @Description 返回基本的查询sql
     * @Date 2020/3/24 10:53
     * @param columns 字段集合
     * @param tableName 表名
     * @return java.lang.String
     **/
    public static String getSqlBySomeCols(List<String> columns,String tableName){
        if (columns==null || columns.isEmpty()){
            return null;
        }
        return "select "+StringUtils.join(columns,",")+" from "+tableName+" where 1=1 ";
    }

    /**
     * @Description 分析查询参数,并且合并到sql语句中
     * @param sql JPQL查询语句
     * @param params 查询参数
     * @return 参数对应的value
     */
    protected List<Object> analysisQueryParams(StringBuilder sql, QueryParams<?> params){
        List<String> strList = new ArrayList<>();
        List<Object> valueList = new ArrayList<>();
        int i = 1;
        //分析or条件
        for (BaseFilter filter : params.getOrBaseFilters()) {
            if (filter.getValue() != null){
                strList.add(filter.getProperty()+" " + filter.getOperator().getOperator()+" ?" + (i++));
                valueList.add(filter.getValue());
            }else {
                strList.add(filter.getProperty()+" " + filter.getOperator().getOperator()+" ");
            }
        }
        if (!strList.isEmpty()){
            sql.append(" and ").append("( ").append(StringUtils.join(strList," or ")).append(" )");
        }
        strList.clear();
        //分析and条件
        for (BaseFilter filter : params.getAndBaseFilters()) {
            if (filter.getValue() != null){
                strList.add(filter.getProperty()+" " + filter.getOperator().getOperator()+" ?" + (i++));
                valueList.add(filter.getValue());
            }else {
                strList.add(filter.getProperty()+" " + filter.getOperator().getOperator()+" ");
            }
        }
        sql.append(" and ").append(StringUtils.join(strList," and "));
        //分析排序字段
        if (!params.getBaseOrders().isEmpty()){
            sql.append(" order by ");
            sql.append(StringUtils.join(params.getBaseOrders(),","));
        }
        logger.debug("解析后的sql:"+sql.toString());
        logger.debug("对应的值为:"+valueList);
        return valueList;
    }

}
