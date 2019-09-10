package com.project.erp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.erp.dao.BoardDAO;
 import com.project.erp.vo.BoardVO;
 
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
}


