package jmp.spring.contol;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import jmp.spring.VO.SampleVo;
import jmp.spring.VO.SampleVOList;
import lombok.extern.log4j.Log4j;

@Controller
/* @RequestMapping("/sample/*") */
@Log4j
public class MainController {
	/*@GetMapping("/main")
	public String mainController(SampleVOList vo) {
		log.info("=== get mapping");
		System.out.println(vo.getList());
		return "main";
	}*/
	@GetMapping("/main")
	public String mainController(@ModelAttribute("v") SampleVOList vo) {
		log.info("=== get mapping");
		System.out.println(vo.getList());
		return "main";
	}
	
	@GetMapping("/login")
	public String login(@RequestParam("id") String id) { 
		String page = "";
		if("jmp".equals(id.trim())) {
			System.out.println(id);
			page = "login/login";
		} else {
			System.out.println(id);
			page = "login/loginFail"; 
		}
		return page;
	}
	
	@GetMapping("/forward")
	public String forward(Model model) {
		Date serverTime = new Date();
		model.addAttribute("ServerTime", serverTime);
		System.out.println("forward");
		return "forward:/res";
	}
	
	@GetMapping("/res")
	public String res() {
		System.out.println("res");
		return "res";
	}
	
	@GetMapping("/redirect")
	public String redirect(Model model) {
		Date serverTime = new Date();
		model.addAttribute("ServerTime", serverTime);
		System.out.println("redirect");
		return "redirect:/res";
	}
	
	@GetMapping("/dto")
	public @ResponseBody SampleVo vo() {
		SampleVo vo = new SampleVo();
		vo.setAge(400);
		vo.setName("?????????");
		return vo;
	}
	@GetMapping("/getJson")
	public @ResponseBody SampleVo getJson(SampleVo vo) {
		//jackson-databind
		//http://localhost:8090//getJson?name=%ED%99%8D%EA%B8%B8%EB%8F%99&age=30&ids=id1&ids=id2
		/*
		{
			name: "?????????",
			age: 30,
			ids: [
				"id1",
				"id2"
			]
		}
		*/
		System.out.println("==get json : "+vo);
		return vo;
	}
	
	@GetMapping("/entity")
	public ResponseEntity<String> entity(){
		String msg= "{\"name\":\"?????????\"}";
		HttpHeaders header = new HttpHeaders();
		header.add("Content-Type", "application/json;charset=UTF-8");
		return new ResponseEntity<String>(msg, header,  HttpStatus.OK);
	}
	
	@GetMapping("/fileUpload")//?????? ??????
	public String fileUpload(){
		log.info("/fileUpload......");
		return "/fileUpload";
	}
	
	@PostMapping("/fileUpload")//?????? ??????
	public String fileUploadExe(ArrayList<MultipartFile> files){
		
		files.forEach(file -> {
			System.out.println("======");
			log.info("name : "+file.getOriginalFilename());
			System.out.println("name : "+file.getOriginalFilename());
			log.info("size : "+file.getSize());
		});
		
		return "fileUpload";
	}

}
