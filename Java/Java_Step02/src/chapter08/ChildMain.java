package chapter08;

public class ChildMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Child child= new Child()	;
		
		child.method1(); //부모 메소드
		child.method2(); // 자신메소드
		child.method3(); // 자신메소드
		
		Parent parent1 = child;
		parent1.method1();
		parent1.method2();
	}

}
