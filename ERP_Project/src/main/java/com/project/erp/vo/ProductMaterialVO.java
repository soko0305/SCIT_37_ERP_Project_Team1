package com.project.erp.vo;

import lombok.Data;

@Data
public class ProductMaterialVO {
 
	private String product_material_code; 
	private String pd_code; 
	private String rawm_code;
	private String product_material_amount;
	private String supplierseq;		//공급처코드
	private String rawm_name;		//원자재명
	private String rawm_sort;		//원자재종류
	private String rawm_price;		//원자재단가
	private int rawm_minimum;		//원자재최저수량
	private int rawm_set;			//원자재설정수량
	private String rawm_autoorder;	//원자재자동구매
	private String rawm_delete;		//원자재삭제여부
}
