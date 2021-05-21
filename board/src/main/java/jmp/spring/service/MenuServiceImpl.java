package jmp.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jmp.spring.domain.MenuVO;
import jmp.spring.mapper.MenuMapper;
import lombok.Setter;

@Service
public class MenuServiceImpl implements MenuService{

	@Setter(onMethod_= @Autowired)
	private MenuMapper mapper;
	
	
	@Override
	public List<MenuVO> getMenuList() {
		List<MenuVO> list = mapper.getMenuList();
		return list;
	}

}
