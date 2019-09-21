package com.project.erp.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.project.erp.vo.Order_rawMaterialVO;

@Mapper
@Repository
public interface OrderMapper {

	public int orderInsert(Order_rawMaterialVO order);					//발주입력
	
	public ArrayList<Order_rawMaterialVO> orderAllselect();				//발주 내역 전체 출력
	
	public Order_rawMaterialVO orderOneSelect(String rmorder_code);		//발주 한개 가져오기
	
	public int orderUpdate(Order_rawMaterialVO order);					//발주 수정
	
	public ArrayList<Order_rawMaterialVO> orderDashSelect();			//발주 내역 대쉬보드 3개 출력
}
