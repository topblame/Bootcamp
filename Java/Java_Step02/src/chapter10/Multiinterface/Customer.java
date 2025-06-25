package chapter10.Multiinterface;

public class Customer implements Buy, Sell{

	@Override
	public void sell() {
		// TODO Auto-generated method stub
		System.out.println("판매하기");
	}

	@Override
	public void buy() {
		// TODO Auto-generated method stub
		System.out.println("구매하기");
	}
	//추상 메서드는 아니지만 같은 메서드명이 존재하면 반드시 재정의하여 사용
	@Override
	public void order() {
		System.out.println("고객 판매 주문");
	}

}
