package com.sample.sample.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.sample.sample.model.sampleModel;
import com.sample.sample.model.svcModel;

@Repository
@Mapper
public interface sampleDao {
	List<sampleModel> selectSampleList(String plcyId);
	List<svcModel> selectSvcList(String mdlYear);
}
