package jmp.spring.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jmp.spring.domain.User;
import jmp.spring.service.UserService;
import lombok.Setter;

@RestController
public class UserAjaxController {

	@Setter(onMethod_= @Autowired)
	UserService service;
	
	@GetMapping("/get/{id}")
	public String getId(@PathVariable("id") String id) {
		User user = new User();
		user.setId(id);
		String checkUser = service.checkLogin(user);
		if(checkUser!=null) {
			return checkUser;
		} else {
			return "error";
		}
	}
	
	@PostMapping("/user/searchId")
	public Map<String, Object> getClassId(@RequestBody User user) {
		Map<String, Object> map = new HashMap<String, Object>();
		if(user != null) {
			System.out.println(user);
			User checkUser = service.checkId(user.getName(), user.getEmail());
			if(checkUser!= null) {
				map.put("result", checkUser.getId());
			} else {
				map.put("result", "error");
			}
		}
		return map;
	}
	
	@PostMapping("/user/searchPwd")
	public Map<String, Object> getClassPwd(@RequestBody User user) {
		Map<String, Object> map = new HashMap<String, Object>();
		if(user != null) {
			System.out.println(user);
			User checkUser = service.checkPwd(user.getId(), user.getEmail());
			if(checkUser!= null) {
				map.put("result", checkUser.getPwd());
			} else {
				map.put("result", "error");
			}
		}
		return map;
	}
}
