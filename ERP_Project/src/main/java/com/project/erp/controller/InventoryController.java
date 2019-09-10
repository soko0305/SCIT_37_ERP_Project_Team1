package com.project.erp.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.erp.service.InventoryService;
import com.project.erp.vo.InventoryVO;
import com.project.erp.vo.ProductVO;
import com.project.erp.vo.RawMaterialVO;
import com.project.erp.vo.SupplierVO;
import com.project.erp.vo.WarehouseVO;

@Controller
public class InventoryController {
	
	@Autowired
	InventoryService inventoryService;
	int flag = 0;
	
	//모든 창고 리스트 가져오는 메소드
	@RequestMapping(value="/selectAllInventory", method = RequestMethod.GET)
	public @ResponseBody ArrayList<WarehouseVO> selectAllInventory(){
		ArrayList<WarehouseVO> wList = null;
		wList = inventoryService.selectAllInventory();
		return wList;
	}
	
	//창고 추가 메소드
	@RequestMapping(value="/insertWarehouse", method = RequestMethod.POST)
	public @ResponseBody void insertWarehouse(WarehouseVO warehouse){
		flag=0;
		flag = inventoryService.insertWarehouse(warehouse);
	}
	
	//추가, 최신화 성공 여부 확인 메소드
	@RequestMapping(value="/checkSuccess", method = RequestMethod.GET)
	public @ResponseBody int checkSuccess(){
		return flag;
	}
	
	//추가 후 새로 추가된 창고 정보 가져오는 메소드
	@RequestMapping(value="/selectLatestWarehouse", method = RequestMethod.GET)
	public @ResponseBody WarehouseVO selectLatestWarehouse(){
		WarehouseVO w = null;
		w = inventoryService.selectLatestWarehouse();
		return w;
	}
	
	//창고 정보 업데이트 메소드
	@RequestMapping(value="/updateWarehouse", method = RequestMethod.POST)
	public @ResponseBody void updateWarehouse(WarehouseVO warehouse){
		flag=0;
		flag = inventoryService.updateWarehouse(warehouse);
	}
	
	//창고 정보 삭제 메소드
	@RequestMapping(value="/deleteWarehouse", method = RequestMethod.GET)
	public @ResponseBody int deleteWarehouse(String warehouse_code){
		int check =0;
		check = inventoryService.deleteWarehouse(warehouse_code);
		return check;
	}
	
	//warehouse_code통해 창고 정보 검색하는 메소드
	@RequestMapping(value="/selectWarehouseByCode", method = RequestMethod.GET)
	public @ResponseBody WarehouseVO selectWarehouseByCode(String warehouse_code){
		WarehouseVO w = null;
		w = inventoryService.selectWarehouseByCode(warehouse_code);
		return w;
	}
	
	//warehouse_code를 통해 창고 내 원자재재고 자료 메소드
	@RequestMapping(value="/selectMaterialINWarehouse", method = RequestMethod.GET)
	public @ResponseBody ArrayList<RawMaterialVO> selectMaterialINWarehouse(String warehouse_code){
		ArrayList<RawMaterialVO> mList = null;
		mList = inventoryService.selectMaterialINWarehouse(warehouse_code);
		return mList;
	}
	
	
	@RequestMapping(value="/selectDistinctMaterialINWarehouse", method = RequestMethod.GET)
	public @ResponseBody ArrayList<RawMaterialVO> selectDistinctMaterialINWarehouse(String warehouse_code){
		ArrayList<RawMaterialVO> sList = null;
		sList = inventoryService.selectDistinctMaterialINWarehouse(warehouse_code);
		return sList;
	}
	
	//warehouse_code를 통해 창고 내 생산품재고 자료 메소드
	@RequestMapping(value="/selectProductINWarehouse", method = RequestMethod.GET)
	public @ResponseBody ArrayList<ProductVO> selectProductINWarehouse(String warehouse_code){
		ArrayList<ProductVO> pList = null;
		pList = inventoryService.selectProductINWarehouse(warehouse_code);
		return pList;
	}
	@RequestMapping(value="/selectDistinctMaterialSortINWarehouse", method = RequestMethod.GET)
	public @ResponseBody ArrayList<RawMaterialVO> selectDistinctMaterialSortINWarehouse(String warehouse_code){
		ArrayList<RawMaterialVO> mList = null;
		mList = inventoryService.selectDistinctMaterialSortINWarehouse(warehouse_code);
		return mList;
	}
	
	@RequestMapping(value="/selectDistinctProductSortINWarehouse", method = RequestMethod.GET)
	public @ResponseBody ArrayList<ProductVO> selectDistinctProductSortINWarehouse(String warehouse_code){
		ArrayList<ProductVO> pList = null;
		pList = inventoryService.selectDistinctProductSortINWarehouse(warehouse_code);
		return pList;
	}

	
	@RequestMapping(value="/selectSupplierBySeq", method = RequestMethod.GET)
	public @ResponseBody SupplierVO selectSupplierBySeq(String supplierseq){
		SupplierVO s = null;
		s = inventoryService.selectSupplierBySeq(supplierseq);
		return s;
	}

	
}
