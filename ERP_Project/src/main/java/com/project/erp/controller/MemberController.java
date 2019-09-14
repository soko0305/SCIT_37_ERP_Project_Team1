package com.project.erp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.erp.dao.MemberDAO;
<<<<<<< HEAD
import com.project.erp.service.MemberService;
=======
>>>>>>> master
import com.project.erp.vo.MemberVO;

@Controller
public class MemberController {

	
	@Autowired
	MemberService memberService;
	
	//회원가입 화면
	@RequestMapping(value="/signup", method = RequestMethod.GET)
	public String signup(){
		return "member/signup";
	}

	//아이디로 조회
	@RequestMapping(value="/selectMemberById", method = RequestMethod.GET)
	public @ResponseBody MemberVO selectMemberById(MemberVO member){
			MemberVO m = memberService.selectMemberById(member);
			return m;	
		
	}
	
	//조회
	@RequestMapping(value="/selectMember ", method = RequestMethod.GET)
	public @ResponseBody MemberVO selectMember(MemberVO member){
			MemberVO m = memberService.selectMemberById(member);
			return m;	
		
	}
	
	//멤버 db 삽입
	@RequestMapping(value="/insertMember", method = RequestMethod.POST)
	public String insertMember(MemberVO member){ 
		int check = 0;
		check = memberService.insertMember(member);
 		return "member/login";
	}
<<<<<<< HEAD
	@RequestMapping(value="/selectMemberByIdAndPw", method = RequestMethod.POST)
	public  @ResponseBody MemberVO selectMemberByIdAndPw(MemberVO member){
		MemberVO m = null;
		m= memberService.selectMemberByIdAndPw(member);
		return m;
	}
	@RequestMapping(value="/loginSuccess", method = RequestMethod.GET)
	public  String login(String userid, HttpSession session){
					session.setAttribute("loginid", userid);
					MemberVO member = new MemberVO();
					member.setUserid(userid);
					MemberVO m = memberService.selectMemberById(member);
					session.setAttribute("loginuserstatus", m.getUserstatus());
					session.setAttribute("logindepartment", m.getUserdepartment());
					memberService.updateLogin(m);
		return "main/index";
=======
	
	//로그인
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String login(MemberVO member, HttpSession session, Model model){
		MemberVO m = memberDao.selectMemberById(member);
 		if(m !=null){
			if(m.getUserstate ().equals("allowed")){
 				session.setAttribute("loginid", m.getUserid());
 				
 				memberDao.updateLogin(member);
 				return "redirect:/goBoardList";
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
>>>>>>> master
	}
	
	//로그아웃
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
<<<<<<< HEAD
	public String logout(HttpSession session) {
			int check =0;
			MemberVO m = new MemberVO();
			m.setUserid((String)session.getAttribute("loginid"));
			check = memberService.updateLogout(m);
=======
	public String logout(MemberVO member, Model model, HttpSession session) {
		
			String userid = session.getAttribute("loginid").toString();
			memberDao.updateLogout(userid);
>>>>>>> master
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
