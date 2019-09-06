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
				model.addAttribute("message", "Ż���� ȸ���Դϴ�");
				return "member/login";	
			}else{
				model.addAttribute("message", "���� ������ ���� ���� ȸ���Դϴ�");
				return "member/login";
			}
		}else{
			model.addAttribute("message", "���̵�, ��й�ȣ �Է��� �߸��Ǿ����ϴ�");
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
				model.addAttribute("message", "���� ����");
				return "member/withdrawal";	
			}
		}else{
			model.addAttribute("message", "��й�ȣ�� Ʋ���ϴ�");
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
