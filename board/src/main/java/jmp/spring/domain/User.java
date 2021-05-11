package jmp.spring.domain;

import java.util.List;

import lombok.Data;

@Data
public class User {
	private String id;
	private String pwd;
	private String enabled;
	private String name;
	private String email;
	private List<String> role; //권한 사용자의 권한을 조회하여 입력
	
	public boolean hasRole(String role_id) {
		return role.contains(role_id);
	}
}