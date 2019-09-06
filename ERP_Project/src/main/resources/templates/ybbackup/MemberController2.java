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
public class MemberController2 {

	@Autowired
	MemberDAO memberDao;
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String login(MemberVO member, HttpSession session, Model model){
		MemberVO m = memberDao.selectMember(member);
		if(m !=null){
			if(m.getUserstate().equals("allowed")){
				session.setAttribute("loginId", m.getUserid());
				return "index";
			}else if(m.getUserstate().equals("withdrawal")){
				model.addAttribute("message", "탈퇴한 회원입니다");
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
	
	@RequestMapping(value="/withdrawal", method = RequestMethod.POST)
	public String withdrawal(MemberVO member, HttpSession session, Model model){
		member.setUserid((String)session.getAttribute("userId"));
		MemberVO m = memberDao.selectMemberByIdAndPw(member);
		if(m !=null){
			int check = memberDao.deleteMember(m);
			if(check!=0){
				session.invalidate();
				return "index";	
			}else{
				model.addAttribute("message", "삭제 실패");
				return "member/withdrawal";	
			}
		}else{
			model.addAttribute("message", "비밀번호가 틀립니다");
			return "member/withdrawal";	
		}
	}
	
	@RequestMapping(value="/selectMemberById", method = RequestMethod.GET)
	public @ResponseBody MemberVO selectMemberById(MemberVO member){
		MemberVO m = memberDao.selectMemberById(member);
			return m;	
		
	}
	

	@RequestMapping(value="/insertMember", method = RequestMethod.POST)
	public String insertMember(MemberVO member ){ 
 		 
		 memberDao.insertMember(member);
 		return "member/login";
	}
	
	@RequestMapping(value="/selectRequestedMember", method = RequestMethod.GET)
	public @ResponseBody ArrayList<MemberVO> selectRequestedMember(){
		ArrayList<MemberVO> mList= null;
		mList = memberDao.selectRequestedMember();
		return mList;	
		
	}
	
	
	@RequestMapping(value="/updateUserState", method = RequestMethod.GET)
	public @ResponseBody ArrayList<MemberVO> updateUserState(MemberVO member){
		ArrayList<MemberVO> mList= null;
		int check = memberDao.updateUserState(member);
		mList = memberDao.selectRequestedMember();
		return mList;	
		
	}
	
	
}
