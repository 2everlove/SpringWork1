package jmp.spring.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import jmp.spring.service.AttachService;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class UploadController {
	
	
	@GetMapping("/board/fileUpload")
	public void uploadForm() {
		log.info("upload form");
	}
	
	@PostMapping("/uploadFormAction")
	public void fileUpload(MultipartFile[] uploadFile, Model model) {
		for(MultipartFile multipartFile : uploadFile) {
			log.info("====================");
			//신규 생성 파일인 경우 attachNo 생성

			
			String uploadFolder = "C:\\upload";
			
			File saveFile = new File(uploadFolder, multipartFile.getOriginalFilename());
			try {
				//화면으로 넘어온 파일을 서버에 저장
				multipartFile.transferTo(saveFile);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
			log.info("File name : "+multipartFile.getOriginalFilename());
			log.info("File size : "+multipartFile.getSize());
		}
	}
	
}
