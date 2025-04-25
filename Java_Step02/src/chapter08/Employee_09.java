package chapter08;

public class Employee_09 {
	String name;
	int salary;
	
	public Employee_09(String name, int salary) {
		this.name = name;
		this.salary = salary;
	}
	public void work() {
		System.out.println("직원이 일하고 있습니다.");
	}
	public void getInfo() {
		System.out.println("이름: "+ name + " 연봉: " + salary);
	}
}
