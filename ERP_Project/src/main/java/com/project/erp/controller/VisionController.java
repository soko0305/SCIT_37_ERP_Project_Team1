package com.project.erp.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.erp.service.VisionService;

@RestController
public class VisionController {
	
	@Autowired
	private VisionService vService;

	@RequestMapping("/getFaceDetection")
	public @ResponseBody int getFaceDetection(String imageUrl) throws IOException {
		int count = vService.getFaceDetection(imageUrl);
		return count;
	}
}