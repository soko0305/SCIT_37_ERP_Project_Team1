package com.project.erp.vo;

import lombok.Data;

@Data
public class ProductVO {

	private String pd_code;			//생산품코드
	private String pd_name; 		//생산품명
	private String pd_rmcost;  		//재료비
	private String pd_manufcost; 	//생산비
	private String pd_sort;			//생산품종류
	private String warehouse_code; //창고	
	private String   pd_delete; //삭제여부
}
 