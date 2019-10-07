package com.project.erp.vo;

import lombok.Data;

@Data
public class CheckstockVO {
 private String checkstock_code;
 private String checkstock_date;
 private String checkstock_adminid; 
 private String mmcode;
 private String warehouse_code;	
 private int checkstock_sysstock;
 private int checkstock_realstock;
 private String checkstock_result;
 private String checkstock_reason;
	
}
