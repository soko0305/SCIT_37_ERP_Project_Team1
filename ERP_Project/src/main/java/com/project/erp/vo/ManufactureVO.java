package com.project.erp.vo;

import lombok.Data;

@Data
public class ManufactureVO {
 			private String  mfseq;
			private String  pd_code; 
 			private String  manuf_startdate;
 			private String  manuf_enddate;
			private String 	 manuf_status; 
			private String 	 warehouse_code; //이건 나두기
			private String 	 manuf_amount; 
			private String 	 sales_ordernum; //비워두기 '0'
			private String 	 manuf_requserid; //비워두기 '0'
			private String 	 manuf_reqdate;  //sysdate
			private String 	 salesdetailseq;//비워두기 '0'
			private String   pd_name;
			private String   mf_delete;
			
}
