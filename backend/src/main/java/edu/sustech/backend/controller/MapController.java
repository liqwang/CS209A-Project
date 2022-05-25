package edu.sustech.backend.controller;

import edu.sustech.backend.service.BackendService;
import edu.sustech.backend.service.models.ReactiveMapEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/map")
public class MapController {
	@Autowired
	private BackendService backendService;

	@CrossOrigin
	@RequestMapping("spring")
	public List<ReactiveMapEntry> getSpringData(){
		return backendService.getSpringData().entrySet().stream()
				.map(e->new ReactiveMapEntry(e.getKey(),e.getValue()))
				.collect(Collectors.toList());
	}

	@CrossOrigin
	@RequestMapping("lombok")
	public List<ReactiveMapEntry> getLombokData(){
		return backendService.getLombokData().entrySet().stream()
				.map(e->new ReactiveMapEntry(e.getKey(),e.getValue()))
				.collect(Collectors.toList());
	}

	@CrossOrigin
	@RequestMapping("log4j")
	public List<ReactiveMapEntry> getLog4jData(){
		return backendService.getLog4jData().entrySet().stream()
				.map(e->new ReactiveMapEntry(e.getKey(),e.getValue()))
				.collect(Collectors.toList());
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

	@CrossOrigin
	@RequestMapping("mysql")
	public String getMysqlData() throws IOException {
		return Files.readString(Path.of("backend/data/DependencyAnalysis/heatmapData/mysql.json"));
	}

}
