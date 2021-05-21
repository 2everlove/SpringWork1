package jmp.spring.domain;

import lombok.Data;

@Data
public class MenuVO {
	private String level;
	private String up_menu_id;
	private String menu_id;
	private String title;
	private String url;
}
