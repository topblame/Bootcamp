package chapter08;

public class Paprica extends Vegitable_02 {
	private String color;
	private int price;
	private String name;
	
	
	public void Set2(String a, int b, String c) {
		color = a;
		price = b;
		name = c;
		
	}
	public void Disp1() {
		System.out.println("--------paprika---------");
		System.out.println("-분류-" + sort);
		System.out.println("--계절--" + season);
		
		//부모 클래스의 기본생성자 (super)를 이용하여 선언
		System.out.println("--이름--"  + super.name);
		System.out.println();
	}
	
	public void Disp2() {
		System.out.println("--------paprika---------");
		System.out.println("색깔 -" + color);
		System.out.println("-가격-" + price);
		System.out.println("-이름-"  + name);
		
		System.out.println();
	}
}
