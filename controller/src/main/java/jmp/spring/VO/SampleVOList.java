package jmp.spring.VO;

import java.util.ArrayList;

import lombok.Data;

@Data
public class SampleVOList {
	private ArrayList<SampleVo> list;

	public SampleVOList() {
		list=new ArrayList<SampleVo>();
	}
}
