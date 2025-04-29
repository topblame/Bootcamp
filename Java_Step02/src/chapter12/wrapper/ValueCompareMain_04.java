package chapter12.wrapper;


public class ValueCompareMain_04 {

	public static void main(String[] args) {
		//오토박싱의 범위
		System.out.println("[-128 ~ 128 초과할 경우]"); //1byte = 8bit
		Integer obj1 = 300; // 4byte = 32bit
		Integer obj2 = 300; 
		
		//주소 비교 
		System.out.println("== 결과: " + (obj1 == obj2)); //외부
		System.out.println("== 언박싱후 결과: " + (obj1.intValue() == obj2.intValue())); // 내부 값
		
		
		System.out.println("[-128~ 128 범위 내일 경우]");
		
		Integer obj3 = 100; //4byte = 32bit
		Integer obj4 = 100;
		System.out.println("== 결과: " + (obj3 == obj4)); //외부
		System.out.println("== 언박싱후 결과: " + (obj3.intValue() == obj4.intValue())); // 내부 값
		System.out.println("==equals: " + (obj3.equals(obj4)));
		
		
	}

}
