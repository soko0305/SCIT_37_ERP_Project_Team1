package com.project.erp.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.erp.dao.OrderDAO;
import com.project.erp.vo.Order_rawMaterialVO;

@Service
public class OrderService {

	@Autowired
	OrderDAO oDAO;

	public int orderInsert(Order_rawMaterialVO order) {
		return oDAO.orderInsert(order);
	}

	public int orderUpdate(Order_rawMaterialVO order) {
		return oDAO.orderUpdate(order);
	}

	public ArrayList<Order_rawMaterialVO> orderAllselect() {
		return oDAO.orderAllselect();
	}

	public int rawMaterialRequest(Order_rawMaterialVO rawmaterial) {
		return oDAO.rawMaterialRequest(rawmaterial);
	}

	public Order_rawMaterialVO requestOneSelect(String rmorder_code) {
		return oDAO.requestOneSelect(rmorder_code);
	}
	
}
