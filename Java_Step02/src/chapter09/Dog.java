package chapter09;

public class Dog extends Animal{
	public Dog() {
		this.kind = "포유류";
	}
	@Override
	public void sound() {
		System.out.println("머머머머머ㅓ어어머엄엉ㅁ");
	}
}
