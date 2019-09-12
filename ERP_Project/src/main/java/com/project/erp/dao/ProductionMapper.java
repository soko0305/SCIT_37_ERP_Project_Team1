package com.project.erp.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.project.erp.vo.ProductVO;

@Mapper
@Repository
public interface ProductionMapper {

	public int productionInsert(ProductVO product);
}
