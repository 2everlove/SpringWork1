package spr.spr;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//config.xml 방식 (bean 값 설정)
class Chef4{
	String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Chef4(String type) {
		System.out.println("Chef4의 C======"+type);
		this.type = type;
	}
	
}

class Rest4{
	Chef4 chef;
	
	public Chef4 getChef() {
		return chef;
	}

	public void setChef(Chef4 chef) {
		System.out.println("Rest4 Setter====="+this.chef);
		this.chef = chef;
	}
	
	public Rest4() {
		System.out.println("Rest4()의 C====="+chef);
	}
	
	@Override
	public String toString() {
		return chef.type+" 식당입니다.";
	}
}


public class DiTest4 {
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spr/spr/config.xml");
		System.out.println(context.getBean("rest4"));
	}

}
