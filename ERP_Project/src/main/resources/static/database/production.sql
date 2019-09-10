
 drop table PRODUCT;

create table PRODUCT(
PD_CODE  varchar2(100) primary key,
PD_NAME varchar2(100) not null,
PD_RMCOST   number not null,
PD_MANUFCOST   number not null,
PD_SORT varchar2(100) not null
)
 
drop table MANUFACTURE;

create table MANUFACTURE(
MFSEQ varchar2(100) primary key,
PD_CODE varchar2(100) references PRODUCT(PD_CODE) not null,
MANUF_STARTDATE date not null,
MANUF_ENDDATE  date not null,
MANUF_STATUS varchar2(100) not null,
warehouse_code varchar2(100) not null,
MANUF_AMOUNT number not null,
SALES_ORDERNUM varchar2(100) not null,
MANUF_REQUSERID varchar2(100) not null,
MANUF_REQDATE  date not null,
SALESDETAILSEQ varchar2(100) not null
)
drop  sequence MFSEQ;
 create sequence MFSEQ;

drop table PRODUCT_MATERIAL;

create table PRODUCT_MATERIAL(
PRODUCT_MATERIAL_CODE  varchar2(100) primary key,
PD_CODE  varchar2(100) references PRODUCT(PD_CODE) not null,
RAWM_CODE  varchar2(100) not null,
PRODUCT_MATERIAL_AMOUNT  number not null
)