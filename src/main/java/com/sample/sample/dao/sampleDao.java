package com.sample.sample.dao;

import java.util.List;
import java.util.Map;

import javax.swing.text.StyledEditorKit.BoldAction;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.sample.sample.model.bowlerModel;
import com.sample.sample.model.sampleModel;
import com.sample.sample.model.svcModel;

@Repository
@Mapper
public interface sampleDao {
	List<sampleModel> selectSampleList(String plcyId);
	List<svcModel> selectSvcList(String mdlYear);
	svcModel selectCntr(svcModel svcModel);
	void insertMdlCntr(svcModel svcModel);
	void insertSvc(Map<String, Object> map);
	List<bowlerModel> selectBowlerList();
}
