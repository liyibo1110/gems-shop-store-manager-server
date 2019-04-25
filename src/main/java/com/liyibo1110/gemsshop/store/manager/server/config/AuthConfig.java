package com.liyibo1110.gemsshop.store.manager.server.config;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.alibaba.fastjson.JSONObject;
import com.liyibo1110.gemsshop.store.manager.server.dao.StoreUserDao;
import com.liyibo1110.gemsshop.store.manager.server.dto.NullDTO;
import com.liyibo1110.gemsshop.store.manager.server.dto.OutputDTO;
import com.liyibo1110.gemsshop.store.manager.server.entity.StoreUser;
import com.liyibo1110.gemsshop.store.manager.server.util.Constants;

@Configuration
public class AuthConfig implements WebMvcConfigurer {

	private static Logger logger = LoggerFactory.getLogger(AuthConfig.class);
	
	@Autowired
	public StoreUserDao storeUserDao;
	
	@Bean
    public SecurityInterceptor getSecurityInterceptor() {
        return new SecurityInterceptor();
    }
	
	public void addInterceptors(InterceptorRegistry registry) {
        
		InterceptorRegistration addInterceptor = registry.addInterceptor(getSecurityInterceptor());
        // 排除配置
		addInterceptor.excludePathPatterns("/api/storeUser/login");
        addInterceptor.excludePathPatterns("/api/storeUser/logout");
        addInterceptor.excludePathPatterns("/js/*");
        addInterceptor.excludePathPatterns("/apilist");
        
        
       /* addInterceptor.excludePathPatterns("/apilist");
        addInterceptor.excludePathPatterns("/data/updateCityGeometry");
        addInterceptor.excludePathPatterns("/export/exportCommentExcel");
        addInterceptor.excludePathPatterns("/export/exportPropertyExcel");
        addInterceptor.excludePathPatterns("/export/exportCommentAccess");
        addInterceptor.excludePathPatterns("/export/excel/download");
        addInterceptor.excludePathPatterns("/export/access/download");
        // 排除watch接口的拦截，因为他们目前不能发送cookie，是纯无状态的请求，只能放过
        addInterceptor.excludePathPatterns("/productGroup/uploadWatch");
        addInterceptor.excludePathPatterns("/product/uploadWatch");
        addInterceptor.excludePathPatterns("/hotelUser/uploadWatch");
        addInterceptor.excludePathPatterns("/manual/uploadDeleteCommentByProductIdWatch");
        addInterceptor.excludePathPatterns("/export/exportCommentExcelWatch");
        addInterceptor.excludePathPatterns("/export/exportCommentAccessWatch");*/
        
        // 拦截配置
        addInterceptor.addPathPatterns("/**");
        
        //logger.info("拦截器配置完成");
    }
	
	private class SecurityInterceptor extends HandlerInterceptorAdapter {

		/*private List<Api> apiList = new ArrayList<>();
		
		private class Api {
			public String url;
			public Integer role;	//目前只有1和2
			public Api(String url, Integer role) {
				this.url = url;
				this.role = role;
			}
		}*/
		
		/**
		 * 所有用户级别接口都要在这里冗余注册，就不用AOP之类的东西了
		 */
		/*@PostConstruct
		private void initApiList() {
			apiList.add(new Api("/api/store/all", 2));
			
			apiList.add(new Api("/api/room/list", 2));
			apiList.add(new Api("/api/room/count", 2));
			
			apiList.add(new Api("/api/worker/list", 2));
			apiList.add(new Api("/api/worker/count", 2));
			apiList.add(new Api("/api/worker/create", 2));
			apiList.add(new Api("/api/worker/modify", 2));
			apiList.add(new Api("/api/worker/unbindCamera", 2));
			apiList.add(new Api("/api/worker/bindCamera", 2));
			apiList.add(new Api("/api/worker/unbindPivot", 2));
			apiList.add(new Api("/api/worker/bindPivot", 2));
			
			apiList.add(new Api("/api/video/list", 2));
			apiList.add(new Api("/api/video/count", 2));
			apiList.add(new Api("/api/video/modify", 2));
			
			apiList.add(new Api("/api/camera/unusedList", 2));
			apiList.add(new Api("/api/pivot/unusedList", 2));
		}*/
		
        @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
                throws Exception {
        	
        	//获取header字段
        	String userToken = request.getHeader(Constants.USER_HEADER_TOKEN);
        	//String userRole = request.getHeader(Constants.USER_HEADER_ROLE);
        	
        	//检测有没有
        	if(!checkHasToken(response, userToken)) {
        		logger.info("checkHasToken失败了！");
        		return false;
        	}
        	/*if(!checkHasRole(response, userRole)) {
        		return false;
        	}*/
        	//检测token对不对
        	if(!checkHasUser(request, response, userToken)) {
        		logger.info("checkHasUser失败了！");
        		return false;
        	}
        	//检测role够不够要求
        	/*if(!checkHasPermission(response, request.getRequestURI(), Integer.parseInt(userRole))) {
        		return false;
        	}*/
        	//都没问题了，可以真正访问接口了
            return true;
        }
        
        private boolean checkHasToken(HttpServletResponse response, String token) throws Exception{
			if(StringUtils.isBlank(token)) {
        		this.outputFailed(response, Constants.OUTPUTDTO_NO_TOKEN_ERRORCODE, Constants.OUTPUTDTO_NO_TOKEN_ERRORCODE_MESSAGE);
        		return false;
        	}else {
        		return true;
        	}
		}
		
		/*private boolean checkHasRole(HttpServletResponse response, String userRole) throws Exception{
			if(StringUtils.isBlank(userRole)) {
				this.outputFailed(response, Constants.OUTPUTDTO_NO_ROLE_ERRORCODE, Constants.OUTPUTDTO_NO_ROLE_ERRORCODE_MESSAGE);
        		return false;
        	}else {
        		return true;
        	}
		}*/
		
		private boolean checkHasUser(HttpServletRequest request, HttpServletResponse response, String userToken) throws Exception{
			StoreUser user = storeUserDao.getByToken(userToken);
        	if(user == null) {
        		this.outputFailed(response, Constants.OUTPUTDTO_INVAILD_TOKEN_ERRORCODE, Constants.OUTPUTDTO_INVAILD_TOKEN_ERRORCODE_MESSAGE);
        		return false;
        	}else {
        		request.setAttribute(Constants.USER_ATTRIBUTE_NAME, user);
        		return true;
        	}
		}
		
		/*private boolean checkHasPermission(HttpServletResponse response, String requestUrl, Integer userRole) throws Exception{
        	for(Api api : this.apiList) {
        		//传来的role值，要小于等于接口需要的role值
        		if(Objects.equals(requestUrl, api.url) && userRole <= api.role.intValue()) {
        			return true;
        		}
        	}
        	this.outputFailed(response, Constants.OUTPUTDTO_INVAILD_ROLE_ERRORCODE, Constants.OUTPUTDTO_INVAILD_ROLE_ERRORCODE_MESSAGE);
        	return false;
		}*/
        
        private void outputFailed(HttpServletResponse response, Integer errorCode, String errorMsg) throws Exception{
    		response.setContentType("application/json; charset=utf-8");
    		PrintWriter out = null;  
    		out = response.getWriter(); 
    		OutputDTO<NullDTO> outputDTO = new OutputDTO<NullDTO>(Constants.OUTPUTDTO_FAILED_STATUS, errorCode, errorMsg, new NullDTO());
    		out.append(JSONObject.toJSONString(outputDTO));  
    		out.flush();
    	}
    }
}
