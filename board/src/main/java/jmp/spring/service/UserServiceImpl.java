package jmp.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jmp.spring.domain.User;
import jmp.spring.mapper.UserMapper;
import lombok.Setter;

@Service
public class UserServiceImpl implements UserService {

	@Setter(onMethod_= @Autowired)
	UserMapper mapper;
	
	@Override
	public User login(User user) {
		User loginUser = mapper.login(user);
		if(loginUser != null) {
			List<String> role = mapper.getRole(loginUser.getId());
			loginUser.setRole(role);
		}
		return loginUser; 
	}

	@Override
	public int updateSessionkey(User user) {
		return mapper.updateSessionkey(user);
	}

	@Override
	public User loginSessionkey(String sessionkey) {
		User user = mapper.loginSessionkey(sessionkey);
		List<String> role = mapper.getRole(user.getId());
		user.setRole(role);
		return user;
	}

}
