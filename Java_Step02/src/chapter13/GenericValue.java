package chapter13;

public class GenericValue <T>{
	//멤버변수
	T value;
	//생성자
	
	//메서드
	public T getValue() {
		return value;
	}
	public void setValue(T value) {
		this.value = value;
	}
}
