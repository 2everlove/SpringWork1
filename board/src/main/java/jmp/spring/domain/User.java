package jmp.spring.domain;

import lombok.Data;

@Data
public class User {
	private String id;
	private String pwd;
	private String enabled;
	private String name;
	private String email;
}