package jmp.spring.mapper;

import java.util.List;

import jmp.spring.domain.User;

public interface UserMapper {
	public User login(User user);
	
	public List<String> getRole(String id);
}
