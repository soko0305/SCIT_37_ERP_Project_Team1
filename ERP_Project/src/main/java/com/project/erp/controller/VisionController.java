package com.project.erp.controller;


import com.google.cloud.vision.v1.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gcp.vision.CloudVisionTemplate;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;


@RestController
public class VisionController {
/*
	@Autowired
	private ResourceLoader resourceLoader;

	@Autowired
	private CloudVisionTemplate cloudVisionTemplate;

	 @RequestMapping("/getLabelDetection")
	    public void getLabelDetection() {

	        Resource imageResource = this.resourceLoader.getResource("file:src/main/resources/GoogleVision/cat.jpg");
	        AnnotateImageResponse response = this.cloudVisionTemplate.analyzeImage(
	                imageResource, Feature.Type.LABEL_DETECTION);

	        System.out.println(response.getLabelAnnotationsList().toString());
	    }
	    */
}
