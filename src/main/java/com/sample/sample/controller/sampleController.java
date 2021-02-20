package com.sample.sample.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
		return new BaseResponse(sampleService.getSvcList(mdlYear));
	}
	
	
	@RequestMapping(path = "/index")
    public String index() {
        return "By Tanmay!";
    }   
	
	
	  @PostMapping("/saveSvc")
	   public BaseResponse saveSvc(@RequestBody Map<String, Object> paramMap,
	            HttpServletRequest request) {
		    
		    Map<String, Object> newData = (Map<String, Object>) paramMap.get("newData");
	        //policyModel.setHintNm( (String) newHintData.get("hintNm"));
	        //policyModel.setHintDesc( (String) newHintData.get("hintDesc"));
		    sampleService.saveSvc(paramMap);
	        return new BaseResponse();
	    }
	
	
}


