package com.project.erp.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.erp.dao.BoardDAO;
import com.project.erp.dao.BoardMapper;
import com.project.erp.vo.BoardVO;
import com.project.erp.vo.FileVO;

@Service
public class BoardService {

	@Autowired
	BoardDAO bDAO;

	public int boardInsert(BoardVO board) {
		int result = bDAO.boardInsert(board);		
		return result;
	}
	public ArrayList<BoardVO> boardAllSelect() {
		ArrayList<BoardVO> result = bDAO.boardAllSelect();		
		return result;
	}
	public BoardVO boardOneSelect(BoardVO board) {
		BoardVO result = bDAO.boardOneSelect(board);		
		return result;
	}
	public int boardDelete(BoardVO board) {
		int result = bDAO.boardDelete(board);		
		return result;
	}
	public int boardUpdate(BoardVO board) {
		int result = 0;
			result = bDAO.boardUpdate(board);
		return result;
	}

	public BoardVO selectBoard(String board_seq) {
		BoardVO result = bDAO.selectBoard(board_seq);		
		return result;
	}
	public int updateBoard(BoardVO board) {
		int result = 0;
		result = bDAO.updateBoard(board);
	return result;
}

	public int deleteAllBoard(String id) {
		int result = 0;
		result = bDAO.deleteAllBoard(id);
	return result;
}
	
}
