package com.project.erp.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.project.erp.vo.BoardVO;
import com.project.erp.vo.FileVO;

@Mapper
@Repository
public interface BoardMapper {

	public int boardInsert(BoardVO board);				//게시판등록
	
	public ArrayList<BoardVO> boardAllSelect();			 //게시판 전체 출력
	
	public BoardVO boardOneSelect(BoardVO board);		//게시판 선택 출력
	
	public int boardDelete(BoardVO board);				//게시판 삭제
	
	public int boardUpdate(BoardVO boardl);			//게시판 수정

	public BoardVO selectBoard(String board_seq);

 
	public int deleteBoard(String boardSeq);

	public int updateBoard(BoardVO board);

	public int deleteAllBoard(String id);

  

 

 }


