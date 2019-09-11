package com.project.erp.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.project.erp.vo.Order_rawMaterialVO;

@Mapper
@Repository
public interface OrderMapper {

	public int orderInsert(Order_rawMaterialVO order);
}
