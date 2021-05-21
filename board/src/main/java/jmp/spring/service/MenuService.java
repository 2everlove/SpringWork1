package jmp.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import jmp.spring.domain.MenuVO;
@Service
public interface MenuService {
	public List<MenuVO> getMenuList();
}
