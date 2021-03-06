package jmp.spring.ex01;

class Calculator {
	
	public int calculator(String val1, String val2, String operator){
		int result=0;
		if("0".equals(val1) || "0".equals(val2)) {
			return result = 0;
		}
		
		int v1 = Integer.parseInt(val1.trim());
		int v2 = Integer.parseInt(val2.trim());
		
		if("+".equals(operator)) {
			result = v1+v2;
		} else if("-".equals(operator)) {
			result = v1-v2;
		} else if("*".equals(operator)) {
			result = v1*v2;
		} else if("/".equals(operator)) {
			result = v1/v2;
		}
		return result;
	}
}