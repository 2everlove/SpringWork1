package spr.spr;

//생성자  방식2
class Chef2{
	String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Chef2(String type) {
		System.out.println("Chef의 C======"+type);
		this.type = type;
	}
	
}

class Rest2{
	Chef2 chef;
	
	public Rest2(Chef2 chef) {
		System.out.println("Rest()의 C====="+chef);
		this.chef=chef;
	}
	
	@Override
	public String toString() {
		return chef.type+" 식당입니다.";
	}
	
}

public class DiTest2 {
	
	public static void main(String[] args) {
		Chef2 chef = new Chef2("Di_2");
		Rest2 rest = new Rest2(chef);
		System.out.println(rest);
	}

}
