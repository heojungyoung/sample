package com.sample.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.sample.dao.sampleDao;
import com.sample.sample.model.sampleModel;
import com.sample.sample.model.svcModel;

@Service
public class sampleService {

	@Autowired
	sampleDao sampleDao;
	
	public List<sampleModel> getSampleList(String plcyId) {
	     return sampleDao.selectSampleList(plcyId);
	}
	
	public List<svcModel> getSvcList(String mdlYear) {
		return sampleDao.selectSvcList(mdlYear);
	}
	
}
