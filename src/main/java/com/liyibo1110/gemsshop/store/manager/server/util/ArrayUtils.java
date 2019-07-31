package com.liyibo1110.gemsshop.store.manager.server.util;

import org.apache.commons.lang3.StringUtils;

/**
 * 数组相关辅助工具，commons等库里都没有找到以下实用方法，和业务有点密切，先放到这里
 * @author liyibo
 *
 */
public class ArrayUtils {

	/**
	 * 将形如"123","321","1234567"这样的数组字符串转换成Integer数组
	 * @param stringArrayStr
	 * @return
	 */
	public static Integer[] stringToIntegerArray(String stringArrayStr){
		
		if(StringUtils.isBlank(stringArrayStr)){	//为null或为空直接返回null，必须放到前面
			return null;
		}
		
		//先检测stringArrayStr是不是单数字值，如果是，直接返回1个数字的数组
		if(StringUtils.isNumeric(stringArrayStr)){	//如果为空字符串，这里判断也会为true，比较诡异
			Integer[] integerArray = new Integer[1];
			integerArray[0] = Integer.parseInt(stringArrayStr);
			return integerArray;
		}
		
		if (stringArrayStr.contains(",")) {
			String[] stringArray = stringArrayStr.split(",");
			return stringArrayToIntegerArray(stringArray);
		}else{
			return null;
		}
	}
	
	/**
	 * 将有值的String数组转换成Integer数组
	 * @param stringArray
	 * @return
	 */
	public static Integer[] stringArrayToIntegerArray(String[] stringArray){
		Integer[] integerArray = new Integer[stringArray.length];
			
		for(int i = 0 ; i < stringArray.length ; i++){
			String str = stringArray[i];
			//如果字符是数字，符合要求，就开始生成查询问号和查询参数数组
			if(StringUtils.isNumeric(str)){
				integerArray[i] = Integer.parseInt(str);
			}else{	
				return null;	//如果数字有错则直接返回null，整体转换作废
			}
		}
		
		return integerArray;
	}
	
	public static String integerArrayToString(Integer[] array) {
		if(array == null) return null;
		StringBuilder sb = new StringBuilder();
		for(Integer i : array) {
			sb.append(i);
			sb.append(",");
		}
		if(sb.length() != 0) {
			sb.deleteCharAt(sb.length() - 1);
		}
		return sb.toString();
	}
	
	public static boolean isContainsNull(Integer[] integerArray){
		
		for(Integer i : integerArray){
			if(i == null){
				return true;
			}
		}
		
		return false;
	}
}
