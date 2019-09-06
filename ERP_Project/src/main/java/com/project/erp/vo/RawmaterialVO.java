package com.project.erp.vo;

import lombok.Data;

@Data
public class RawmaterialVO {
	private String rawmCode;		//원자재코드
	private String supplierSeq;		//공급처코드
	private String rawmName;		//원자재명
	private String rawmSort;		//원자재종류
	private String rawm_price;		//원자재단가
	private int rawmMinimum;		//원자재최저수량
	private int rawmSet;			//원자재설정수량
	private String rawmAutoOrder;	//원자재자동구매

}
