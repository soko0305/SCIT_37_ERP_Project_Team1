package com.project.erp.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.erp.vo.Order_rawMaterialVO;

@Repository
public class OrderDAO {

	@Autowired
	SqlSessionTemplate sqlSession;

	public int orderInsert(Order_rawMaterialVO order) {
		int result = 0;

		OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
		try {
			result = mapper.orderInsert(order);
		} catch (Exception e) {
			e.printStackTrace();
			return result;
		}
		return result;
	}

	public ArrayList<Order_rawMaterialVO> orderAllselect() {
		ArrayList<Order_rawMaterialVO> result = null;

		OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
		try {
			result = mapper.orderAllselect();
		} catch (Exception e) {
			e.printStackTrace();
			return result;
		}
		return result;
	}
	
	public int orderUpdate(Order_rawMaterialVO order) {
		int result = 0;

		OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
		try {
			result = mapper.orderUpdate(order);
		} catch (Exception e) {
			e.printStackTrace();
			return result;
		}
		return result;
	}
	
	public ArrayList<Order_rawMaterialVO> orderDashSelect(){
		ArrayList<Order_rawMaterialVO> result = null;

		OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
		try {
			result = mapper.orderDashSelect();
		} catch (Exception e) {
			e.printStackTrace();
			return result;
		}
		return result;
	}

	public int rawMaterialRequest(Order_rawMaterialVO rawmaterial) {
		int result = 0;

		OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
		try {
			result = mapper.rawMaterialRequest(rawmaterial);
		} catch (Exception e) {
			e.printStackTrace();
			return result;
		}
		return result;
	}

	public Order_rawMaterialVO requestOneSelect(String rmorder_code) {
		Order_rawMaterialVO result = null;

		OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
		try {
			result = mapper.requestOneSelect(rmorder_code);
		} catch (Exception e) {
			e.printStackTrace();
			return result;
		}
		return result;
	}
}
