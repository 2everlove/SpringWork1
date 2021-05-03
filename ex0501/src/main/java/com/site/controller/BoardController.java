package com.site.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.site.vo.BoardVo;

@Controller
public class BoardController {
	
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "redirect:/index";
	}
	@RequestMapping("/loginCheck")
	public String loginCheck(HttpServletRequest request,
			@RequestParam("sid") String sid,
			@RequestParam("spw") String spw,Model model) {
		Map<String, Object> map = new HashMap<String, Object>();
		//db저장 uid:aaa upw:1111
		String id="aaa";
		String pw="1111";
		String nickName = "길동스";
		String loginUrl="";
		if(sid.equals(id) && spw.equals(pw)) {
			HttpSession session = request.getSession();
			session.setAttribute("session_flag", "success");
			session.setAttribute("session_id", id);
			session.setAttribute("session_nickName", nickName);
			map.put("msg", "로그인 성공");
			loginUrl="redirect:/index";
		}else {
			map.put("msg", "로그인 실패");
			loginUrl="redirect:/login";
		}
		return loginUrl;
	}
	
	@RequestMapping("/path01/{path1}")
	public String path01(@PathVariable String path1, Model model) {
		System.out.println("111"+path1);
		model.addAttribute("path1",path1);
		return "path01";
	}
	
	@RequestMapping("/repage")
	public Map<String, Object> repage(){
		Map<String, Object> map = new HashMap<String, Object>();
		String sno = "1";
		String id = "admin";
		String name = "홍길동";
		
		map.put("sno", sno);
		map.put("id", id);
		map.put("name", name);
		return map;
	}
	@RequestMapping("/board1")
	public String board1(Model model){
		model.addAttribute("sno",1);
		model.addAttribute("stitle","게시글 제목");
		model.addAttribute("sdate","2020-05-01");
		model.addAttribute("sname","홍길동");
		model.addAttribute("shit",1);
		return "board1";
	}
	
	@RequestMapping("/ajaxBoard")
	@ResponseBody
	public Map<String, Object> board2(@RequestParam("sno") @Nullable String sno){
		Map<String, Object> map = new HashMap<String, Object>();
		
		//데이터 리턴
//		map.put("sno", boardVo.getSno());
//		map.put("stitle", boardVo.getStitle());
//		map.put("sdate", boardVo.getSdate());
//		map.put("sname", boardVo.getSname());
//		map.put("shit", boardVo.getShit());
		return map;
	}
	
	
	

}
