package spr.spr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;


//@방식 (config.java에  @ComponentScan("spr.spr")를 통해 path 지정,) 
@Component
class Chef6{
	String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	//값 지정
	public Chef6(@Value("Di_6") String type) {
		System.out.println("Chef6의 C======"+type);
		this.type = type;
	}
}

//객체 생성
@Component
class Rest6{
	
	//Chef5 객체를 자동으로 주입->null안뜨게하려고
	@Autowired
	Chef6 chef;
	
	public Rest6() {
		System.out.println("Rest6()의 C====="+chef);
	}
	
	public Chef6 getChef() {
		return chef;
	}

	public void setChef(Chef6 chef) {
		System.out.println("Rest6 Setter====="+this.chef);
		this.chef = chef;
	}
	
	public Rest6(Chef6 chef) {
		System.out.println("Rest()의 C====="+this.chef);
		this.chef=chef;
	}
	
	@Override
	public String toString() {
		return chef.type+" 식당입니다.";
	}
	
}


public class DiTest6 {
	
	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		  
		  
		  System.out.println("rest6 : "+context.getBean("rest6"));
	}

}
