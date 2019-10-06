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
import com.project.erp.service.MemberService;
import com.project.erp.vo.MemberVO;

@Controller
public class MemberController {

	
	@Autowired
	MemberService memberService;
	
	@RequestMapping(value="/selectMemberById", method = RequestMethod.GET)
	public @ResponseBody MemberVO selectMemberById(MemberVO member){
			MemberVO m = memberService.selectMemberById(member);
			return m;	
		
	}
	@RequestMapping(value="/selectMember ", method = RequestMethod.GET)
	public @ResponseBody MemberVO selectMember(MemberVO member){
			MemberVO m = memberService.selectMemberById(member);
			return m;	
		
	}
	@RequestMapping(value="/insertMember", method = RequestMethod.POST)
	public String insertMember(MemberVO member){ 
		int check = 0;
		check = memberService.insertMember(member);
 		return "member/login";
	}
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String login(){ 
 		return "member/login";
	}
	@RequestMapping(value="/signup", method = RequestMethod.GET)
	public String signup(){ 
 		return "member/signup";
	}
	
	@RequestMapping(value="/selectMemberByIdAndPw", method = RequestMethod.POST)
	public  @ResponseBody MemberVO selectMemberByIdAndPw(MemberVO member){
		MemberVO m = null;
		m= memberService.selectMemberByIdAndPw(member);
		return m;
	}
	@RequestMapping(value="/loginSuccess", method = RequestMethod.GET)
	public  String loginSuccess(String userid, HttpSession session){
					session.setAttribute("loginid", userid);
					MemberVO member = new MemberVO();
					member.setUserid(userid);
					MemberVO m = memberService.selectMemberById(member);
					session.setAttribute("loginuserstatus", m.getUserstatus());
					session.setAttribute("logindepartment", m.getUserdepartment());
					memberService.updateLogin(m);
		return "main/index";
	}
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
			int check =0;
			MemberVO m = new MemberVO();
			m.setUserid((String)session.getAttribute("loginid"));
			check = memberService.updateLogout(m);
			session.invalidate();
		
		return "member/login";
	}
	

	@RequestMapping(value = "/goPermitAccount", method = RequestMethod.GET)
	public String goPermitAccount(HttpSession session, Model model) {
		ArrayList<MemberVO> mList = null;
		mList = memberService.selectMemberBeforePemit();
		model.addAttribute("memberList", mList);
		return "member/permitAccount";
	}
	
	@RequestMapping(value = "/goPermitAccountRequest", method = RequestMethod.POST)
	public String goPermitAccountRequest(String userid, Model model) {
		int check = 0;
		check = memberService.permitAccount(userid);
		return "redirect:/goPermitAccount";
	}
	
	@RequestMapping(value = "/goRejectAccountRequest", method = RequestMethod.POST)
	public String goRejectAccountRequest(String userid, Model model) {
		int check = 0;
		check = memberService.rejectAccount(userid);
		return "redirect:/goPermitAccount";
	}
}
