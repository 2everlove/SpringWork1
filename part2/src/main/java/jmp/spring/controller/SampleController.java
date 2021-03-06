package jmp.spring.controller;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import jmp.spring.vo.MainVo;
import jmp.spring.vo.SampleDTO;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController {
	
	@RequestMapping("")
	public void basic() {
		log.info("basic........");
	}
	
	@GetMapping("/ex01")
	public String ex01(SampleDTO dto) {
		log.info(""+ dto);
		return "ex01";
	}
	
	@GetMapping("/main")
	public void main(MainVo vo, Model model) {
		log.info("name : "+vo.getName());
		log.info("age : "+vo.getAge());
		log.info("main......");
		model.addAttribute("time", new Date());
	}
	
	@GetMapping("/ex02")
	public String ex02(@RequestParam("name") String name, @RequestParam("age") int age) {
		//@RequestParm은 primary key와 비슷
		log.info("name : "+name);
		log.info("age : "+age);
		return "ex02";
	}
	
	@GetMapping({"/ex02Bean", "/ex022"})
	public void ex02Bean (@ModelAttribute("sdto") SampleDTO dto) {
		log.info(dto);
	}
	
	private final String ADMIN = "jmp";
	@GetMapping("/login")
	public String login(String id) {
		String page="";
		if(null!=id) {
			if(ADMIN.equals(id.trim())) {
				log.info("id : "+id);
				page = "sample/login";
			}
			else {
				page = "sample/loginFail";
			}
		} else {
			log.info("id : "+id);
			return "sample/loginFail";
		}
		return page;
	}
	
	@GetMapping("/ex04")
	public String ex04(SampleDTO dto, @ModelAttribute("page") int page) {
		log.info("dto : "+dto);
		log.info("page : "+page);
		return "/sample/ex04";
	}
	
	@GetMapping("/ex05")
	public void ex05() {
		log.info("/ex05......");
	}
	
	@GetMapping("/ex06")
	public @ResponseBody SampleDTO ex06() {
		log.info("/ex06........");
		SampleDTO dto = new SampleDTO();
		dto.setAge(10);
		dto.setName("홍길동");
		
		return dto;
	}
	
	@GetMapping("/ex07")
	public ResponseEntity<String> ex07(){
		log.info("/ex07...........");
		String msg="{\"name\": \"홍길동\"}";
		HttpHeaders header = new HttpHeaders();
		header.add("Content-Type", "application/json;charset=UTF-8");
		return new ResponseEntity<>(msg, header, HttpStatus.OK);
	}
	
	@GetMapping("/re1")
	public String re1() {
		log.info("re1...........");
		
		//response.sendRedirect("...");
		return "redirect:/sample/re2";
	}
	
	@GetMapping("/re2")
	public void re2() {
		log.info("re2...........");
	}
	
	@GetMapping("/exUpload")
	public void exUpload() {
		log.info("/exUpload.....");
	}
	
	@PostMapping("/exUpload")
	public String exUploadPost(ArrayList<MultipartFile> files) {
		files.forEach(file ->{
			log.info("==================");
			log.info("name : "+file.getOriginalFilename());
			log.info("size : "+file.getSize()+" byte");
			log.info("contentType : "+file.getContentType());
		});
		return "sample/exUpload";
	}
}
