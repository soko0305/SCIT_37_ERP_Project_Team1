create table erp_member(
userid varchar(20) primary key,
userpw varchar(20) not null,
userstatus varchar(20),
userdepartment varchar(20),
userstate varchar(20),
name varchar(20),
phonenumber number,
email varchar(20),
address varchar(20)
)
commit;