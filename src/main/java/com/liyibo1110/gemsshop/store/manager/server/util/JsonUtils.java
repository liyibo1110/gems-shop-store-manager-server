package com.liyibo1110.gemsshop.store.manager.server.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;

import com.alibaba.fastjson.JSON;

/**
 * Json相关便利工具，目前只提供JSONP的最外层封装方法
 * @author liyibo
 *
 */
public class JsonUtils {

	public static void outputJsonp(HttpServletResponse response, Object obj){
		String result = JSON.toJSONString(obj);
		response.setContentType("application/json; charset=utf-8");
		//response.setHeader("Access-Control-Allow-Origin", "*");
		PrintWriter out = null;
		try {  
			//未登录则返回特定的DTO对象
	        out = response.getWriter();  
	        out.append(result);  
	        out.flush();
	    } catch (IOException e) {  
	        e.printStackTrace();  
	    } finally {  
	        IOUtils.closeQuietly(out); 
	    } 
	}
}
