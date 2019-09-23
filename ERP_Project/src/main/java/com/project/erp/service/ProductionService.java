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

	public ArrayList<ManufactureVO> produceSelect() {
		
		ArrayList<ManufactureVO> result = pDAO.produceSelect();
 		return result;
	}

	public ArrayList<ProductVO> productionSelect() {
		ArrayList<ProductVO> result = pDAO.productionSelect();
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

 
	public int deleteProduce(ManufactureVO manufacture) {
		String check = "Y";
		manufacture.setMf_delete(check);
		return pDAO.deleteProduce(manufacture);
 	}

	public int deleteProduction(ProductVO product) {
		String check = "Y";
		product.setPd_delete(check);
			return pDAO.deleteProduction(product);
 	}



	public ProductVO selelctProductByCode(String pd_code) {
		ProductVO p = pDAO.selelctProductByCode(pd_code);
		return p;
	}

	public ArrayList<ProductMaterialVO> selectAllProductMaterial(String pd_code) {
		ArrayList<ProductMaterialVO> pmList = pDAO.selectAllProductMaterial(pd_code);
		return pmList;
	}

	public int productionUpdate(ProductVO product) {
		int result = pDAO.productionUpdate(product);		
		return result;
	}

	public int deleteProudctMaterial(String pd_code) {
		int result = pDAO.deleteProudctMaterial(pd_code);		
		return result;
	}

	public int produceInsert(ManufactureVO manufacture) {
		int result = pDAO.produceInsert(manufacture);
		return result;
	}

	public ManufactureVO produceOneSelect(String mfseq) {
		return pDAO.produceOneSelect(mfseq);
	}

	public int produceUpdate(ManufactureVO manufacture) {
		return pDAO.produceUpdate(manufacture);
	}

	public int statusProduce(ManufactureVO manufacture) {
		String check = "완료";
		manufacture.setManuf_status(check);
		return pDAO.statusProduce(manufacture);

	}
 
	}
 
	
	

