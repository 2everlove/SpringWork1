package jmp.spring.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.log4j.Log4j;

@RestController
@Log4j
public class UploadAjaxController {

	@PostMapping("/fileUploadAjax")
	public void fileUpload(MultipartFile[] uploadFile) {
		String Location = "C:\\upload\\temp";
		log.info("fileUpload...Ajax Post...");
		
		for(MultipartFile multipartFile : uploadFile) {
			
			File file = new File(Location, multipartFile.getOriginalFilename());
			try {
				multipartFile.transferTo(file);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
			
			log.info("File Name: "+multipartFile.getOriginalFilename());
			log.info("File Size: "+multipartFile.getSize());
			log.info("File Size: "+multipartFile.getContentType());
			
		}
	}
}
