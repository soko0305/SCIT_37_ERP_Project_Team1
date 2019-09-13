package com.project.erp.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.erp.vo.BoardVO;
import com.project.erp.vo.FileVO;
import com.project.erp.vo.RawMaterialVO;
@Repository
public class BoardDAO {

 

	@Autowired
	SqlSessionTemplate sqlSession;

	public int boardInsert(BoardVO board) {
		int result = 0;
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		try {
			result = mapper.boardInsert(board);
		} catch (Exception e) {
			e.printStackTrace();
			return result;
		}
		return result;
	}

	public ArrayList<BoardVO> boardAllSelect() {
		ArrayList<BoardVO> result = null;

		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		try {
			result = mapper.boardAllSelect();
		} catch (Exception e) {
			e.printStackTrace();
			return result;
		}
		return result;
	}

	public BoardVO boardOneSelect(BoardVO board) {
		BoardVO result = null;

		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		try {
			result = mapper.boardOneSelect(board);
		} catch (Exception e) {
			e.printStackTrace();
			return result;
		}
		return result;
	}

	public int boardDelete(BoardVO board) {
		int result = 0;

		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		try {
			result = mapper.boardDelete(board);
		} catch (Exception e) {
			e.printStackTrace();
			return result;
		}
		return result;
	}

 
	
	public int boardUpdate(BoardVO board) {
		int result = 0;

		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		try {
			result = mapper.boardUpdate(board);
		} catch (Exception e) {
			e.printStackTrace();
			return result;
		}
		return result;
	}

	public BoardVO selectBoard(String board_seq) {
		 BoardVO result = null;

		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		try {
			result = mapper.selectBoard(board_seq);
		} catch (Exception e) {
			e.printStackTrace();
			return result;
		}
		return result;
}
	

	public int deleteBoard(String boardSeq) {
		int result = 0;
 
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		try {
			result = mapper.deleteBoard(boardSeq);
		} catch (Exception e) {
			e.printStackTrace();
			return result;
		}
		return result;
	}

	public int updateBoard(BoardVO board) {
		int result = 0;
 
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		try {
			result = mapper.updateBoard(board);
		} catch (Exception e) {
			e.printStackTrace();
			return result;
		}
		return result;
	}

	public int deleteAllBoard(String id) {
		int result = 0;
 
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		try {
			result = mapper.deleteAllBoard(id);
		} catch (Exception e) {
			e.printStackTrace();
			return result;
		}
		return result;
	}
}




