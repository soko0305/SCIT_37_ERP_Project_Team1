package com.project.erp.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.erp.vo.Buyer;
import com.project.erp.vo.Sales;
import com.project.erp.vo.SalesDetail;

@Repository
public class SalesDAO {

	@Autowired
	SqlSessionTemplate sqlSession;
	
	public Buyer SelectOneBuyer(Buyer buyer){
		Buyer buyer1 = null;
		try{
		SalesMapper mapper = sqlSession.getMapper(SalesMapper.class);
		buyer1= mapper.SelectOneBuyer(buyer);
		}catch(Exception e){
			e.printStackTrace();
		}
		return buyer1;
	}
	
	
	public int insertSales(Sales sales){
		int result = 0;
		try{
		SalesMapper mapper = sqlSession.getMapper(SalesMapper.class);
		result= mapper.insertSales(sales);
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	
	public int insertSalesDetail(SalesDetail salesDetail){
		int result = 0;
		try{
		SalesMapper mapper = sqlSession.getMapper(SalesMapper.class);
		result= mapper.insertSalesDetail(salesDetail);
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
}
