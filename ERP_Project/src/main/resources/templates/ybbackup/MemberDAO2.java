package com.project.erp.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.erp.vo.MemberVO;

@Repository
public class MemberDAO2 {

	@Autowired
	SqlSessionTemplate sqlSession;
	
	public MemberVO selectMember(MemberVO member) {
		MemberVO m = null;
		try{
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		m = mapper.selectMember(member);
		}catch(Exception e){
			e.printStackTrace();
		}
		return m;
	}

	public MemberVO selectMemberByIdAndPw(MemberVO member) {
		MemberVO m = null;
		try{
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		m = mapper.selectMemberByIdAndPw(member);
		}catch(Exception e){
			e.printStackTrace();
		}
		return m;
	}

	public int deleteMember(MemberVO member) {
		int check = 0;
		try{
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		check = mapper.deleteMember(member);
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

	public int insertWorkerOrClient(MemberVO member) {
		int check = 0;
		try{
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		check = mapper.insertWorkerOrClient(member);
		}catch(Exception e){
			e.printStackTrace();
		}
		return check;
	}

	public ArrayList<MemberVO> selectRequestedMember() {
		ArrayList<MemberVO> mList = null;
		try{
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		mList = mapper.selectRequestedMember();
		}catch(Exception e){
			e.printStackTrace();
		}
		return mList;
	}

	public int updateUserState(MemberVO member) {
		int check = 0;
		try{
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		check = mapper.updateUserState(member);
		}catch(Exception e){
			e.printStackTrace();
		}
		return check;
	}

	public MemberVO selectClientById(MemberVO client) {
		MemberVO m = null;
		try{
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		m = mapper.selectClientById(client);
		}catch(Exception e){
			e.printStackTrace();
		}
		return m;
	
}}
