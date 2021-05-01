package com.site.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReController {
	
	@GetMapping("/restPage")
	public Map<String, Object> restPage() {
		Map<String, Object> map = new HashMap<String, Object>();
		String msg = "데이터를 성공적으로 가지고 왔습니다.";
		String id = "admin";
		String name = "홍길동";
		
		map.put("msg", msg);
		map.put("id", id);
		map.put("name", name);
		return map;
	}

}
