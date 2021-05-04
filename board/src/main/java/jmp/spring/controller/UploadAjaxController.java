package jmp.spring.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import jmp.spring.domain.AttachFileVO;
import jmp.spring.service.AttachService;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import net.coobird.thumbnailator.Thumbnails;

@RestController
@Log4j
public class UploadAjaxController {

	@Setter(onMethod_= @Autowired)
	private AttachService service;
	
	private static final String ROOT_DIR = "C:\\upload\\temp\\";
	
	
	//파일리스트 조회
	//@return List<AttachFileVO>
	@GetMapping("/fileUploadAjax/{attachNo}")
	public List<AttachFileVO> getList(@PathVariable("attachNo") Long attachNo){
		List<AttachFileVO> list = service.getList(attachNo);
	return list;	
	}
	
	@PostMapping("/fileUploadAjax")
	public Map<String, String> fileUpload(MultipartFile[] uploadFile, Long attachNo) {
		log.info("fileUpload...Ajax Post..."+attachNo);
		
		Map<String, String> map = new HashMap<String, String>();
		int res=0;
		
		if(null == attachNo || 0 == attachNo) {
			attachNo = service.getSeq();
		}
		
		for(MultipartFile multipartFile : uploadFile) {
			
			//중복 방지를 위해 UUID를 생성하여 파일명 앞에 붙여준다.(일련 번호 대신 유추하기 힘든 식별자를 사용)
			//universally unique identifier (UUID)
			
			
			String uploadPath = getFolder();
			
			//String uploadFileName = "_"+multipartFile.getOriginalFilename();
			
			log.info("File Name: "+multipartFile.getOriginalFilename());
			log.info("File Size: "+multipartFile.getSize());
			log.info("File Size: "+multipartFile.getContentType());
			log.info("===================================");
		
			
			//파일을 서버에 저장
			try {
				AttachFileVO attachFileVO = new AttachFileVO(attachNo, uploadPath, multipartFile.getOriginalFilename());
				
				//File saveFile = new File(ATTACHES_DIR+uploadPath, uploadFileName);
				File saveFile = new File(ROOT_DIR+attachFileVO.getSavepath());
				multipartFile.transferTo(saveFile);
				
				//확장자를 이용하여 MimeType을 결정
				//마임타입을 확인하지 못하면 null 반
				String contentType = Files.probeContentType(saveFile.toPath());
				
				//이미지 파일인 경우 썸네일 생성
				//contentType이 image로 시작하면 썸네일 생성
				if(null != contentType && contentType.startsWith("image")) {
					//썸네일 생성할 경로 지정 (ex: 2021\5\2\s_fileName)
					//String thmbanil = ROOT_DIR+uploadPath+"s_"+uploadFileName;
					//원본 파일의 size를 지정해서 경로에 저장
					Thumbnails.of(saveFile).size(100, 100).toFile(ROOT_DIR+attachFileVO.getS_savepath());
					
					//이미지면 VO의 fileType을 Y로 저장
					attachFileVO.setFiletype("Y");
					
				}
				//VO에 저장된 파일정보를 DB에 저장
				if(service.insert(attachFileVO)>0) {
					res++;
				}
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}			
		}
		//attachNo에 해당하는 파일리스틀를 조회하여 화면에 출력
		//List<AttachFileVO> list =  service.getList(attachNo);
		map.put("attachNo", attachNo+"");
		map.put("count", res+"");
		//log.info(list);
		return map;
	}//

	//중복 방지용, 업로드 날자를 업로드 경로로 지정, 지정된 경로에 폴더가 존재하지 않으면 생성
	//@return uploadPath
	private String getFolder() {
		String uploadPath="";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//날짜 형식을 지정 (yyyy-MM-dd)
		String str = sdf.format(new Date());//오늘 날짜를 형식에 맞게 가져옴
		
		//separator는 UNIX systems '/', Windows systems '\\'로 나눠준다.
		//ex) 2021\05\03\
		uploadPath = str.replace("-", File.separator)+File.separator; //경로만 받자! ROOT_DIR뺴고
		log.info("uploadPath : "+uploadPath);
		
		File saveFile = new File(ROOT_DIR+uploadPath);
		
		//경로가 존재하지 않으면 경로 생성
		if(!saveFile.exists()) {
			//여러개의 파일을 만들땐 mkdirs
			saveFile.mkdirs();
		}
		return uploadPath;
	}
}
