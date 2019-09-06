package com.project.erp.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.project.erp.vo.MemberVO;

@Mapper
@Repository
public interface MemberMapper2 {

	public MemberVO selectMember(MemberVO member);
	public MemberVO selectMemberByIdAndPw(MemberVO member);
	public int deleteMember(MemberVO member);
	public MemberVO selectMemberById(MemberVO member);
	public int insertMember(MemberVO member);
	public int insertWorkerOrClient(MemberVO member);
	public ArrayList<MemberVO> selectRequestedMember();
	public int updateUserState(MemberVO member);
	public MemberVO selectClientById(MemberVO client);
}
