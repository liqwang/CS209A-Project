package edu.sustech.backend.controller;

import edu.sustech.backend.service.MapServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("api/map")
public class MapController {
	//Todo: {two-code}:{count}
	@Autowired
	private MapServiceImpl mapServiceImpl;

	@RequestMapping("spring")
	public Map<String,Integer> getSpringData(){
		return mapServiceImpl.getSpringData();
	}
}
