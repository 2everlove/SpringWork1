package spr.spr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;


//@방식 (config.xml 에 <context:component-scan base-package="spr.spr"></context:component-scan>를 통해 componet 지정, config.java로 path설정) 
@Component
class Chef5{
	String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	//값 지정
	public Chef5(@Value("Di_5") String type) {
		System.out.println("Chef5의 C======"+type);
		this.type = type;
	}
	
}

//객체 생성
@Component
class Rest5{
	
	//Chef5 객체를 자동으로 주입->null안뜨게하려고
	@Autowired
	Chef5 chef;
	
	public Rest5() {
		System.out.println("Rest5()의 C====="+chef);
	}
	
	public Chef5 getChef() {
		return chef;
	}

	public void setChef(Chef5 chef) {
		System.out.println("Rest5 Setter====="+this.chef);
		this.chef = chef;
	}
	
	public Rest5(Chef5 chef) {
		System.out.println("Rest5()의 C====="+this.chef);
		this.chef=chef;
	}
	
	@Override
	public String toString() {
		return chef.type+" 식당입니다.";
	}
	
}


public class DiTest5 {
	
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spr/spr/config.xml");
		  
		  
		  System.out.println("rest5 : "+context.getBean("rest5"));
	}

}
