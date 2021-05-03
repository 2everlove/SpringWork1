package jmp.spring.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import jmp.spring.domain.AttachFileVO;
import jmp.spring.service.AttachService;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import net.coobird.thumbnailator.Thumbnailator;
import net.coobird.thumbnailator.Thumbnails;

@RestController
@Log4j
public class UploadAjaxController {

	@Setter(onMethod_= @Autowired)
	private AttachService service;
	
	private static final String ROOT_DIR = "C:\\upload\\temp\\";
	
	@PostMapping("/fileUploadAjax")
	public List<AttachFileVO> fileUpload(MultipartFile[] uploadFile, Long attachNo) {
		log.info("fileUpload...Ajax Post..."+attachNo);
		
		if(null == attachNo || 0 == attachNo) {
			attachNo = service.getSeq();
		}
		
		for(MultipartFile multipartFile : uploadFile) {
			
			log.info("File Name: "+multipartFile.getOriginalFilename());
			log.info("File Size: "+multipartFile.getSize());
			log.info("File Size: "+multipartFile.getContentType());
		
			
			//중복 방지를 위해 UUID를 생성하여 파일명 앞에 붙여준다.(일련 번호 대신 유추하기 힘든 식별자를 사용)
			//universally unique identifier (UUID)
			UUID uuid = UUID.randomUUID();
			
			String uploadPath = getFolder();
			
			String uploadFileName = uuid.toString()+"_"+multipartFile.getOriginalFilename();
			
			
			//파일을 서버에 저장
			File saveFile = new File(ROOT_DIR+uploadPath, uploadFileName);
			try {
				multipartFile.transferTo(saveFile);
				
				//확장자를 이용하여 MimeType을 결정
				//마임타입을 확인하지 못하면 null 반
				String contentType = Files.probeContentType(saveFile.toPath());
				
				//이미지 파일인 경우 썸네일 생성
				if(contentType.startsWith("image")) {
					//썸네일 생성할 경로 지정 (ex: 2021\5\2\s_fileName)
					String thmbanil = ROOT_DIR+uploadPath+"s_"+uploadFileName;
					//contentType이 image로 시작하면 썸네일 생성
					Thumbnails.of(saveFile).size(100, 100).toFile(thmbanil);
					
					//VO생성 후 파일정보를 VO에 저장
					AttachFileVO attachFileVO = new AttachFileVO();
					attachFileVO.setUuid(uuid.toString());
					attachFileVO.setAttachNo(attachNo);
					attachFileVO.setFileName(multipartFile.getOriginalFilename());
					attachFileVO.setFiletype(contentType.startsWith("image")?"Y":"N");
					attachFileVO.setUploadPath(uploadPath);
					
					//VO에 저장된 파일정보를 DB에 저장
					service.insert(attachFileVO);
				}
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}			
		}
		//attachNo에 해당하는 파일리스틀를 조회하여 화면에 출력
		List<AttachFileVO> list =  service.getList(attachNo);
		log.info(list);
		return list;
	}//

	//중복 방지용, 업로드 날자를 업로드 경로로 지정, 지정된 경로에 폴더가 존재하지 않으면 생성
	//@return uploadPath
	private String getFolder() {
		String uploadPath="";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//날짜 형식을 지정 (yyyy-MM-dd)
		String str = sdf.format(new Date());//오늘 날짜를 형식에 맞게 가져옴
		
		//separator는 UNIX systems '/', Windows systems '\\'로 나눠준다.
		//ex) 2021\05\03\
		uploadPath = str.replace("-", File.separator)+File.separator;
		log.info("uploadPath"+uploadPath);
		
		File saveFile = new File(ROOT_DIR+uploadPath);
		
		//경로가 존재하지 않으면 경로 생성
		if(!saveFile.exists()) {
			//여러개의 파일을 만들땐 mkdirs
			if(saveFile.mkdirs()) {
				log.info("폴더 생성 완료");
			} else {
				log.info("폴더 생성 실패");				
			}
		}
		return uploadPath;
	}
}
