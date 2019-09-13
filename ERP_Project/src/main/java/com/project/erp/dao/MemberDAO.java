package com.project.erp.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.erp.vo.MemberVO;

@Repository
public class MemberDAO {

	@Autowired
	SqlSessionTemplate sqlSession;
	
	public int insertMember(MemberVO member) {
		int check = 0;
		try{
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		check = mapper.insertMember(member);
		}catch(Exception e){
			e.printStackTrace();
		}
		return check;
	}
	
	public MemberVO selectMemberById(MemberVO member) {
		MemberVO m = null;
		try{
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		m = mapper.selectMemberById(member);
		}catch(Exception e){
			e.printStackTrace();
		}
		return m;
	}

	public MemberVO updateLogin(MemberVO member) {
		// TODO Auto-generated method stub
		MemberVO m = null;
		try{
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		m = mapper.updateLogin(member);
		}catch(Exception e){
			e.printStackTrace();
		}
		return m;
	}
 	public MemberVO updateLogout(String member){
		MemberVO m = null;
		try{
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		m = mapper.updateLogout(member);
		}catch(Exception e){
			e.printStackTrace();
		}
 		return m;	
 	}


 }
