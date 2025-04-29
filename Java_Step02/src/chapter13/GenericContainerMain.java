package chapter13;

import chapter12.wrapper.IntergerMain_01;

public class GenericContainerMain<T> {
	public static void main(String[] args) {
		//문자열 아이템
		GenericContainer<String> stringContainer = new GenericContainer<String>(5);
		GenericContainer<Integer> IntegerContainer = new GenericContainer<Integer>(5);
		GenericContainer<Double> DContainer = new GenericContainer<Double>(5);
		
		stringContainer.addItem("Apple");
		stringContainer.addItem("Banana");
		stringContainer.addItem("Cherry");
		stringContainer.printItems();
		
		//타입제한으로 사용불가
//		String[] StringArray = {"1", "2", "3", "4", "5"};
//		stringContainer.sum(StringArray);
		// 숫자아이템 저장
		IntegerContainer.addItem(2);
		IntegerContainer.addItem(5);
		IntegerContainer.addItem(8);
		IntegerContainer.printItems();
		
		Integer[] IntegerArray = {1, 2, 3, 4, 5};
		System.out.println("sum of int array "+ IntegerContainer.sum(IntegerArray));
		
		//실수 아이템 저장
		DContainer.addItem(7.5);
		DContainer.addItem(8.5);
		DContainer.addItem(5.5);
		DContainer.printItems();
		
		Double[] doubleArray = {1.1, 2.2, 3.3, 4.4, 5.5};
		System.out.println("sum of int array "+ DContainer.sum(doubleArray));

	}
}
