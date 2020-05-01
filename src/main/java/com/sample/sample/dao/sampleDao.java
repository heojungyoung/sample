package com.sample.sample.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.sample.sample.model.sampleModel;

@Repository
@Mapper
public interface sampleDao {
	List<sampleModel> selectSampleList(String plcyId);
}
