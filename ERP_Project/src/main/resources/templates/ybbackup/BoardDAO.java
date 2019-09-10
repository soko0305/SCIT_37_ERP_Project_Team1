/*package com.project.erp.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.erp.vo.Board;
import com.project.erp.vo.FileVO;

@Repository
public class BoardDAO {

	@Autowired
	SqlSession sqlSession;

	public int insertBoard(Board board) {
		int result = 0;
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		try {
			result = mapper.insertBoard(board);
		} catch (Exception e) {
			e.printStackTrace();
			return result;
		}
		return result;
	}

	public ArrayList<Board> selectAllBoard(String searchWord, PageNavigator navi) {
		ArrayList<Board> bList = new ArrayList<Board>();

		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		try {

			RowBounds rb = new RowBounds(navi.getStartRecord(), navi.getCountPerPage());

			bList = mapper.selectAllBoard(searchWord, rb);

		} catch (Exception e) {
			e.printStackTrace();
			return bList;
		}
		return bList;
	}

	public Board selectBoard(String boardSeq) {
		Board result = null;

		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		try {
			result = mapper.selectBoard(boardSeq);
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

	public int updateBoard(Board board) {
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

	public int selectCount(String searchWord) {
		int result = 0;

		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		try {
			result = mapper.selectCount(searchWord);
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

	public FileVO selectFileBySeq(String fileSeq) {
		FileVO result = null;
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);

		try {
			result = mapper.selectFileBySeq(fileSeq);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return result;
		}
		return result;
	}

	public int deleteFile(String boardSeq) {
		int result = 0;

		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		try {
			result = mapper.deleteFile(boardSeq);
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

*/