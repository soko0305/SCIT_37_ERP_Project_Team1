drop table erp_member;

create table erp_member(
userid varchar2(20) primary key,
userpw varchar2(20) not null,
userstatus varchar2(20),
userdepartment varchar2(20),
userstate varchar2(20) check(userstate in ('allowed',  'notallowed', 'withdrawal' , 'kickedout' )) ,
name varchar2(20),
phonenumber number,
email varchar2(20),
address varchar2(20)
loginstate varchar2(20) check(loginstate in ('in',  'out' )) 
)
commit;