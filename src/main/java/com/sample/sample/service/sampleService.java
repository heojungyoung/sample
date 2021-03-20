package com.sample.sample.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sample.sample.dao.sampleDao;
import com.sample.sample.model.BowlerModel;
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
	
	public List<BowlerModel> getBowler() {
		List<BowlerModel> list = new ArrayList<>();
		List<BowlerModel> tmpList = sampleDao.selectBowlerList();
		
		List<Integer> teamIdList = tmpList.stream().map(BowlerModel::getTeamID).distinct().collect(Collectors.toList());
	
		for(Integer teamId : teamIdList) {
			
			BowlerModel bowlerModel = new BowlerModel();

			List<BowlerModel> resultList = tmpList.stream().filter(
					BowlerModel -> teamId.equals(BowlerModel.getTeamID()))
                    .collect(Collectors.toList());

			
			bowlerModel.setBowlerLastName((resultList.stream().map(BowlerModel::getBowlerLastName)
                    .collect(Collectors.joining(","))));

			bowlerModel.setBowlerFirstName((resultList.stream().map(BowlerModel::getBowlerFirstName)
                    .collect(Collectors.joining(","))));
			
			bowlerModel.setBowlerAddress(resultList.stream().map(BowlerModel::getBowlerAddress).
					collect(Collectors.joining(",")));
			
            list.add(bowlerModel);
	
		}
		
		return list;
	}
	
}
