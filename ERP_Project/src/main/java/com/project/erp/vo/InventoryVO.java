package com.project.erp.vo;

import lombok.Data;

@Data
public class InventoryVO {
	private String pd_code;
	private String pd_name; 
	private String pd_rmcost;  
	private String pd_manufcost; 
	private String pd_sort;
	private String warehouse_code;
	
	private String rawm_code;		//원자재코드
	private String supplierseq;		//공급처코드
	private String rawm_name;		//원자재명
	private String rawm_sort;		//원자재종류
	private String rawm_price;		//원자재단가
	private int rawm_minimum;		//원자재최저수량
	private int rawm_set;			//원자재설정수량
	private String rawm_autoorder;	//원자재자동구매
}
