package com.project.erp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.project.erp.vo.Buyer;
import com.project.erp.vo.Sales;
import com.project.erp.vo.SalesDetail;

@Mapper
@Repository
public interface SalesMapper {

	/*
	 * insert 
	 */

	public int insertSales(Sales sales);
	public int insertSalesDetail(SalesDetail salesDetail);
	
	/*
	 * select
	 */
	
	public List<Sales> selectAllSales(); //Sales 목록 전체 select
	public Buyer selectOneBuyer(Buyer buyer); //BuyerSeq가 일치하는 Buyer를 select
	public List<SalesDetail> selectSalesDetail(SalesDetail salesDetail); // OrderNumber를 통해 salesDetail을 select 
	
	
	
}
