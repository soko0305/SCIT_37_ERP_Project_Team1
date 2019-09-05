package com.project.erp.vo;

import lombok.Data;

@Data
public class SupplierVO {

	private String supplierSeq;			//공급처seq
	private String supplierName;		//공급처명
	private String supplierOwner;		//공급처대표명
	private String supplierAddr;		//공급처주소
	private String supplierTel;			//공급처연락처
	private String supplierPIC;			//공급처담당자명
	private String supplierEmail;		//공급처이메일
}
