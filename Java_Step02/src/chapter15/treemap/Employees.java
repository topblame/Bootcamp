package chapter15.treemap;

public class Employees {
	//클래스를 메서드화 
	String name;
	int age;
	public Employees(String name, int age) {
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name + " : " + age;
	}
	
	

	
}
