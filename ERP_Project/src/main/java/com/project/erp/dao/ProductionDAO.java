package com.project.erp.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.erp.vo.ManufactureVO;
import com.project.erp.vo.ProductMaterialVO;
import com.project.erp.vo.ProductVO;

@Repository
public class ProductionDAO {

	@Autowired
	SqlSessionTemplate sqlSession;
	
	public int productionInsert(ProductVO product) {
		int result = 0;
		ProductionMapper mapper = sqlSession.getMapper(ProductionMapper.class);
		try {
			result = mapper.productionInsert(product);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		return result;
	}
	public ArrayList<ManufactureVO> produceSelect(ManufactureVO manufacture) {
		ArrayList<ManufactureVO> result = null;
		
		ProductionMapper mapper = sqlSession.getMapper(ProductionMapper.class);
		try {
			result = mapper.produceSelect(manufacture);
		} catch (Exception e) {
			e.printStackTrace();
			return result;
		}
		return result;
	}
	public ArrayList<ProductVO> productionSelect(ProductVO product) {
		ArrayList<ProductVO> result = null;
		
		ProductionMapper mapper = sqlSession.getMapper(ProductionMapper.class);
		try {
			result = mapper.productionSelect(product);
		} catch (Exception e) {
			e.printStackTrace();
			return result;
		}
		return result;	
	}
	public int productionDelete(ProductVO product) {
		int result = 0;

		ProductionMapper mapper = sqlSession.getMapper(ProductionMapper.class);
		try {
			result = mapper.productionDelete(product);
		} catch (Exception e) {			
			e.printStackTrace();
			return result;
		}
		return result;
	}
	
	public ProductVO selectLatestProduct() {
		ProductVO p = null;

		ProductionMapper mapper = sqlSession.getMapper(ProductionMapper.class);
		try {
			p = mapper.selectLatestProduct();
		} catch (Exception e) {			
			e.printStackTrace();
			return null;
		}
		return p;
	}
	
	
	public int insertProudctMaterial(ProductMaterialVO productMaterial) {
		int result = 0;
		ProductionMapper mapper = sqlSession.getMapper(ProductionMapper.class);
		try {
			result = mapper.insertProudctMaterial(productMaterial);
		} catch (Exception e) {			
			e.printStackTrace();
			return 0;
		}
		return result;
	}
<<<<<<< HEAD
	
	public ArrayList<ProductMaterialVO> productMaterialSelect(ProductMaterialVO vo){
		ArrayList<ProductMaterialVO> result = null;
		ProductionMapper mapper = sqlSession.getMapper(ProductionMapper.class);
		try {
			result = mapper.productMaterialSelect(vo);
			System.out.println("dao result : " + result);
		} catch (Exception e) {			
			e.printStackTrace();
			return result;
		}
		return result;
		
=======
	public ProductVO selelctProductByCode(String pd_code) {
		ProductVO p = null;

		ProductionMapper mapper = sqlSession.getMapper(ProductionMapper.class);
		try {
			p = mapper.selelctProductByCode(pd_code);
		} catch (Exception e) {			
			e.printStackTrace();
			return null;
		}
		return p;
	}
	public ArrayList<ProductMaterialVO> selectAllProductMaterial(String pd_code) {
		ArrayList<ProductMaterialVO> pmList = null;
		ProductionMapper mapper = sqlSession.getMapper(ProductionMapper.class);
		try {
			pmList = mapper.selectAllProductMaterial(pd_code);
		} catch (Exception e) {			
			e.printStackTrace();
			return null;
		}
		return pmList;
	}
	
	public int productionUpdate(ProductVO product) {
		int result = 0;
		ProductionMapper mapper = sqlSession.getMapper(ProductionMapper.class);
		try {
			result = mapper.productionUpdate(product);
		} catch (Exception e) {			
			e.printStackTrace();
			return 0;
		}
		return result;
	}
	
	public int deleteProudctMaterial(String pd_code) {
		int result = 0;
		ProductionMapper mapper = sqlSession.getMapper(ProductionMapper.class);
		try {
			result = mapper.deleteProudctMaterial(pd_code);
		} catch (Exception e) {			
			e.printStackTrace();
			return 0;
		}
		return result;
>>>>>>> master
	}
	 
}
