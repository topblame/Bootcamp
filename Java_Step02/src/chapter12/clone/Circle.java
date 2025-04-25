package chapter12.clone;

//cloneable : 복제가능한 클래스로 선언
//cloneable 선언시 반드시 clone() 메서드 오버라이드 선언
public class Circle implements Cloneable {
	Point  point;
	int radius;
	
	
	public Circle(int x, int y, int radius) {
		//생성자에서 point의 객체 생성 즉 circle의 객체가 만들어지면 point의 객체가 필수로 생성됨
		point = new Point(x,y);
		this.radius = radius;
	}

	// 클래스의 객체 복사
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}







	@Override
	public String toString() {
		return "Circle [point=" + point + ", radius=" + radius + "]";
	}
	
	
}
