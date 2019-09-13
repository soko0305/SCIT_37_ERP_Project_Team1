 
drop table erp_notice;

create table erp_notice(
board_seq  varchar2(100) primary key,
userid not null references erp_member(userid),
title varchar2(100) not null,
content varchar2(1000) not null,
time date default sysdate not null
)
drop  sequence board_seq;
 create sequence board_seq;
 
 drop table erp_file;
 
create table erp_file(
file_seq varchar2(100) primary key,
boared_seq not null references erp_notice(board_seq),
org_name varchar2(100) not null,
sav_name varchar2(100) not null,
time date default sysdate not null,
 )
drop  sequence file_seq;
 create sequence file_seq;
  