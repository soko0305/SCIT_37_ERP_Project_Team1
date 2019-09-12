package com.project.erp.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.project.erp.vo.Order_rawMaterialVO;

@Mapper
@Repository
public interface OrderMapper {

	public int orderInsert(Order_rawMaterialVO order);
	
	public ArrayList<Order_rawMaterialVO> orderAllselect();
	
	public Order_rawMaterialVO orderOneSelect(String rmorder_code);
	
	public int orderUpdate(Order_rawMaterialVO order);
	
	public ArrayList<Order_rawMaterialVO> orderDashSelect();
}
