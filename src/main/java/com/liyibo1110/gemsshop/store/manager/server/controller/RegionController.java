package com.liyibo1110.gemsshop.store.manager.server.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.liyibo1110.gemsshop.store.manager.server.dto.OutputDTO;
import com.liyibo1110.gemsshop.store.manager.server.entity.Region;
import com.liyibo1110.gemsshop.store.manager.server.service.region.RegionAllCityService;
import com.liyibo1110.gemsshop.store.manager.server.service.region.RegionAllProvinceService;
import com.liyibo1110.gemsshop.store.manager.server.util.Constants;
import com.liyibo1110.gemsshop.store.manager.server.util.JsonUtils;

/**
 * 
 * @author liyibo
 *
 */
@Controller
public class RegionController {

	private static Logger logger = LoggerFactory.getLogger(RegionController.class);
	
	@Autowired
	private RegionAllProvinceService regionAllProvinceService;
	
	@Autowired
	private RegionAllCityService regionAllCityService;
	
	@RequestMapping("/api/region/allProvince")
	public void allProvince(HttpServletRequest request, HttpServletResponse response){
		
		List<Region> list = regionAllProvinceService.all();
		JsonUtils.outputJsonp(response, new OutputDTO<List<Region>>(Constants.OUTPUTDTO_SUCCESS_STATUS, list));
	}
		
	@RequestMapping("/api/region/allCity")
	public void allCity(HttpServletRequest request, HttpServletResponse response){
		
		List<Region> list = regionAllCityService.all();
		JsonUtils.outputJsonp(response, new OutputDTO<List<Region>>(Constants.OUTPUTDTO_SUCCESS_STATUS, list));
	}

}
