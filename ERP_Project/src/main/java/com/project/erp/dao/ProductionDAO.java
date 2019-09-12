package com.project.erp.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
}
