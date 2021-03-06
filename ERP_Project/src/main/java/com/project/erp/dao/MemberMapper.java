package com.project.erp.dao;


import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.project.erp.vo.MemberVO;

@Mapper
@Repository
public interface MemberMapper {
	public int insertMember(MemberVO member);
	
	public MemberVO selectMemberById(MemberVO member);
	
 	public int updateLogin(MemberVO member);
 	
 	public int updateLogout(MemberVO member);

	public MemberVO selectMemberByIdAndPw(MemberVO member);

	public ArrayList<MemberVO> selectMemberBeforePemit();

	public int rejectAccount(String userid);

	public int permitAccount(String userid);
	
  }
