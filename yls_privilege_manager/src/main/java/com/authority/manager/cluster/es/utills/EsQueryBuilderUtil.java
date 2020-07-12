package com.authority.manager.cluster.es.utills;


import com.authority.manager.cluster.es.model.EsPageRequest;
import com.authority.manager.cluster.es.model.EsRangeBO;
import com.yls.common.utils.StringFormatUtils;
import org.elasticsearch.index.query.*;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Auther: yls
 * @Date: 2020/6/5 9:08
 * @Description:
 * @Version 1.0
 */
public class EsQueryBuilderUtil {


    public static final String FLAG = ".whitespace";

    public static final String ES_DATE_FORMAT="yyyy-MM-dd HH:mm:ss";

    public static void main(String[] args) {
        EsPageRequest esPageRequest = new EsPageRequest();
        esPageRequest.getRangFieldMap().put("set",new EsRangeBO());
        esPageRequest.getFieldValueMap().put("a","");
        esPageRequest.getFieldValueMap().put("b","null");
        getQueryBuilder(esPageRequest,null);
    }

    /**
     * 功能描述:
     * 〈解析es的查询条件〉
     *
     * @author : yls
     * @date : 2020/6/13 10:09
     * @param esPageRequest es的查询条件
     * @return : org.elasticsearch.index.query.BoolQueryBuilder
     */
    public static QueryBuilder getQueryBuilder(EsPageRequest esPageRequest,BoolQueryBuilder boolQueryBuilder){
        /**
         * 1、解析查询条件
         */
        //全文检索map
        Map<String,Object> orFiledValueMap = new HashMap<>();
        //字段map
        Map<String, Object> fieldValueMap = esPageRequest.getFieldValueMap();
        List<String> nullFieldKey = new ArrayList<>();
        fieldValueMap.forEach((key,value)->{
            if (value==null || StringFormatUtils.isNull(value.toString())){
                nullFieldKey.add(key);
            }
            if (key.contains(",") && value!=null && !StringFormatUtils.isNull(value.toString())){
                String[] split = key.split(",");
                for (String filed:
                     split) {
                    orFiledValueMap.put(filed,value.toString());
                    nullFieldKey.add(key);
                }
            }
        });
        nullFieldKey.forEach(nullKey->{
            if (fieldValueMap.containsKey(nullKey)){
                fieldValueMap.remove(nullKey);
            }

        });

        //过滤范围性查询：最大值、最小值均为null的key
        Map<String, EsRangeBO> rangFieldMap = esPageRequest.getRangFieldMap();
        List<String> nullRangValueKey = new ArrayList<>();
        rangFieldMap.forEach((key,esRangeBO)->{
            if (esRangeBO==null){
                nullRangValueKey.add(key);
            }else {
                Object maxValue = esRangeBO.getMaxValue();
                Object minValue = esRangeBO.getMinValue();
                //空值判断
                if ((maxValue==null || StringFormatUtils.isNull(maxValue.toString())) &&
                        (minValue==null || StringFormatUtils.isNull(minValue.toString())) ){
                    nullRangValueKey.add(key);
                }
            }
        });

        nullRangValueKey.forEach(nullKey->{
            rangFieldMap.remove(nullKey);
        });

        /**
         * 2、组装查询
         */
        //字段类型查询map为空，并且范围性查询map也为空，查询改为全查询
        if (fieldValueMap.isEmpty() && rangFieldMap.isEmpty()){
           return QueryBuilders.matchAllQuery();
        }

        //字段性查询map不为空或者范围性查询map不为空
        //并且
        BoolQueryBuilder resultBoolQueryBuilder = andMatchUnionWithFields(boolQueryBuilder, esPageRequest.getFieldValueMap(),true);
        //或者
        BoolQueryBuilder orBoolQueryBuilder = andMatchUnionWithFields(null, orFiledValueMap, false);
        //拼接或者关系
        resultBoolQueryBuilder.must(orBoolQueryBuilder);
        //拼接范围性参数
        Set<String> keys = rangFieldMap.keySet();
        for (String field:keys) {
            RangeQueryBuilder rangeQueryBuilder = EsQueryBuilderUtil.rangeMathQuery(field, rangFieldMap.get(field));
            if (rangeQueryBuilder!=null){
                resultBoolQueryBuilder.must(rangeQueryBuilder);
            }
        }
        return  resultBoolQueryBuilder;
    }


    /**
     * 功能描述:
     * 〈设置高亮〉
     *
     * @author : yls
     * @date : 2020/6/4 17:52
     * @param field
     * @return : org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder
     */
    public static HighlightBuilder getHighlighBuilder(String field){
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.preTags("<span color=red>");
        highlightBuilder.postTags("</span>");
        highlightBuilder.field("*");
        highlightBuilder.requireFieldMatch(false);
        return highlightBuilder;
    }

    /**
     * 功能描述:
     * 〈单条件检索，适用于搜索比如包含腾讯大王卡的用户〉
     *
     * @author : yls
     * @date : 2020/6/5 9:11
     * @param fieldKey 字段key
     * @param fieldValue 字段值
     * @return : org.elasticsearch.index.query.MatchPhraseQueryBuilder
     */
    public static MatchPhraseQueryBuilder uniqueMatchQuery(String fieldKey,String fieldValue){
        return  QueryBuilders.matchPhraseQuery(fieldKey + FLAG, fieldValue);
    }


    /**
     * 功能描述:
     * 〈多条件检索并集，适用于搜索比如包含腾讯大王卡，滴滴大王卡的用户〉
     *
     * @author : yls
     * @date : 2020/6/5 9:17
     * @param fieldKey 字段key
     * @param queryList 多个字段值
     * @return : org.elasticsearch.index.query.BoolQueryBuilder
     */
    public static BoolQueryBuilder orMatchUnionWithList(String fieldKey, List<Object> queryList){
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        for (Object fieldValue:queryList) {
            //boolQueryBuilder.should(QueryBuilders.matchPhraseQuery(fieldKey+FLAG,queryValue));
            QueryBuilder queryBuilder = getQueryBUilderByFieldType(fieldKey, fieldValue);
            boolQueryBuilder.should(queryBuilder);
        }
        return boolQueryBuilder;
    }


    /**
     * 功能描述:
     * 〈多条件检索并集，适用于搜索比如包含腾讯大王卡，滴滴大王卡的用户〉
     *
     * @author : yls
     * @date : 2020/6/5 9:17
     * @param fieldMap 字段Map  多个字段值 或的关系
     * @return : org.elasticsearch.index.query.BoolQueryBuilder
     */
    public static BoolQueryBuilder orMatchUnionWithFields(Map<String,Object> fieldMap){
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        Set<String> fieldKeys = fieldMap.keySet();
        for (String field:fieldKeys) {
            Object fieldValue = fieldMap.get(field);
            QueryBuilder queryBuilder = getQueryBUilderByFieldType(field, fieldValue);
            boolQueryBuilder.should(queryBuilder);
        }
        return boolQueryBuilder;
    }

    /**
     * 功能描述:
     * 〈多条件检索并集，适用于搜索比如包含腾讯大王卡，滴滴大王卡的用户〉
     *
     * @author : yls
     * @date : 2020/6/5 9:17
     * @param fieldMap 字段Map  多个字段值 或的关系
     * @return : org.elasticsearch.index.query.BoolQueryBuilder
     */
    public static BoolQueryBuilder andMatchUnionWithFields(BoolQueryBuilder boolQueryBuilder,Map<String,Object> fieldMap,boolean isAnd){
        if (boolQueryBuilder == null){
            boolQueryBuilder = QueryBuilders.boolQuery();
        }
        Set<String> fieldKeys = fieldMap.keySet();
        for (String field:fieldKeys) {
            Object fieldValue = fieldMap.get(field);
            //boolQueryBuilder.should(QueryBuilders.matchPhraseQuery(field+FLAG,fieldValue));
            QueryBuilder queryBuilder = getQueryBUilderByFieldType(field, fieldValue);
            if (isAnd){
                boolQueryBuilder.must(queryBuilder);
            }else{
                boolQueryBuilder.should(queryBuilder);
            }

        }
        return boolQueryBuilder;
    }

    /**
     * 功能描述:
     * 〈范围查询〉
     *
     * @author : yls
     * @date : 2020/6/5 13:27
     * @param fieldKey 查询的字段
     * @param esRangeBO 范围查询的实体
     * @return : org.elasticsearch.index.query.RangeQueryBuilder
     */
    public static RangeQueryBuilder rangeMathQuery(String fieldKey, EsRangeBO esRangeBO){
        RangeQueryBuilder rangeQueryBuilder = QueryBuilders.rangeQuery(fieldKey);
        Object maxValue = esRangeBO.getMaxValue();
        Object minValue = esRangeBO.getMinValue();
        //空值判断
        if ((maxValue==null || StringFormatUtils.isNull(maxValue.toString())) &&
                (minValue==null || StringFormatUtils.isNull(minValue.toString())) ){
            return null;
        }

        if(maxValue==null || StringFormatUtils.isNull(maxValue.toString())){
            //没有值，不拼接条件
        }
        else if ("<=".equals(esRangeBO.getMaxComparator())){
            rangeQueryBuilder.lte(maxValue);
        }else{
            rangeQueryBuilder.lt(maxValue);
        }

        if (minValue==null || StringFormatUtils.isNull(minValue.toString())){
            //没有值，不拼接条件
        }
        else if ("<=".equals(esRangeBO.getMinComparator())){
            rangeQueryBuilder.gte(minValue);
        }else{
            rangeQueryBuilder.gt(minValue);
        }
        return rangeQueryBuilder;
    }




    /**
     * 功能描述:
     * 〈根据字段类型获取查询方式〉
     *
     * @author : yls
     * @date : 2020/6/5 15:18
     * @param field 字段名
     * @param fieldValue 字段值
     * @return : org.elasticsearch.index.query.QueryBuilder
     */
    public static QueryBuilder getQueryBUilderByFieldType(String field,Object fieldValue){
        Map<String, String> booleanMap = MailFieldTypeUtils.getBooleanMap();
        Map<String, String> dateMap = MailFieldTypeUtils.getDateMap();
        Map<String, String> whitespaceMap = MailFieldTypeUtils.getWhitespaceMap();
        Map<String, String> numberMap = MailFieldTypeUtils.getNumberMap();
        Map<String, String> filedMap = MailFieldTypeUtils.getFiledMap();


        if (numberMap.containsKey(field)){
            return QueryBuilders.matchQuery(field,fieldValue);
        }

        if (whitespaceMap.containsKey(field)){
            return QueryBuilders.matchPhraseQuery(field+FLAG,fieldValue);
        }

        if (booleanMap.containsKey(field)){
            return QueryBuilders.matchQuery(field,fieldValue);
        }

        if (filedMap.containsKey(field)){
            return QueryBuilders.matchQuery(field,fieldValue);
        }

        if (dateMap.containsKey(field)){
            return QueryBuilders.matchPhraseQuery(field,fieldValue);
        }

        return  QueryBuilders.matchQuery(field,fieldValue);
    }



    /**
     * @Description 将字符串转换成日期类型数据
	 * @param s String 日期字符串
	 * @param format String 转换格式(如:yyyy-MM-dd HH:mm:ss)
	 * @return java.util.Date 日期类型
	 * @throws ParseException
	 */
    public static Date parseDate(String s, String format) throws ParseException {
        if(format==null || "".equals(format)) {
            format = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.parse(s);
    }


    /**
     * @Description 将日期类型数据转换成字符串
     * @param d java.util.Date 日期类型
     * @param format String 转换格式(如:yyyy-MM-dd HH:mm:ss)
     * @return String 日期字符串
     */
    public static String toString(Date d, String format) {
        if(format==null || "".equals(format)) {
            format = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(d);
    }


}
