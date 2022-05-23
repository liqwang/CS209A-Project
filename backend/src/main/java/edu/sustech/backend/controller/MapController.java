package edu.sustech.backend.controller;

import edu.sustech.backend.service.MapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("api/map")
public class MapController {
	//Todo: {two-code}:{count}
	@Autowired
	private MapService mapService;

	@RequestMapping("spring")
	public Map<String,Integer> getSpringData(){
		return mapService.getSpringData();
	}
}
