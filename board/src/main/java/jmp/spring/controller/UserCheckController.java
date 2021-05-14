package jmp.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import jmp.spring.domain.User;
import jmp.spring.service.UserService;
import lombok.Setter;

@RestController
public class UserCheckController {

	@Setter(onMethod_= @Autowired)
	UserService service;
	
	@GetMapping("/get/{id}")
	public String getId(@PathVariable("id") String id) {
		User user = new User();
		user.setId(id);
		String checkUser = service.checkLogin(user);
		return checkUser;
	}
}
