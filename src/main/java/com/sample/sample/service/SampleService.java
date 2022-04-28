package com.sample.sample.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sample.sample.dao.SampleDao;
import com.sample.sample.model.CustomerModel;
import com.sample.sample.model.bowlerModel;
import com.sample.sample.model.svcModel;

@Service
public class SampleService {

	@Autowired
	SampleDao sampleDao;
	
	public List<CustomerModel> getCustomerList() {
	     
		List<CustomerModel> list = sampleDao.selectCustomerList();
		return list.stream().filter(x -> x.getCustState().equals("TX")).collect(Collectors.toList());

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
	
	public List<bowlerModel> getBowler() {
		List<bowlerModel> list = new ArrayList<>();
		List<bowlerModel> tmpList = sampleDao.selectBowlerList();
		
		List<Integer> teamIdList = tmpList.stream().map(bowlerModel::getTeamID).distinct().collect(Collectors.toList());
	
		for(Integer teamId : teamIdList) {
			
			bowlerModel bowlerMdl = new bowlerModel();

			List<bowlerModel> resultList = tmpList.stream().filter(
					bowlerModel -> teamId.equals(bowlerModel.getTeamID()))
                    .collect(Collectors.toList());

			
			bowlerMdl.setBowlerLastName((resultList.stream().map(bowlerModel::getBowlerLastName)
                    .collect(Collectors.joining(","))));

			bowlerMdl.setBowlerFirstName((resultList.stream().map(bowlerModel::getBowlerFirstName)
                    .collect(Collectors.joining(","))));
			
			bowlerMdl.setBowlerAddress(resultList.stream().map(bowlerModel::getBowlerAddress).
					collect(Collectors.joining(",")));
			
            list.add(bowlerMdl);
	
		}
		
		return list;
	}
	
}
