package jmp.spring.service;

import java.util.List;
import java.util.Properties;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import jmp.spring.domain.User;
import jmp.spring.mapper.UserMapper;
import lombok.Setter;

@Service
public class UserServiceImpl implements UserService {

	@Setter(onMethod_= {@Autowired})
	Properties prop;
	
	@Setter(onMethod_= {@Autowired})
	MailService ms;
	
	@Setter(onMethod_= @Autowired)
	UserMapper mapper;
	
	@Override
	public User login(User user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		User loginUser = mapper.login(user);
		if(loginUser != null && encoder.matches(user.getPwd(), loginUser.getPwd()) || user.getPwd().equals(loginUser.getPwd())) {
			System.out.println("boolean...."+encoder.matches(user.getPwd(), loginUser.getPwd()));
			System.out.println("login...");
			List<String> role = mapper.getRole(loginUser.getId());
			loginUser.setRole(role);
		} else {
			loginUser = null;
		}
		return loginUser;
	}
	
	@Override
	public String checkLogin(User user) {
		String id ="";
		User checkUser = mapper.login(user);
		if(checkUser != null)
			id=checkUser.getId();
		
		return id;
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

	@Override
	public int insertUser(User user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String prePwd = user.getPwd();
		String postPwd = encoder.encode(prePwd);
		user.setPwd(postPwd);
		int res = mapper.insertUser(user);
		if(res>0) {
			res = mapper.insertUserRole(user.getId(), "ROLE_USER");
		} else {
			res = 0;
		}
		
		return res;
	}

	@Override
	public User checkId(String name, String email) {
		return mapper.checkId(name, email);
	}

	@Override
	public User checkPwd(String id, String email) {
		User user = mapper.checkPwd(id, email);
		if(user!=null) {
			String uuid = UUID.randomUUID().toString().substring(0,7);
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			String postPwd = encoder.encode(uuid);
			mapper.pwdUdate(postPwd, user.getId(),user.getEmail());
			ms.sendMailPwd(user.getEmail(), uuid);
		}
		return user;
	}

	@Override
	public int updateUser(User user, String pwd) {
		User loginUser = login(user);
		int res=0;
		if(loginUser != null) {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			String newPwd = encoder.encode(pwd);
			loginUser.setPwd(newPwd);
			loginUser.setEmail(user.getEmail());
			mapper.updateUser(loginUser);
			res = 1;
		}
		return res;
	}



}
