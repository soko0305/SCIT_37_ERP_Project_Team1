package com.project.erp.vo;

import lombok.Data;

@Data
public class Order_rawMaterialVO {

	private String rmorder_code;		//원자재구매코드
	private String rawm_code;			//원자재코드
	private String rawm_name;			//원자재명
	private String supplierseq;			//공급처코드
	private String rmorder_date;		//원자재주문일자
	private int rmorder_amount;			//원자재수량
	private String rmorder_status;		//원자재구매진행
	private String warehouse_code;		//창고코드
	private String rmorder_requserid;	//원자재 요청 user
	private String rmorder_reqdate;		//원자재주문요청일자
	private String mfseq;				//생산코드
	private String rmorder_arrivedate;	//원자재도착일자
}
