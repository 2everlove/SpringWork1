package spr.spr;

//생성자 방식1
class Chef{
	String type;
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public Chef(String type) {
		System.out.println("Chef의 C======"+type);
		this.type = type;
	}
	
}

class Rest{
	Chef chef;
	
	public Rest() {
		System.out.println("Rest()의 C 호출");
		chef = new Chef("Di_1");
	}
	
	public Rest(Chef chef) {
		System.out.println("Rest()의 C====="+chef);
		this.chef=chef;
	}
	
	/*
	 * @Override public String toString() { return chef.type+" 식당입니다."; }
	 */
	
}

public class DiTest1 {
	
	public static void main(String[] args) {
		Rest rest = new Rest();
		System.out.println(rest.toString());
	}

}
