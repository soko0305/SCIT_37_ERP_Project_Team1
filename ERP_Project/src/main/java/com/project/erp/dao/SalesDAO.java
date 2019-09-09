package com.project.erp.dao;


import java.util.List;

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
	
	/*
	 * insert 
	 */
	
	
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
	
	
	
	/*
	 * select
	 */

	
	
	//BuyerSeq가 일치하는 Buyer를 select
	public Buyer selectOneBuyer(Buyer buyer){
		Buyer buyer1 = null;
		try{
		SalesMapper mapper = sqlSession.getMapper(SalesMapper.class);
		buyer1= mapper.selectOneBuyer(buyer);
		}catch(Exception e){
			e.printStackTrace();
		}
		return buyer1;
	}
	
	//Sales 목록 전체 select
	public List<Sales> selectAllSales(){
		List<Sales> list1 = null;
		try{
		SalesMapper mapper = sqlSession.getMapper(SalesMapper.class);
		list1=mapper.selectAllSales();
		}catch(Exception e){
			e.printStackTrace();
		}
		return list1;
	}

	// OrderNumber를 통해 salesDetail을 select 
	public List<SalesDetail> selectSalesDetail(SalesDetail salesDetail){
		List<SalesDetail> list1 = null;
		try{
		SalesMapper mapper = sqlSession.getMapper(SalesMapper.class);
		list1=mapper.selectSalesDetail(salesDetail);
		}catch(Exception e){
			e.printStackTrace();
		}
		return list1;
	}

}
