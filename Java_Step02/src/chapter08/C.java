package chapter08;

public class C extends A{

	public C() {
		// TODO Auto-generated constructor stub
		super();
		this.field = "value";
		this.method();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		C c = new C();//자식
		c.method(); //부모클래스
		
	}

}
