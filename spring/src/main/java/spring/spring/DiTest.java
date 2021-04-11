package spring.spring;
import org.springframework.beans.factory.annotation.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
class Chef{
	
	String type;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Chef(@Value("중식") String type) {
		System.out.println("Chef생성자=========="+type);
		this.type = type;
	}
}

@Component
class Rest{	
	
	@Autowired
	Chef chef;

	public Chef getChef() {
		return chef;
	}
	
	
	public void setChef(Chef chef) {
		this.chef = chef;
		System.out.println("Rest Setter========"+this.chef);
	}
	
	public Rest() {
		System.out.println("Rest생성자=========="+this.chef);
		/* this.chef = chef; */
	}
	
	public String toString() {
		return chef.type+" 식당입니다.";
		
	}
}

public class DiTest {

	public static void main(String[] args) {
		
		/* Chef chef = new Chef("중식"); Rest rest = new Rest(); rest.setChef(chef); */
		  
		/* System.out.println(rest); */
		  
		  //ApplicationContext context = new ClassPathXmlApplicationContext("spring/spring/config.xml");
		  ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		  
		  
		  System.out.println("rest : "+context.getBean("rest"));
		 

	}

}
