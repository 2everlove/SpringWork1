package jmp.spring.service;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import jmp.spring.domain.User;

@Service
public interface UserService {
	public User login(User user);
	
	public int updateSessionkey(User user);
	
	public User loginSessionkey(String sessionkey);
	
	public int insertUser(User user);
	
	public String checkLogin(User user);
	
	public User checkId(String name, String email);
	
	public User checkPwd(String id, String email);
	
	public int updateUser(User user);

	int updateUser(User user, @Param("newPwd") String pwd);
	
}
