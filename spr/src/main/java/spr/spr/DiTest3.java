package spr.spr;

//set방식
class Chef3{
	String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Chef3(String type) {
		System.out.println("Chef의 C======"+type);
		this.type = type;
	}
	
}

class Rest3{
	Chef3 chef;
	
	public Rest3() {
		System.out.println("Rest()의 C====="+chef);
	}
	
	public Chef3 getChef() {
		return chef;
	}

	public void setChef(Chef3 chef) {
		this.chef = chef;
	}
	
	@Override
	public String toString() {
		return chef.type+" 식당입니다.";
	}
	
}


public class DiTest3 {
	
	public static void main(String[] args) {
		Chef3 chef = new Chef3("Di_3");
		Rest3 rest=new Rest3();
		rest.setChef(chef);
		System.out.println(rest);
	}

}
