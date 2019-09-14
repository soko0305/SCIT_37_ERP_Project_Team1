package com.project.erp.service;

<<<<<<< HEAD

=======
>>>>>>> master
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
<<<<<<< HEAD
import com.project.erp.dao.MemberDAO;
import com.project.erp.vo.MemberVO;


@Service
public class MemberService {
	
	@Autowired
	MemberDAO memberDao;

	public MemberVO selectMemberById(MemberVO member) {
		MemberVO m = null;
		m =memberDao.selectMemberById(member);
		return m;
	}

	public int insertMember(MemberVO member) {
		int check = 0;
		check = memberDao.insertMember(member);
		return check;
	}

	public int updateLogin(MemberVO member) {
		int check = 0;
		check = memberDao.updateLogin(member);
		return check;	
	}

	public int updateLogout(MemberVO member) {
		int check = 0;
		check = memberDao.updateLogout(member);
		return check;
	}

	public MemberVO selectMemberByIdAndPw(MemberVO member) {
		MemberVO m = null;
		m =memberDao.selectMemberByIdAndPw(member);
		return m;
	}

	public ArrayList<MemberVO> selectMemberBeforePemit() {
		ArrayList<MemberVO> mList = null;
		mList = memberDao.selectMemberBeforePemit();
		return mList;
	}

	public int permitAccount(String userid) {
		int check = 0;
		check = memberDao.permitAccount(userid);
		return check;
	}

	public int rejectAccount(String userid) {
		int check = 0;
		check = memberDao.rejectAccount(userid);
		return check;
	}

}
=======

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

>>>>>>> master
