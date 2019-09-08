create table buyer(
buyerseq number primary key,
buyer_corp varchar2(50),
buyer_owner varchar2(50),
buyer_addr varchar2(100),
buyer_tel varchar2(50),
buyer_pic varchar2(50),
buyer_pictel varchar2(50),
buyer_email varchar2(50),
buyer_memo varchar2(50)
)

create table sales(
sales_ordernum varchar2(50) primary key,
buyerseq number references buyer(buyerseq),
sales_orderdate date default sysdate,
sales_status varchar2(50) check(sales_status in('���δ��', '���οϷ�','�����û','������','�ǸŴ��','�ǸſϷ�')),
sales_totalprice varchar2(50)
)

create table salesdetail(
salesdetailseq number primary key,
salesdetail_name varchar2(100),
salesdetail_amount varchar2(50),
salesdetail_price varchar2(50),
sales_ordernum varchar2(50) references sales(sales_ordernum),
pd_code varchar2(50) references product(pd_code) --PRODUCT TABLE �̻���
)

--create seq

create sequence buyerseq;
create sequence sales_ordernum;
create sequence salesdetailseq;