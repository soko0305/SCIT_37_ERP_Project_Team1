package com.project.erp.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.erp.dao.ProductionDAO;
import com.project.erp.vo.BoardVO;
import com.project.erp.vo.ManufactureVO;
import com.project.erp.vo.ProductMaterialVO;
import com.project.erp.vo.ProductVO;

@Service
public class ProductionService {

	@Autowired
	ProductionDAO pDAO;
	
	public int productionInsert(ProductVO product) {
		int result = pDAO.productionInsert(product);
		return result;
	}

	public ArrayList<ManufactureVO> produceSelect(ManufactureVO manufacture) {
		
		ArrayList<ManufactureVO> result = pDAO.produceSelect(manufacture);
		
 		return result;
	}

	public ArrayList<ProductVO> productionSelect(ProductVO product) {
		ArrayList<ProductVO> result = pDAO.productionSelect(product);
		return result;
	}

	public int deleteProduct(ProductVO product) {
		int result = pDAO.productionDelete(product);		
		return result;
	}

	public ProductVO selectLatestProduct() {
		ProductVO p = pDAO.selectLatestProduct();		
		return p;
	}

	public int insertProudctMaterial(ProductMaterialVO productMaterial) {
		int result =  pDAO.insertProudctMaterial(productMaterial);
		return result;
	}

}
