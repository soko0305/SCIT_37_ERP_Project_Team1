/*package com.project.erp.controller;

import java.io.FileInputStream;
import java.sql.Date;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.jni.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.project.erp.dao.BoardDAO;
import com.project.erp.service.BoardService;
import com.project.erp.vo.Board;
import com.project.erp.vo.FileVO;

@Controller
public class BoardController {

	@Autowired
	BoardService bService;
	@Autowired
	BoardDAO bdao;
	final static int COUNTPERPAGE = 5;
	final static int PAGEPERGROUP = 3;
	final static String UPLOADPATH = "D:/File/";

	@RequestMapping(value = "/goWrite", method = RequestMethod.GET)
	public String goWrite() {
		return "boardWrite";
	}

	@RequestMapping(value = "/boardWrite", method = RequestMethod.POST)
	public String boardWrite(MultipartFile upload, Board board, Model model, HttpSession session) {

		if (session.getAttribute("loginId") == null) {

			return "login";
		} else {

			String id = (String) session.getAttribute("loginId");
			board.setId(id);
			bService.insertBoard(board);

			if (!(upload.isEmpty() || upload == null || upload.getSize() == 0)) {

				String orgName = upload.getOriginalFilename();
				String savName;

				Date date = new Date();
				savName = date.getTime() + orgName;

				try {
					upload.transferTo(new File(UPLOADPATH + savName));

					FileVO fvo = new FileVO();
					fvo.setOrg_name(orgName);
					fvo.setOrg_name(savName);
					bService.insertFile(fvo);

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

		return "redirect:/getBoard";
	}

	@RequestMapping(value = "/getBoard", method = RequestMethod.GET)
	public String getBoard(Model model, @RequestParam(value = "page", defaultValue = "1") int page, String searchWord) {

		PageNavigator navi = new PageNavigator(COUNTPERPAGE, PAGEPERGROUP, page, bService.selectCount(searchWord));

		model.addAttribute("bList", bService.selectAllBoard(searchWord, navi));
		model.addAttribute("navi", navi);
		model.addAttribute("searchWord", searchWord);

		return "main";
	}

	@RequestMapping(value = "/boardDetail", method = RequestMethod.GET)
	public String boardDetail(String boardSeq, Model model) {

		model.addAttribute("board", bService.selectBoard(boardSeq));
 		model.addAttribute("file", bService.selectFile(boardSeq));

		return "boardDetail";
	}

	@RequestMapping(value = "/downloadFile", method = RequestMethod.GET)
	public void downloadFile(String fileSeq, HttpServletResponse response) {

		FileVO fvo = bService.selectFileBySeq(fileSeq);

		response.setHeader("Content-Disposition", "attachment;filename=" + fvo.getOrg_name());

		File file = new File(UPLOADPATH + fvo.getSav_name());
		try {
			FileInputStream fis = new FileInputStream(file);
			ServletOutputStream sos = response.getOutputStream();
			FileCopyUtils.copy(fis, sos);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@RequestMapping(value = "/deleteBoard", method = RequestMethod.POST)
	public String deleteBoard(String boardSeq, HttpSession session) {

		if (session.getAttribute("loginId") == null) {
			return "login";
		} else {
			String loginId = (String) session.getAttribute("loginId");
			String id = bService.selectBoard(boardSeq).getUserid();
			if (loginId.equals(id)) {

				FileVO fvo = bService.selectFile(boardSeq);

				if (fvo != null) {
					String path = UPLOADPATH + fvo.getSav_name();
					File file = new File(path);
					file.delete();
				}

				bService.deleteBoard(boardSeq);
			} else {
				return "redirect:/getBoard";
			}
		}

		return "redirect:/getBoard";
	}

	@RequestMapping(value = "/boardUpdate", method = RequestMethod.POST)
	public String boardUpdate(MultipartFile upload, Board board, HttpSession session) {

		if (session.getAttribute("loginId") == null) {
			return "login";
		} else {

			String loginId = (String) session.getAttribute("loginId");
			String id = bService.selectBoard(board.getBoard_seq()).getUserid();
			if (loginId.equals(id)) {

				if (upload != null) {
					if (upload.isEmpty() || upload.getSize() == 0) {
						bService.updateBoard(board);
					} else {
						String boardSeq = board.getBoard_seq();
						FileVO fvo = bService.selectFile(boardSeq);
						String fileName = fvo.getSav_name();
						String deletePath = UPLOADPATH + fileName;
						File delFile = new File(deletePath);
						delFile.delete(); // 원래파일삭제

						String orgName = upload.getOriginalFilename();
						String savName;
						Date date = new Date();
						savName = date.getTime() + orgName;

						try {
							upload.transferTo(new File(UPLOADPATH + savName));

							fvo = new FileVO();
							fvo.setOrg_name(orgName);
							fvo.setOrg_name(savName);
							fvo.setBoardSeq(board.getBoard_seq());

							bService.updateFile(fvo);
							bService.updateBoard(board);

						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}

					return "redirect:/getBoard";
				}
			}

			return "redirect:/getBoard";
		}
	}

	@RequestMapping(value = "/goUpdateBoard", method = RequestMethod.GET)
	public String goUpdateBoard(String boardSeq, Model model) {

		model.addAttribute("board", bService.selectBoard(boardSeq));
		model.addAttribute("file", bService.selectFile(boardSeq));

		return "boardWrite";
	}

	


}*/