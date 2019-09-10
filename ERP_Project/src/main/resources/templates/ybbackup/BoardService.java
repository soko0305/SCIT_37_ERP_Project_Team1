/*package com.project.erp.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.erp.vo.Board;
import com.project.erp.vo.FileVO;

@Service
public class BoardService {

	@Autowired
	BoardDAO bdao;

	public int insertBoard(Board board) {
		return bdao.insertBoard(board);
	}

	public ArrayList<Board> selectAllBoard(String searchWord, PageNavigator navi) {
		return bdao.selectAllBoard(searchWord, navi);
	}

	public Board selectBoard(String boardSeq) {
		return bdao.selectBoard(boardSeq);
	}

	public int deleteBoard(String boardSeq) {
		bdao.deleteFile(boardSeq);//파일삭제
		return bdao.deleteBoard(boardSeq);//게시글삭제
	}

	public int updateBoard(Board board) {
		return bdao.updateBoard(board);
	}

	public int selectCount(String searchWord) {
		return bdao.selectCount(searchWord);
	}


	public int insertFile(FileVO fvo) {

		return bdao.insertFile(fvo);
	}

	public FileVO selectFile(String boardSeq) {
		return bdao.selectFile(boardSeq);
	}
	
	public FileVO selectFileBySeq(String fileSeq) {
		return bdao.selectFileBySeq(fileSeq);
	}
	
	public int updateFile(FileVO fvo) {
		return bdao.updateFile(fvo);
	}
	

}*/