package com.project.erp.vo;

import lombok.Data;

@Data
public class SalesDetail {
	
	private String salesdetailseq;
	private String salesdetail_name;
	private String salesdetail_amount;
	private String salesdetail_price;
	private String sales_ordernum;
	private String salesdetail_valueofsupply;
	private String pd_code;
	private String salesdetail_status;
}
