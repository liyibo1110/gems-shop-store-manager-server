package com.liyibo1110.gemsshop.store.manager.server.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

/**
 * List相关辅助工具
 * @author liyibo
 *
 */
public class ListUtils {

	public static String integerListToString(List<Integer> list) {
		if(list == null) return null;
		StringBuilder sb = new StringBuilder();
		for(Integer i : list) {
			sb.append(i);
			sb.append(",");
		}
		if(sb.length() != 0) {
			sb.deleteCharAt(sb.length() - 1);
		}
		return sb.toString();
	}
	
	public static List<Integer> stringToIntegerList(String str){
		if(StringUtils.isBlank(str)) {
			return null;
		}else {
			List<Integer> list = new ArrayList<>();
			String[] arrays = StringUtils.split(str, ",");
			for(String s : arrays) {
				list.add(Integer.parseInt(s));
			}
			return list;
		}
	}
}
