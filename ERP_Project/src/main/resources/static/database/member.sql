drop table erp_member;

create table erp_member(
userid varchar2(100) primary key,
userpw varchar2(100) not null,
userstatus varchar2(100) not null,
userdepartment varchar2(100) not null,
userstate varchar2(100) check(userstate in('allowed','notallowed','withdrawal','kickedout')),
name varchar2(100) not null,
phonenumber varchar2(100) not null,
email varchar2(100) not null,
address varchar2(100) not null,
loginstate varchar2(100) check(loginstate in('in','out'))
)
 