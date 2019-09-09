drop table erp_member;

create table erp_member(
userid varchar2(100) primary key,
userpw varchar2(100) not null,
userstatus varchar2(100) not null,
userdepratment varchar2(100) not null,
userstate varchar2(100) check(userstate in('allowed','notallowed','withdrawal','kickedout')),
name varchar2(100) not null,
phonenumber varchar2(100) not null,
email varchar2(100) not null,
address varchar2(100) not null,
loginstate varchar2(100) check(loginstate in('in','out'))
)

drop table erp_notice;

create table erp_notice(
board_seq  varchar2(100) primary key,
userid not null references erp_member(userid),
title varchar2(100) not null,
content varchar2(1000) not null,
time date default sysdate not null
)
 create sequence board_seq;
 
 drop table erp_file;
 
create table erp_file(
file_seq varchar2(100) primary key,
boared_seq not null references erp_notice(board_seq),
org_name varchar2(100) not null,
sav_name varchar2(100) not null,
time date default sysdate not null
)
 create sequence file_seq;
