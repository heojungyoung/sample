package com.sample.sample.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		
	
		ArrayList<svcModel> updateMdlList = new ArrayList<svcModel>();
		
		
	    List<svcModel> list =  sampleService.getSvcList(mdlYear);
		
	 	for(svcModel svcMdl : list) {
	 		svcModel cntrMdl;
	 		cntrMdl = sampleService.getCntr(svcMdl);
	 		if(cntrMdl != null) {
	 			svcModel mdl = new svcModel();
	 			mdl.setVaSvcId(cntrMdl.getVaSvcId());
	 			mdl.setVaCntrId(cntrMdl.getVaCntrId());
	 			updateMdlList.add(mdl);
	 		}
		}
	 	
	    System.out.println(updateMdlList);
	    
	    for(svcModel mdl : updateMdlList) {
	    	sampleService.insertMdlCntr(mdl);
	    }
	    
	    
	    
		return new BaseResponse(sampleService.getSvcList(mdlYear));
	}
	
	
	@RequestMapping(path = "/index")
    public String index() {
        return "By Tanmay!";
    }   
	
}


