package com.sample.sample.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	
	public svcModel getCntr(svcModel svcModel) {
		return sampleDao.selectCntr(svcModel);
	}
	
	public void insertMdlCntr(svcModel svcModel) {
		sampleDao.insertMdlCntr(svcModel);
	}
	
	@Transactional
    public int saveSvc(Map<String, Object> map) {
		sampleDao.insertSvc(map);
        return 1;
    }
	
}
