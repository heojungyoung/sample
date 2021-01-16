package com.sample.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sample.sample.model.BaseResponse;
import com.sample.sample.model.svcModel;
import com.sample.sample.service.sampleService;

@RestController
@RequestMapping("/sample")
public class sampleController {
	
	@Autowired
	sampleService sampleService;
	
	@GetMapping("/getSampleList")
	public BaseResponse getDeployHistoryList(
			@RequestParam(required = false) String plcyId)  {
	   return new BaseResponse(sampleService.getSampleList(plcyId));
	}
	
	@GetMapping("/getSvcList")
	public BaseResponse getSvcList(
			@RequestParam(required = false) String mdlYear)  {
		
		List<svcModel> finalList = null;
		
		// List<svcModel> list =  sampleService.getSvcList(mdlYear);
		
	//	for(svcModel svcMdl : list) {
	//		finalList.add(svcMdl);
	//	}
		
	//	System.out.println(finalList);
		return new BaseResponse(sampleService.getSvcList(mdlYear));
	}
	
	
	@RequestMapping(path = "/index")
    public String index() {
        return "By Tanmay!";
    }   
	
}
