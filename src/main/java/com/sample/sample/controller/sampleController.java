package com.sample.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sample.sample.model.BaseResponse;
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
	
	
}
