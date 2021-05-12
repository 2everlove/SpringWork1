package jmp.spring.domain;

import java.util.Date;
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
	private String sessionkey;
	private Date sessionlimit;
	public boolean hasRole(String role_id) {
		if(role != null) {
			return role.contains(role_id);			
		} else 
			return false;
	}
}