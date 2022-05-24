package edu.sustech.backend.controller;

import edu.sustech.backend.service.BackendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

@RestController
@RequestMapping("api/map")
public class MapController {
	@Autowired
	private BackendService backendService;

	@RequestMapping("spring")
	public Map<String,Integer> getSpringData(){
		return backendService.getSpringData();
	}

	@RequestMapping("lombok")
	public Map<String,Integer> getLombokData(){
		return backendService.getLombokData();
	}

	@RequestMapping("log4j")
	public Map<String,Integer> getLog4jData(){
		return backendService.getLog4jData();
	}

	@RequestMapping("mysql")
	public String getMysqlData() throws IOException {
		return Files.readString(Path.of("backend/data/DependencyAnalysis/heatmapData/mysql.json"));
	}

//	@RequestMapping("spring")
//	public Map<String,Integer> getSpringData(){
//		return backendService.getSpringData();
//	}
//
//	@RequestMapping("lombok")
//	public Map<String,Integer> getLombokData(){
//		return backendService.getLombokData();
//	}
//
//	@RequestMapping("log4j")
//	public Map<String,Integer> getLog4jData(){
//		return backendService.getLog4jData();
//	}
//
//	@RequestMapping("mysql")
//	public Map<String,Integer> getMysqlData(){
//		return backendService.getMysqlData();
//	}

}
