/*package com.project.erp.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;

import com.project.erp.vo.Board;
import com.project.erp.vo.FileVO;

public interface BoardMapper {

	public int insertBoard(Board board);
	public ArrayList<Board> selectAllBoard(String searchWord,RowBounds rb);//게시물 정보 가져오기
	public Board selectBoard(String boardSeq);
	public int deleteBoard(String boardSeq);
	public int updateBoard(Board board);
	public int deleteAllBoard(String id);
	public int selectCount(String searchWord);//전체레코드수
	
 	public ArrayList<HashMap<String,String>> selectReply(String boardSeq);

	public int insertFile(FileVO fvo);
	public FileVO selectFile(String boardSeq);
	public FileVO selectFileBySeq(String fileSeq);
	
	public int deleteFile(String boardSeq);
	public int deleteReply(String boardSeq);
	

	public int updateFile(FileVO fvo);
	public int deleteOneReply(String replySeq);
}*/