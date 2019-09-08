package com.project.erp.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.erp.dao.MemberDAO; 
import com.project.erp.vo.MemberVO;

@Controller
public class MemberController {

	@Autowired
	MemberDAO memberDao;
	
	@RequestMapping(value="/selectMemberById", method = RequestMethod.GET)
	public @ResponseBody MemberVO selectMemberById(MemberVO member){
		MemberVO m = memberDao.selectMemberById(member);
			return m;	
		
	}
	
	@RequestMapping(value="/insertMember", method = RequestMethod.POST)
	public String insertMember(MemberVO member){ 
		 memberDao.insertMember(member);
 		return "member/login";
	}
}
