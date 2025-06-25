package chapter07;

public class CompanyMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Company_05 comp = new Company_05();
		Company_05 comp2 = new Company_05();
		
		System.out.println(comp);
		System.out.println(comp2);
		
		System.out.println("-----------------singleton--------------------");
		
		//Data 영역에 객체 생성
		Company_05 mycompany1 = Company_05.getInstance();
		Company_05 mycompany2 = Company_05.getInstance();
		System.out.println(mycompany1);
		System.out.println(mycompany2);
		System.out.println(mycompany1 == mycompany2);
	}

}
