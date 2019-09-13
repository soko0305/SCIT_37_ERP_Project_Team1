package com.project.erp.dao;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.project.erp.vo.MemberVO;

@Mapper
@Repository
public interface MemberMapper {
	public int insertMember(MemberVO member);
	public MemberVO selectMemberById(MemberVO member);
 	public MemberVO updateLogin(MemberVO member);
 	public MemberVO updateLogout(MemberVO member);

  }
