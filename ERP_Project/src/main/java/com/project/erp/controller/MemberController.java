package com.project.erp.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.project.erp.dao.BoardDAO;

import com.project.erp.dao.MemberDAO;
import com.project.erp.service.BoardService;
import com.project.erp.dao.OrderDAO;
import com.project.erp.service.MemberService;
import com.project.erp.service.ProductionService;
import com.project.erp.vo.BoardVO;
import com.project.erp.vo.ManufactureVO;
import com.project.erp.vo.MemberVO;
import com.project.erp.vo.Order_rawMaterialVO;

@Controller
public class MemberController {

	
	@Autowired
	MemberService memberService;
	@Autowired	
	BoardService bService;
	@Autowired
	ProductionService pService;	
	@Autowired
	OrderDAO oDAO;

	
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
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login1(){ 
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
	public  String loginSuccess(String userid, HttpSession session, Model model){
					session.setAttribute("loginid", userid);
					MemberVO member = new MemberVO();
					member.setUserid(userid);
					MemberVO m = memberService.selectMemberById(member);
					session.setAttribute("loginuserstatus", m.getUserstatus());
					session.setAttribute("logindepartment", m.getUserdepartment());
					memberService.updateLogin(m);
					ArrayList<BoardVO> list = null;
					list = bService.boardAllSelect();
					ArrayList<ManufactureVO> plist = pService.produceSelect();
					ArrayList<BoardVO> bbList = new ArrayList<>();
					ArrayList<ManufactureVO> ppList = new ArrayList<>();
				
					ArrayList<Order_rawMaterialVO> orderDash =  oDAO.orderDashSelect();
					ArrayList<Order_rawMaterialVO> orderDash1 =  new ArrayList<>();
					if(list!=null&&list.size()!=0&&plist!=null&&plist.size()!=0){
					for(int i=0;i<3;i++){
						bbList.add(list.get(i));
						ppList.add(plist.get(i));
						orderDash1.add(orderDash.get(i));
					}
					}	
					model.addAttribute("boardlist", bbList);
					model.addAttribute("producelist", ppList);
										
					
					/*발주 및 구매관리*/
					model.addAttribute("orderList", orderDash1);
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
