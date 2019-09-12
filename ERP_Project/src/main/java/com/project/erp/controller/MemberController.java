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
	@RequestMapping(value="/selectMember ", method = RequestMethod.GET)
	public @ResponseBody MemberVO selectMember(MemberVO member){
		MemberVO m = memberDao.selectMemberById(member);
			return m;	
		
	}
	@RequestMapping(value="/insertMember", method = RequestMethod.POST)
	public String insertMember(MemberVO member){ 
		 memberDao.insertMember(member);
 		return "member/login";
	}
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String login(MemberVO member, HttpSession session, Model model){
		MemberVO m = memberDao.selectMemberById(member);
 		if(m !=null){
			if(m.getUserstate ().equals("allowed")){
				System.out.println("allowed");
				session.setAttribute("loginid", m.getUserid());
				return "redirect:/";
			}else if(m.getUserstate().equals("withdrawal")){
				model.addAttribute("message", "탈퇴한 회원입니다");
				return "member/login";	
			}else if(m.getUserstate().equals("kickedout")){
				model.addAttribute("message", "강제탈퇴된 회원입니다");
				return "member/login";	
			}else{
				model.addAttribute("message", "아직 인증이 되지 않은 회원입니다");
				return "member/login";
			}
		}else{
			model.addAttribute("message", "아이디, 비밀번호 입력이 잘못되었습니다");
			return "member/login";	
		}
	}
}
