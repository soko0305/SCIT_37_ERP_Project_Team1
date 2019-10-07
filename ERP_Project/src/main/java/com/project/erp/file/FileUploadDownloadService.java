package com.project.erp.file;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gcp.vision.CloudVisionTemplate;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.google.cloud.vision.v1.AnnotateImageResponse;
import com.google.cloud.vision.v1.Feature;

@Service
public class FileUploadDownloadService {
	 private final Path fileLocation;
	 
	 @Autowired
		private ResourceLoader resourceLoader;

		// [START spring_vision_autowire]
		@Autowired
		private CloudVisionTemplate cloudVisionTemplate;
		// [END spring_vision_autowire]
	    
	    @Autowired
	    public FileUploadDownloadService(FileUploadProperties prop) {
	        this.fileLocation = Paths.get(prop.getUploadDir())
	                .toAbsolutePath().normalize();
	        
	        try {
	            Files.createDirectories(this.fileLocation);
	        }catch(Exception e) {
	            throw new FileUploadException("파일을 업로드할 디렉토리를 생성하지 못했습니다.", e);
	        }
	    }
	    
	    
	    public String storeFile(MultipartFile file) {
	        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
	        
	        try {
	            // 파일명에 부적합 문자가 있는지 확인한다.
	            if(fileName.contains(".."))
	                throw new FileUploadException("파일명에 부적합 문자가 포함되어 있습니다. " + fileName);
	            
	            Path targetLocation = this.fileLocation.resolve(fileName);
	            
	            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
	            
	            return fileName;
	        }catch(Exception e) {
	            throw new FileUploadException("["+fileName+"] 파일 업로드에 실패하였습니다. 다시 시도하십시오.",e);
	        }
	    }

	    
	    public Resource loadFileAsResource(String fileName) {
	        try {
	            Path filePath = this.fileLocation.resolve(fileName).normalize();
	            Resource resource = new UrlResource(filePath.toUri());
	            
	            if(resource.exists()) {
	                return resource;
	            }else {
	                throw new FileDownloadException(fileName + " 파일을 찾을 수 없습니다.");
	            }
	        }catch(MalformedURLException e) {
	            throw new FileDownloadException(fileName + " 파일을 찾을 수 없습니다.", e);
	        }
	    }
	    
	    public int getObjectDetection(String fileDownloadUri) throws IOException {
			Resource imageResource = this.resourceLoader.getResource(fileDownloadUri);
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
			return count;
		}

}
