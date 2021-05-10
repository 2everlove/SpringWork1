package jmp.spring.service;

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
		return mapper.login(user);
	}

}
