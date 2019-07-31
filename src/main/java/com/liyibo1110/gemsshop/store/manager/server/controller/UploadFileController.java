package com.liyibo1110.gemsshop.store.manager.server.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.liyibo1110.gemsshop.store.manager.server.config.EnvConfig;
import com.liyibo1110.gemsshop.store.manager.server.dto.NullDTO;
import com.liyibo1110.gemsshop.store.manager.server.dto.OutputDTO;
import com.liyibo1110.gemsshop.store.manager.server.entity.StoreUser;
import com.liyibo1110.gemsshop.store.manager.server.entity.UploadFile;
import com.liyibo1110.gemsshop.store.manager.server.service.uploadfile.UploadFileCreateService;
import com.liyibo1110.gemsshop.store.manager.server.service.uploadfile.UploadFileListService;
import com.liyibo1110.gemsshop.store.manager.server.service.uploadfile.UploadFileModifyService;
import com.liyibo1110.gemsshop.store.manager.server.util.Constants;
import com.liyibo1110.gemsshop.store.manager.server.util.JsonUtils;

/**
 * 
 * @author liyibo
 *
 */
@Controller
public class UploadFileController {

	private static Logger logger = LoggerFactory.getLogger(UploadFileController.class);
	
	@Autowired
	private UploadFileListService uploadFileListService;
	
	@Autowired
	private UploadFileCreateService uploadFileCreateService;
	
	@Autowired
	private UploadFileModifyService uploadFileModifyService;
	
	@Autowired
	private EnvConfig envConfig;
	
	@RequestMapping("/api/uploadFile/list")
	public void list(HttpServletRequest request, HttpServletResponse response, 
					Integer groupId){
		
		StoreUser user = (StoreUser)request.getAttribute(Constants.USER_ATTRIBUTE_NAME);
		List<UploadFile> list = uploadFileListService.list(user, groupId);
		JsonUtils.outputJsonp(response, new OutputDTO<List<UploadFile>>(Constants.OUTPUTDTO_SUCCESS_STATUS, list));
	}
	
	@RequestMapping("/api/uploadFile/modify")
	public void modify(HttpServletRequest request, HttpServletResponse response,
					String ids, Integer groupId){
		StoreUser user = (StoreUser)request.getAttribute(Constants.USER_ATTRIBUTE_NAME);
		Integer result = uploadFileModifyService.modify(user, ids, groupId);
		
		JsonUtils.outputJsonp(response, new OutputDTO<Integer>(Constants.OUTPUTDTO_SUCCESS_STATUS, result));
	}
	
	@RequestMapping("/api/uploadFile/create")
	public void create(HttpServletRequest request, HttpServletResponse response,
					MultipartFile fileToUpload){
		
		StoreUser user = (StoreUser)request.getAttribute(Constants.USER_ATTRIBUTE_NAME);
		if(fileToUpload == null || fileToUpload.isEmpty()){
			
			//JsonUtils.outputJsonp(response, new OutputDTO<Integer>(Constants.OUTPUTDTO_FAILED_STATUS, 2));
			JsonUtils.outputJsonp(response, new OutputDTO<NullDTO>(Constants.OUTPUTDTO_FAILED_STATUS, 
																   Constants.OUTPUTDTO_UPLOAD_NO_FILE_ERRORCODE, 
																   Constants.OUTPUTDTO_UPLOAD_NO_FILE_ERRORCODE_MESSAGE, 
																   new NullDTO()));
		}
		String fileName = fileToUpload.getOriginalFilename();
		logger.info("fileName：" + fileName);
		long fileSize = fileToUpload.getSize();
		logger.info("fileSize：" + fileSize);
		//生成后端的文件名（yyyyMMddHHmmss+9位随机数字）
		String ext = StringUtils.substringAfter(fileName, ".");
		fileName = DateFormatUtils.format(System.currentTimeMillis(), "yyyyMMddHHmmss") + RandomStringUtils.randomNumeric(9) + '.' + ext;
		logger.info("新fileName为：" + fileName);
		//先保存实体文件
		File outputFile = new File(envConfig.getUploadGoodImagePath() + fileName);
		try {
			FileUtils.copyInputStreamToFile(fileToUpload.getInputStream(), outputFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Integer result = uploadFileCreateService.create(user, fileName, fileSize);
		JsonUtils.outputJsonp(response, new OutputDTO<Integer>(Constants.OUTPUTDTO_SUCCESS_STATUS, result));
	}
}
