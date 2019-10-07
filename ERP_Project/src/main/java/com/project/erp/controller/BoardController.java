package com.project.erp.controller;

import java.io.FileInputStream;
import java.util.ArrayList;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.jni.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.project.erp.dao.BoardDAO;
import com.project.erp.service.BoardService;
import com.project.erp.vo.BoardVO;
 
@Controller
public class BoardController {

	@Autowired
	BoardService bService;

 
	// 게시물 등록
	@RequestMapping(value = "/boardInsert", method = RequestMethod.POST)
	public String boardInsert(BoardVO board) {
		int result = bService.boardInsert(board);
		if (result == 0) {
			return "member/boardinsert";
		} else {
			return "redirect:/goBoardList";
		}
	}


	// 게시물 삭제
	@RequestMapping(value = "/deleteBoard", method = RequestMethod.POST)
	public String boardDelete(BoardVO board) {
		
		int result = bService.boardDelete(board);

		if (result == 0) {
			return "member/boarddelete";
		} else {
			return "redirect:/goBoardList";
		}
	}

	// 게시물 수정
	@ExceptionHandler
	@RequestMapping(value = "/boardUpdate", method = RequestMethod.POST)
	public String boardUpdate(BoardVO board) {

		int result = bService.boardUpdate(board);

		if (result == 0) {
			return "member/boardupdate";
		} else {
			return "member/board";
		}
	}
	// 게시물 출력을 위한 redirect(List출력)
		@RequestMapping(value = "/goBoardList", method = RequestMethod.GET)
		public String goSupplierList(Model model,HttpSession session) {
			ArrayList<BoardVO> result = bService.boardAllSelect();
			model.addAttribute("boardlist", result);
			return "member/board";
		}
		
		//게시물 삽입
		@RequestMapping(value = "/goBoardInsert", method = RequestMethod.GET)
		public String goBoardInsert(BoardVO board,HttpSession session) {
			
			    if (session.getAttribute("userid") != null) {
	        String userid = (String) session.getAttribute("userid");
	        board.setUserid(userid);
 	     }
			return "member/boardinsert";
		}
 
		//게시물 상세
		@RequestMapping(value = "/boarddetail", method = RequestMethod.GET)
		public String boardDetail(String boardSeq, Model model, HttpSession session) {
 
			
		BoardVO result = bService.selectBoard(boardSeq);
			model.addAttribute("boarddetail", result);			
 			return "member/boarddetail";
		}
 
		//게시물 숮벙
		@RequestMapping(value = "/goUpdateBoard", method = RequestMethod.POST)
		public String boardUpdate(BoardVO board, HttpSession session) {

			if (session.getAttribute("loginid") == null) {
				return "member/login";
			} else {
				String loginid = (String) session.getAttribute("loginid");
				
				String id = bService.selectBoard(board.getBoard_seq()).getUserid();
			if (loginid.equals(id)) {
					
				bService.updateBoard(board);
					
				} else {
					return "redirect:/goBoardList";
				}
			}

			return "redirect:/goBoardList";
		}		
		
		@RequestMapping(value="/board", method = RequestMethod.GET)
		public String board(){
			return "member/board";
		} 

/*		@RequestMapping(value = "/fileTest", method = RequestMethod.POST)
		public @ResponseBody String fileTest(MultipartFile uploadFile) {
			
			try{
				
			uploadFile.transferTo(new File("C:/File/"+uploadFile.getOriginalFilename()));
			
			}catch(Exception e){
				e.printStackTrace();
			}
			return "home";
		}
		
		
		@RequestMapping(value = "/downloadFile", method = RequestMethod.GET)
		public String downloadFile(HttpServletResponse response) {
			
			response.setHeader("Content-Disposition", "attachment;filename=Mybatis.zip");
			
			try {
				FileInputStream fis=new FileInputStream(new File("D:/File/Mybatis.zip"));
				ServletOutputStream sos=response.getOutputStream();
				
				FileCopyUtils.copy(fis, sos);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return "home";
		}*/
		
}







 


