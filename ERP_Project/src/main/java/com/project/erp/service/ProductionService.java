package com.project.erp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.erp.dao.ProductionDAO;
import com.project.erp.vo.ProductVO;

@Service
public class ProductionService {

	@Autowired
	ProductionDAO pDAO;
	
	public int productionInsert(ProductVO product) {
		
		int result = pDAO.productionInsert(product);
		
		return result;
	}
}
