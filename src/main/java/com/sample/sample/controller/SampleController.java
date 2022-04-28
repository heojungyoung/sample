package com.sample.sample.controller;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import com.sample.sample.method.Fib;
import com.sample.sample.model.BaseResponse;
import com.sample.sample.model.CustomerModel;
import com.sample.sample.util.example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sample.sample.service.SampleService;

@RestController
@RequestMapping("/sample")
public class SampleController {
	
	@Autowired
	SampleService sampleService;
	
	// @Autowired
	Fib fib;

	@GetMapping("/getSampleList")
	public BaseResponse getCustomerList()  {
		// fib.allFib(10);

		for(example type : example.values()){
			System.out.println(type.getValue()); // 에스케이, 엘쥐, 케이티, 삼성, 애플
		}

		return new BaseResponse(sampleService.getCustomerList());
	}

	@RequestMapping(path = "/index")
    public String index() {
		return "By Tan may!";
    }

	@PostMapping("/saveSvc")
	public BaseResponse saveSvc(@RequestBody Map<String, Object> paramMap,
	            HttpServletRequest request) {
		    
		    @SuppressWarnings("unchecked")
		    Map<String, Object> newData = (Map<String, Object>) paramMap.get("newData");
		    sampleService.saveSvc(paramMap);
	        return new BaseResponse();
	 }
	
	@GetMapping("/getBowlerList")
	public BaseResponse getBowler()  {
		return new BaseResponse(sampleService.getBowler());
	}
	
	
}


