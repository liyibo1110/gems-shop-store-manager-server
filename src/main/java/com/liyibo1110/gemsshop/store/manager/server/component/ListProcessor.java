package com.liyibo1110.gemsshop.store.manager.server.component;

import java.lang.reflect.Method;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * List工具组件
 * @author liyibo
 *
 */
@Component
public class ListProcessor<T> {

	private static Logger logger = LoggerFactory.getLogger(ListProcessor.class);
	
	/**
	 * 将list特定字段，读取并连成字符串，用逗号分隔
	 * @param list
	 * @param propertyName
	 * @return
	 */
	public String propertyToStrings(List<T> list, String propertyName) {
		StringBuilder sb = new StringBuilder();
		
		for(T obj : list) {
			Method method = null;
			Object resultObj = null;
			//获取get方法名，例如getId()
			String getMethodName = "get" + propertyName.substring(0, 1).toUpperCase() + propertyName.substring(1);
			try {
				method = obj.getClass().getMethod(getMethodName);
				resultObj = method.invoke(obj);
			} catch (Exception e) {
				e.printStackTrace();
			} 	
			
			sb.append(resultObj);
			sb.append(",");
		}
		
		if(sb.length() != 0) {
			sb.deleteCharAt(sb.length() - 1);
		}
		return sb.toString();
	}
}
