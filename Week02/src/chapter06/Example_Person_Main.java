package chapter06;

public class Example_Person_Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Example_person per = new Example_person();
		
		per.name = "홍길동";
		per.height = 180f;
		per.weight = 80f;
		
		System.out.println("이름 : "+per.name+ "| 키 : " + (int)per.height + "| 몸무게: " + (int)per.weight);
		System.out.println("--------------------------------------");
	
		Example_person per2 = new Example_person("븜길동");
		per2.height = 181f;
		per2.weight = 79f;
		System.out.println("이름 : "+per2.name+ "| 키 : " + (int)per2.height + "| 몸무게: " + (int)per2.weight);
		System.out.println("--------------------------------------");
		
		Example_person per3 = new Example_person("홍길동", 180, 80);
		per3.height = 181f;
		per3.weight = 79f;
		System.out.println("이름 : "+per3.name+ "| 키 : " + (int)per3.height + "| 몸무게: " + (int)per3.weight);
		System.out.println("--------------------------------------");
		
	}

}
