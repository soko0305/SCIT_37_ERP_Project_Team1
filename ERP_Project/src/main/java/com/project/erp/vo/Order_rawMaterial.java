package com.project.erp.vo;

import lombok.Data;

@Data
public class Order_rawMaterial {

	private String rmorder_code;
	private String rawm_code;
	private String supplierseq;
	private String rmorder_date;
	private int rmorder_amount;
	private String rmorder_status;
	private String warehouse_code;
	private String rmorder_requserid;
	private String rmorder_reqdate;
	private String mfseq;
}
