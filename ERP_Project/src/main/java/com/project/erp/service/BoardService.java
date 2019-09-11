package com.project.erp.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.erp.dao.BoardDAO;
import com.project.erp.vo.BoardVO;
import com.project.erp.vo.FileVO;

@Service
public class BoardService {

	@Autowired
	BoardDAO bdao;

 
 
  
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
 
}

