package com.project.erp.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gcp.vision.CloudVisionTemplate;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import com.google.cloud.vision.v1.AnnotateImageResponse;
import com.google.cloud.vision.v1.Feature;

@Service
public class VisionService {

	@Autowired
	private ResourceLoader resourceLoader;

	// [START spring_vision_autowire]
	@Autowired
	private CloudVisionTemplate cloudVisionTemplate;
	// [END spring_vision_autowire]

	public int getFaceDetection(String imageUrl) throws IOException {
		Resource imageResource = this.resourceLoader.getResource(imageUrl);
		int count = 0;
		AnnotateImageResponse response = this.cloudVisionTemplate.analyzeImage(imageResource,
				Feature.Type.OBJECT_LOCALIZATION);
		
		for (int i = 0; i < response.getLocalizedObjectAnnotationsList().size(); i++) {
			String name = response.getLocalizedObjectAnnotationsList().get(i).getName();
			if(name.equals("Packaged goods")||
			   name.equals("Box")
				) {
				count++;
			}
		 }
		System.out.println(count);
		System.out.println("ALL : " + response.getLocalizedObjectAnnotationsList());
		System.out.println("size : " + response.getLocalizedObjectAnnotationsList().size());
		System.out.println("======================================================================");
		return count;
	}
}
