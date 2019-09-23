package com.project.erp.vo;

import lombok.Data;

@Data
public class ManufactureVO {
 			private String  mfseq; //생산번호 시퀀스
			private String  pd_code; //생산할 종류의 제품번호
 			private String  manuf_startdate; //생산시작일
 			private String  manuf_enddate; //생산 종료일
			private String 	 manuf_status;  //진행상황(미완,완료)
			private String 	 warehouse_code; //이건 나두기 창고코드
			private String 	 manuf_amount;  //생산수량
			private String 	 sales_ordernum; //비워두기 '0'
			private String 	 manuf_requserid; //비워두기 '0'
			private String 	 manuf_reqdate;  //sysdate
			private String 	 salesdetailseq;//비워두기 '0'
			private String   pd_name; //db에 없으며 조인으로 product테이블에서 가져요기
			private String   mf_delete; //삭제여부 Y는 삭제 N 미삭제로 구분
			
}
