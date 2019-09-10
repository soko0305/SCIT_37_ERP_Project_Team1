package com.project.erp.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.erp.dao.BoardDAO;
 import com.project.erp.vo.BoardVO;
import com.project.erp.vo.SupplierVO;
 
@Controller
public class BoardController {

	@Autowired
	BoardDAO bDAO;

	// 게시물 등록
	@RequestMapping(value = "/boardInsert", method = RequestMethod.POST)
	public String boardInsert(BoardVO board) {

		int result = bDAO.boardInsert(board);

		if (result == 0) {
			return "/member/board";
		} else {
			return "/member/board";
		}
	}

	// 게시물 삭제
	@RequestMapping(value = "/boardDelete", method = RequestMethod.POST)
	public String boardDelete(BoardVO board) {
		
		int result = bDAO.boardDelete(board);

		if (result == 0) {
			return "/member/board";
		} else {
			return "/member/board";
		}
	}

	// 게시물 수정
	@ExceptionHandler
	@RequestMapping(value = "/boardUpdate", method = RequestMethod.POST)
	public String boardUpdate(BoardVO board) {

		int result = bDAO.boardUpdate(board);

		if (result == 0) {
			return "/member/board";
		} else {
			return "/member/board";
		}
	}
	// 게시물 출력을 위한 redirect(List출력)
		@RequestMapping(value = "/goBoardList", method = RequestMethod.GET)
		public String goSupplierList(Model model) {
			ArrayList<BoardVO> result = bDAO.boardAllSelect();
			model.addAttribute("boardlist", result);
			return "member/board";
		}
		@RequestMapping(value = "/goBoardList2", method = RequestMethod.GET)
		public String goSupplierList2(Model model) {
			ArrayList<BoardVO> result = bDAO.boardAllSelect();
			model.addAttribute("boardlist", result);
			return "member/board2";
		}
}


