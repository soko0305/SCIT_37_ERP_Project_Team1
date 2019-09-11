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
	public int insertFile(FileVO fvo) {

		int result = 0;

		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);

		try {
			result = mapper.insertFile(fvo);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return result;
		}
		return result;
	}

	public FileVO selectFile(String boardSeq) {

		FileVO result = null;

		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);

		try {
			result = mapper.selectFile(boardSeq);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return result;
		}
		return result;
	}

	public FileVO selectFileBySeq(String file_seq) {
		FileVO result = null;
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);

		try {
			result = mapper.selectFileBySeq(file_seq);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return result;
		}
		return result;
	}

	public int deleteFile(String board_seq) {
		int result = 0;

		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		try {
			result = mapper.deleteFile(board_seq);
		} catch (Exception e) {

			e.printStackTrace();
			return result;
		}
		return result;
	}

	 

	public int updateFile(FileVO fvo) {
		int result = 0;

		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		try {
			result = mapper.updateFile(fvo);
		} catch (Exception e) {

			e.printStackTrace();
			return result;
		}
		return result;
	}


}
