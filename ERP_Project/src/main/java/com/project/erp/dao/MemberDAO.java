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

	public int updateLogin(MemberVO member) {
		int check =0;
		try{
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		check = mapper.updateLogin(member);
		}catch(Exception e){
			e.printStackTrace();
		}
		return check;
	}
 	public int updateLogout(MemberVO member){
 		int check =0;
		try{
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		check = mapper.updateLogout(member);
		}catch(Exception e){
			e.printStackTrace();
		}
 		return check;	
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
<<<<<<< HEAD

	public ArrayList<MemberVO> selectMemberBeforePemit() {
		ArrayList<MemberVO> mList = null;
=======
 	public MemberVO updateLogout(String member){
		MemberVO m = null;
>>>>>>> master
		try{
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		mList = mapper.selectMemberBeforePemit();
		}catch(Exception e){
			e.printStackTrace();
		}
		return mList;
	}

	public int permitAccount(String userid) {
 		int check =0;
		try{
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		check = mapper.permitAccount(userid);
		}catch(Exception e){
			e.printStackTrace();
		}
 		return check;	
	}

	public int rejectAccount(String userid) {
 		int check =0;
		try{
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		check = mapper.rejectAccount(userid);
		}catch(Exception e){
			e.printStackTrace();
		}
 		return check;	
	}


 }
