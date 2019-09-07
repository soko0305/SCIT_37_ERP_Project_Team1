package com.project.erp.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.erp.vo.WarehouseVO;

@Repository
public class InventoryDAO {

	@Autowired
	SqlSessionTemplate sqlSession;

	public ArrayList<WarehouseVO> selectAllInventory() {
		ArrayList<WarehouseVO> wList = null;
		try{
		InventoryMapper mapper = sqlSession.getMapper(InventoryMapper.class);
		wList= mapper.selectAllInventory();
		}catch(Exception e){
			e.printStackTrace();
		}
		return wList;
	}
	
}
