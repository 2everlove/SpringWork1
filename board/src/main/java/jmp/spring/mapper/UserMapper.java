package jmp.spring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import jmp.spring.domain.User;

public interface UserMapper {
	public User login(User user);
	
	public List<String> getRole(String id);
	
	public int updateSessionkey(User user);
	
	public User loginSessionkey(String sessionkey);
	
	public int insertUser(User user);
	
	public int insertUserRole(@Param("id") String id, @Param("role") String role);
	
	public User checkId(@Param("name") String name, @Param("email") String email);
	
	public User checkPwd(@Param("id") String id, @Param("email") String email);
	
	public int pwdUdate(@Param("pwd") String pwd, @Param("id") String id, @Param("email") String email);
	
	public int updateUser(User user);
}
