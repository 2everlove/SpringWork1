package org.zerock.mapper;

import org.apache.ibatis.annotations.Select;

//org.zerock.mapper.TimeMapper.getTime2 ->sqlSession을 이용하면 좌측 경로를 이용해야 함

public interface TimeMapper {
	
	// ; 없어야함
	@Select("select sysdate from dual")
	String getTime();
	
	String getTime2();
}
