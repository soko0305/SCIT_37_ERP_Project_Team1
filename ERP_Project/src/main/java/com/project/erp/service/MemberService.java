package com.project.erp.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.erp.dao.BoardDAO;
import com.project.erp.dao.MemberDAO;
import com.project.erp.dao.MemberMapper;
import com.project.erp.vo.BoardVO;
import com.project.erp.vo.FileVO;
import com.project.erp.vo.MemberVO;

@Service
public class MemberService {

	@Autowired
	MemberDAO mDAO;

	public int insertMember(MemberVO member) {
		int result = mDAO.insertMember(member);
		return result;
	}
	public MemberVO selectMemberById(MemberVO member) {
		MemberVO result = mDAO.selectMemberById(member);
		return result;
	}

	public MemberVO updateLogin(MemberVO member) {
		MemberVO result = mDAO.updateLogin(member);
		return result;
	}
 	public MemberVO updateLogout(String member){
 		MemberVO result = mDAO.updateLogout(member);
		return result;
	}


	
 
}

