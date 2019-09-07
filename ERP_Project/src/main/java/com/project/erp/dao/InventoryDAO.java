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

	public int insertWarehouse(WarehouseVO warehouse) {
		int check =0;
		try{
		InventoryMapper mapper = sqlSession.getMapper(InventoryMapper.class);
		check= mapper.insertWarehouse(warehouse);
		}catch(Exception e){
			e.printStackTrace();
			check = 0;
		}
		return check;
	}

	public WarehouseVO selectLatestWarehouse() {
		WarehouseVO w = null;
		try{
		InventoryMapper mapper = sqlSession.getMapper(InventoryMapper.class);
		w= mapper.selectLatestWarehouse();
		}catch(Exception e){
			e.printStackTrace();
		}
		return w;
	}

	public WarehouseVO selectWarehouseByCode(String warehouse_code) {
		WarehouseVO w = null;
		try{
		InventoryMapper mapper = sqlSession.getMapper(InventoryMapper.class);
		w= mapper.selectWarehouseByCode(warehouse_code);
		}catch(Exception e){
			e.printStackTrace();
		}
		return w;
	}

	public int updateWarehouse(WarehouseVO warehouse) {
		int check =0;
		try{
		InventoryMapper mapper = sqlSession.getMapper(InventoryMapper.class);
		check= mapper.updateWarehouse(warehouse);
		}catch(Exception e){
			e.printStackTrace();
			check = 0;
		}
		return check;
	}

	public int deleteWarehouse(String warehouse_code) {
		int check =0;
		try{
		InventoryMapper mapper = sqlSession.getMapper(InventoryMapper.class);
		check= mapper.deleteWarehouse(warehouse_code);
		}catch(Exception e){
			e.printStackTrace();
			check = 0;
		}
		return check;
	}
	
}
