package com.project.erp.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.project.erp.vo.Buyer;
import com.project.erp.vo.Sales;

@Mapper
@Repository
public interface SalesMapper {

	public Buyer SelectOneBuyer(Buyer buyer);
	public int insertSales(Sales sales);
}
