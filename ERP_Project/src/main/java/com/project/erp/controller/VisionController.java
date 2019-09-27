package com.project.erp.controller;


import com.google.cloud.vision.v1.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gcp.vision.CloudVisionTemplate;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;


@RestController
public class VisionController {
	@Autowired
	  private ResourceLoader resourceLoader;

	  // [START spring_vision_autowire]
	  @Autowired
	  private CloudVisionTemplate cloudVisionTemplate;
	  // [END spring_vision_autowire]



	  
	  
	@RequestMapping("/getFaceDetection")
	public String getFaceDetection(String imageUrl) throws IOException {
	  Resource imageResource = this.resourceLoader.getResource(imageUrl);
	  /*Resource outputImageResource = this.resourceLoader.getResource("file:src/main/resources/output.jpg");*/
	  AnnotateImageResponse response = this.cloudVisionTemplate.analyzeImage(
	          imageResource, Feature.Type.OBJECT_LOCALIZATION);
	  /*writeWithFaces(imageResource.getFile().toPath(), outputImageResource.getFile().toPath(), response.getFaceAnnotationsList());*/
	  System.out.println(response.getLocalizedObjectAnnotationsList().size());
	  return response.getLocalizedObjectAnnotationsList().toString();
	}

	/*private static void writeWithFaces(Path inputPath, Path outputPath, List faces)
	        throws IOException {
	  BufferedImage img = ImageIO.read(inputPath.toFile());
	  annotateWithFaces(img, faces);
	  ImageIO.write(img, "jpg", outputPath.toFile());
	}
	public static void annotateWithFaces(BufferedImage img, List faces) {
	  for (FaceAnnotation face : faces) {
	      annotateWithFace(img, face);
	  }
	}
	private static void annotateWithFace(BufferedImage img, FaceAnnotation face) {
	  Graphics2D gfx = img.createGraphics();
	  Polygon poly = new Polygon();
	  for (Vertex vertex : face.getFdBoundingPoly().getVerticesList()) {
	      poly.addPoint(vertex.getX(), vertex.getY());
	  }
	  gfx.setStroke(new BasicStroke(5));
	  gfx.setColor(new Color(0x00ff00));
	  gfx.draw(poly);
	}*/



	/*@RequestMapping("/getImageTest")
	public static void detectLocalizedObjectsGcs(String gcsPath, PrintStream out)
	    throws Exception, IOException {
	  List<AnnotateImageRequest> requests = new ArrayList<>();

	  ImageSource imgSource = ImageSource.newBuilder().setGcsImageUri(gcsPath).build();
	  Image img = Image.newBuilder().setSource(imgSource).build();

	  AnnotateImageRequest request =
	      AnnotateImageRequest.newBuilder()
	          .addFeatures(Feature.newBuilder().setType(Type.OBJECT_LOCALIZATION))
	          .setImage(img)
	          .build();
	  requests.add(request);

	  // Perform the request
	  try (ImageAnnotatorClient client = ImageAnnotatorClient.create()) {
	    BatchAnnotateImagesResponse response = client.batchAnnotateImages(requests);
	    List<AnnotateImageResponse> responses = response.getResponsesList();
	    client.close();
	    // Display the results
	    for (AnnotateImageResponse res : responses) {
	      for (LocalizedObjectAnnotation entity : res.getLocalizedObjectAnnotationsList()) {
	         System.out.println(entity.getName());
	        out.format("Object name: %s\n", entity.getName());
	        out.format("Confidence: %s\n", entity.getScore());
	        out.format("Normalized Vertices:\n");
	        entity
	            .getBoundingPoly()
	            .getNormalizedVerticesList()
	            .forEach(vertex -> out.format("- (%s, %s)\n", vertex.getX(), vertex.getY()));
	      }
	    }
	  }
	}*/
	}