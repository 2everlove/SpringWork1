package jmp.spring.service;

import org.springframework.stereotype.Service;

import jmp.spring.domain.User;

@Service
public interface UserService {
	public User login(User user);
}