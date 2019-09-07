package com.project.erp.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.project.erp.vo.WarehouseVO;

@Mapper
@Repository
public interface InventoryMapper {

	public ArrayList<WarehouseVO> selectAllInventory();

	public int insertWarehouse(WarehouseVO warehouse);

}