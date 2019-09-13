package com.project.erp.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.erp.vo.BoardVO;
import com.project.erp.vo.ManufactureVO;
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
			return result;
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
	
	
}
