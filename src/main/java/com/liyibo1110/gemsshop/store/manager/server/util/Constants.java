package com.liyibo1110.gemsshop.store.manager.server.util;

/**
 * 定义系统一些简单常量类
 * @author liyibo
 *
 */
public class Constants {

	public static final String SESSION_USER = "_session_user"; // 个人用户会话session
	//public static final String ADMIN_HEADER_TOKEN = "Admin-Token"; // 管理员token
	public static final String USER_HEADER_TOKEN = "User-Token"; // 用户token
	//public static final String USER_HEADER_ROLE = "User-Role"; // 用户role
	//public static final String ADMIN_ATTRIBUTE_NAME = "_admin_attribute_name"; // 通过request对象从拦截器传到controller层的管理员对象属性名称
	public static final String USER_ATTRIBUTE_NAME = "_user_attribute_name"; // 通过request对象从拦截器传到controller层的用户对象属性名称
	//定义输出DTO的status成功参数
	public static final Integer OUTPUTDTO_SUCCESS_STATUS = 1;
	public static final Integer OUTPUTDTO_FAILED_STATUS = 0;
	
	public static final Integer OUTPUTDTO_NO_TOKEN_ERRORCODE = 101;	//请求header中没有user_token字段
	public static final String OUTPUTDTO_NO_TOKEN_ERRORCODE_MESSAGE = "非法请求，没有token字段";
	
	public static final Integer OUTPUTDTO_INVAILD_TOKEN_ERRORCODE = 102;	//请求传了user_token字段，但是找不到对应用户
	public static final String OUTPUTDTO_INVAILD_TOKEN_ERRORCODE_MESSAGE = "非法请求，token错误";
	
	public static final Integer OUTPUTDTO_NO_ROLE_ERRORCODE = 103;	//请求header中没有user_role字段
	public static final String OUTPUTDTO_NO_ROLE_ERRORCODE_MESSAGE = "非法请求，没有role字段";
	
	public static final Integer OUTPUTDTO_INVAILD_ROLE_ERRORCODE = 104;	//请求传了user_role字段，但是低于api要求的权限
	public static final String OUTPUTDTO_INVAILD_ROLE_ERRORCODE_MESSAGE = "非法请求，权限不足";	
	
	public static final Integer OUTPUTDTO_INVAILD_USERNAME_ERRORCODE = 105;	//用户名或密码错误（只在登录接口会返回）
	public static final String OUTPUTDTO_INVAILD_USERNAME_ERRORCODE_MESSAGE = "用户名或密码错误";
	
	public static final Integer OUTPUTDTO_ARGS_INVAILD_ERRORCODE = 201;	//参数非法，通用error
	public static final String OUTPUTDTO_ARGS_INVAILD_ERRORCODE_MESSAGE = "参数非法";	
	
	public static final Integer OUTPUTDTO_UPLOAD_NO_FILE_ERRORCODE = 301;	//请求header中没有user_token字段
	public static final String OUTPUTDTO_UPLOAD_NO_FILE_ERRORCODE_MESSAGE = "上传文件为空";
}
