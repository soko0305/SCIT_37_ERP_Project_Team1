package com.project.erp.dao;

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
		
		OrderMapper mapper =sqlSession.getMapper(OrderMapper.class);
		try {
			result = mapper.orderInsert(order);
		} catch (Exception e) {
			e.printStackTrace();
			return result;
		}
		return result;
	}
}
