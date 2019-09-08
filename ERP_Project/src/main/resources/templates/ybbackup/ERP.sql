drop table erp_member;

create table erp_member(
userid varchar2(200) primary key,
userpw varchar2(200) not null,
userstatus varchar2(200)  not null ,
userdepartment varchar2(200)  not null ,
userstate varchar2(20) check(userstate in ('allowed',  'notallowed', 'withdrawal' , 'kickedout' )) ,
name varchar2(200)  not null,
phonenumber varchar2(200)  not null,
email varchar2(200)  not null,
address varchar2(200)  not null,
loginstate varchar2(20) check(loginstate in ('in',  'out' )) 
)
commit;

		INSERT INTO erp_member(
 				userid
				, userpw
				, userstatus
				, userdepartment
				, userstate
				, name
				, phonenumber
				, email
				, address
				,loginstate
		)
		VALUES(
 				'22'
				, '22'
				, '22'
				, '22'
				, 'allowed'
				, 'name'
				, '22'
				, '22'
				, '22'		
 				, 'in'
		);
        
        INSERT INTO erp_member(
 				userid
				, userpw
				, userstatus
				, userdepartment
				, userstate
				, name
				, phonenumber
				, email
				, address
				,loginstate
		)
		VALUES(
 				'11'
				, '11'
				, '22'
				, '22'
				, 'notallowed'
				, 'name'
				, '22'
				, '22'
				, '22'		
 				, 'out'
		);
        
        INSERT INTO erp_member(
 				userid
				, userpw
				, userstatus
				, userdepartment
				, userstate
				, name
				, phonenumber
				, email
				, address
				,loginstate
		)
		VALUES(
 				'33'
				, '33'
				, '22'
				, '22'
				, 'kickedout'
				, 'name'
				, '22'
				, '22'
				, '22'		
 				, 'out'
		);
        
	</insert>
	
	   
     drop table erp_notice;   
        
    create table erp_notice (
    board_seq varchar2(200) primary key,
    userid varchar2(20) not null references erp_member(userid),
    title varchar2(30) not null,
    content varchar2(1000) not null,
     time date default sysdate
);

create sequence notice_seq;

commit;
        
       drop table erp_file;   
        
    create table erp_file (
    file_seq varchar2(200) primary key,
    board_seq varchar2(200) not null references erp_notice(board_seq),
    org_name varchar2(100) not null,
    sav_name varchar2(100) not null,
     time date default sysdate
);

create sequence file_seq;

commit;

