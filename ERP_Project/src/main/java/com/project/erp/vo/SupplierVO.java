package com.project.erp.vo;

import lombok.Data;

@Data
public class SupplierVO {

	private String supplierseq;			//공급처seq
	private String supplier_name;		//공급처명
	private String supplier_owner;		//공급처대표명
	private String supplier_addr;		//공급처주소
	private String supplier_tel;		//공급처연락처
	private String supplier_pic;		//공급처담당자명
	private String supplier_email;		//공급처이메일
	private String supplier_delete;		//공급처삭제여부
}
