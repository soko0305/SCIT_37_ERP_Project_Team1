package com.project.erp.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.erp.vo.BoardVO;
import com.project.erp.vo.ManufactureVO;
import com.project.erp.vo.ProductMaterialVO;
import com.project.erp.vo.ProductVO;
import com.project.erp.vo.RawMaterialVO;

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
	public ArrayList<ManufactureVO> produceSelect() {
		ArrayList<ManufactureVO> result = null;
		ProductionMapper mapper = sqlSession.getMapper(ProductionMapper.class);
		try {
			result = mapper.produceSelect();

		} catch (Exception e) {
			e.printStackTrace();
			return result;
		}
		return result;
	}
	public ArrayList<ProductVO> productionSelect() {
		ArrayList<ProductVO> result = null;
		
		ProductionMapper mapper = sqlSession.getMapper(ProductionMapper.class);
		try {
 
			result = mapper.productionSelect();
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
	public int deleteProduce(ManufactureVO manufacture) {
		int result = 0;
		ProductionMapper mapper = sqlSession.getMapper(ProductionMapper.class);
		try {
			result = mapper.deleteProduce(manufacture);
		} catch (Exception e) {			
			e.printStackTrace();
			return result;
		}
		return result;		 
	}
	public int deleteProduction(ProductVO product) {
		int result = 0;
		ProductionMapper mapper = sqlSession.getMapper(ProductionMapper.class);
		try {
			result = mapper.deleteProduction(product);
		} catch (Exception e) {			
			e.printStackTrace();
			return result;
		}
		return result;		
	}
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
	}
	public int produceInsert(ManufactureVO manufacture) {
		int result = 0;
		ProductionMapper mapper = sqlSession.getMapper(ProductionMapper.class);
		try {
			result = mapper.produceInsert(manufacture);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		return result;
	}
	public ManufactureVO produceOneSelect(String mfseq) {
		ManufactureVO result = null;
		ProductionMapper mapper = sqlSession.getMapper(ProductionMapper.class);
		try {
			result = mapper.produceOneSelect(mfseq);
			
		} catch (Exception e) {
			e.printStackTrace();
			return result;
		}


		return result;
	}
	public int produceUpdate(ManufactureVO manufacture) {
		int result = 0;
		ProductionMapper mapper = sqlSession.getMapper(ProductionMapper.class);
		try {
			result = mapper.produceUpdate(manufacture);
		} catch (Exception e) {			
			e.printStackTrace();
			return result;
		}
		return result;		 
	}
	public int statusProduce(ManufactureVO manufacture) {
		int result = 0;
		ProductionMapper mapper = sqlSession.getMapper(ProductionMapper.class);
		try {
			result = mapper.statusProduce(manufacture);
		} catch (Exception e) {			
			e.printStackTrace();
			return result;
		}
		return result;		 
	}
	
}
