package com.yls.common.utils;

import java.util.UUID;


/**
 * @Author yls
 * @Description 字符串工具类
 * @Date 2020/3/26 14:01
 **/
public class StringFormatUtils {

	/**
	 * @Description 判断是否为空
	 * @Date 2020/3/26 14:01
	 * @param s 字符串
	 * @return boolean
	 **/
	public static boolean isNull(String s) {
		if (s == null || "".equals(s.trim())) {
			return true;
		}
		return false;
	}

	/**
	 * @Description 字符串分割为字符串数组
	 * @param str 字符串
	 * @return java.lang.String[]
	 **/
	public static String[] split(String str) {
		return str==null || "".equals(str.trim()) ? null : str.split(",");
	}

	/**
	 * @Description 指定分割数组的大小
	 * @param str 字符串
	 * @param lenth 分割长度
	 * @param flag 分割符
	 * @return java.lang.String[]
	 **/
	public static String[] split(String str,String flag,Integer lenth) {
		return str==null || "".equals(str.trim()) ? null : str.split(flag,lenth);
	}

	/**
	 * @Description 判断字符串数组是否为空
	 * @param s String[]
	 * @return boolean True=值为空/null,False=非空
	 */
	public static boolean isNullArrs(String[] s) {
		if (s == null || s.length < 1) {
			return true;
		}
		return false;
	}

	/**
	 * @Description String转换成int
	 * @param s String
	 * @return int
	 */
	public static Integer toInt(String s) {
		int retVal = 0;
		if (s != null && !"".equals(s)) {
			retVal = Integer.parseInt(s);
		}
		return retVal;
	}

	/**
	 * @Description 生成UUID，全为小写
	 * @return java.lang.String
	 **/
	public static String uuidUpperCase() {
		return UUID.randomUUID().toString().toLowerCase().replaceAll("-", "");
	}


	/**
	 * @Description 生成原始的UUID
	 * @return java.lang.String
	 **/
	public static String getUUID(){
		return UUID.randomUUID().toString();
	}


	/**
	 * @Description String[]装换成int[]
	 * @param array String[]
	 * @return int[]
	 */
	public static int[] toInt(String[] array) {
		int[] retVal = null;
		if (array != null && array.length > 0) {
			retVal = new int[array.length];
		}
		for (int i = 0; i < array.length; i++) {
			if (isNull(array[i])) {
				retVal[i] = 0;
			} else {
				retVal[i] = Integer.parseInt(array[i]);
			}
		}
		return retVal;
	}

	/**
	 * @Description 字符串转换为Boolean
	 * @param s String “true” 或 “false”
	 * @return boolean 输入错误返回false
	 */
	public static Boolean toBoolean(String s) {
		if (s.equals("true") || s.equals("false")) {
			return Boolean.parseBoolean(s);
		}
		return false;
	}

	/**
	 * @Description  将数组转换为以逗号分隔的字符串
	 * @param array String数组
	 * @return String
	 */
	public static String arrayToString(String[] array) {
		return org.apache.commons.lang.StringUtils.join(array,",");
	}

	/**
	 * @Description 数组转字符串
	 * @param array 数组
	 * @param separator 分割符
	 * @return java.lang.String
	 **/
	public static String arrayToString(String[] array,String separator) {
		return org.apache.commons.lang.StringUtils.join(array,separator);
	}
}
