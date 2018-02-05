package com.wh.demo.test.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.wh.demo.test.model.TestEntity;

@Mapper
public interface TestDao {
	
	public void insert10000(@Param("testEntity") TestEntity testEntity);
}
