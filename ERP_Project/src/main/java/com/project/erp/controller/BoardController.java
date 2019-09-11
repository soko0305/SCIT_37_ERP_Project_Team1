package com.project.erp.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.tomcat.jni.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.project.erp.dao.BoardDAO;
 import com.project.erp.vo.BoardVO;
import com.project.erp.vo.RawMaterialVO;
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
			return "member/boardinsert";
		} else {
			return "redirect:/goBoardList";
		}
	}


	// 게시물 삭제
	@RequestMapping(value = "/boardDelete", method = RequestMethod.POST)
	public String boardDelete(BoardVO board) {
		
		int result = bDAO.boardDelete(board);

		if (result == 0) {
			return "member/boarddelete";
		} else {
			return "member/board";
		}
	}

	// 게시물 수정
	@ExceptionHandler
	@RequestMapping(value = "/boardUpdate", method = RequestMethod.POST)
	public String boardUpdate(BoardVO board) {

		int result = bDAO.boardUpdate(board);

		if (result == 0) {
			return "member/boardupdate";
		} else {
			return "member/board";
		}
	}
	// 게시물 출력을 위한 redirect(List출력)
		@RequestMapping(value = "/goBoardList", method = RequestMethod.GET)
		public String goSupplierList(Model model) {
			ArrayList<BoardVO> result = bDAO.boardAllSelect();
			model.addAttribute("boardlist", result);
			return "member/board";
		}
		
		@RequestMapping(value = "/goBoardInsert", method = RequestMethod.GET)
		public String goBoardInsert(BoardVO board,HttpSession session) {
			
			    if (session.getAttribute("userid") != null) {
	        String userid = (String) session.getAttribute("userid");
	        board.setUserid(userid);
 	     }
			return "member/boardinsert";
		}
		@RequestMapping("/insertProc")
	    private String boardInsertProc(HttpServletRequest request, @RequestPart MultipartFile files) throws Exception{
	        
	        BoardVO board = new BoardVO();
	        
	        board.setSubject(request.getParameter("subject"));
	        board.setContent(request.getParameter("content"));
	        board.setWriter(request.getParameter("writer"));
	        
	        String sourceFileName = files.getOriginalFilename(); 
	        String sourceFileNameExtension = FilenameUtils.getExtension(sourceFileName).toLowerCase(); 
	        File destinationFile; 
	        String destinationFileName;
	        String fileUrl = "uploadFiles 폴더 위치";
	 
	        
	        do { 
	            destinationFileName = RandomStringUtils.randomAlphanumeric(32) + "." + sourceFileNameExtension; 
	            destinationFile = new File(fileUrl + destinationFileName); 
	        } while (destinationFile.exists()); 
	        
	        destinationFile.getParentFile().mkdirs(); 
	        files.transferTo(destinationFile); 
	        
	        bDAO.boardInsertService(board);
	        
	        return "redirect:/list";
	    }


 }


