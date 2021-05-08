package com.sample.sample.controller;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sample.sample.method.Fib;
import com.sample.sample.model.BaseResponse;
import com.sample.sample.service.SampleService;

@RestController
@RequestMapping("/sample")
public class SampleController {
	
	@Autowired
	SampleService sampleService;
	
	@Autowired
	Fib fib;
	
	
	@GetMapping("/getSampleList")
	public BaseResponse getCustormerList(
			@RequestParam(required = false) String custId)  {	
		fib.allFib(10);
		return new BaseResponse(sampleService.getCustormerList(custId));
	}
	
//	@GetMapping("/getSvcList")
//	public BaseResponse getSvcList(
//			@RequestParam(required = false) String mdlYear)  {    
//		return new BaseResponse(sampleService.getSvcList(mdlYear));
//	}
	
	
	@RequestMapping(path = "/index")
    public String index() {
        return "By Tanmay!";
    }   
	
	
	@PostMapping("/saveSvc")
	public BaseResponse saveSvc(@RequestBody Map<String, Object> paramMap,
	            HttpServletRequest request) {
		    
		    @SuppressWarnings("unchecked")
		    Map<String, Object> newData = (Map<String, Object>) paramMap.get("newData");
		    sampleService.saveSvc(paramMap);
	        return new BaseResponse();
	 }
	
//	@GetMapping("/getBowlerList")
//	public BaseResponse getBowler()  {    
//		return new BaseResponse(sampleService.getBowler());
//	}
	
	
}


