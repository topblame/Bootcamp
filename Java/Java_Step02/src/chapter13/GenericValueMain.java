package chapter13;

public class GenericValueMain <T>{
	public static void main(String[] args) {
		GenericValue<String> v1 = new GenericValue<String>();	
		v1.setValue("100");
		System.out.println(v1.getValue());
		
		GenericValue<Integer> v2 = new GenericValue<Integer>();	
		v2.setValue(105);
		System.out.println(v2.getValue());
		
		GenericValue<Double> v3 =new GenericValue<Double> ();
		v3.setValue(106.3);
		System.out.println(v3.getValue());
		
		GenericValue<Character> v4 = new GenericValue<Character>();	
		v4.setValue('A');
		System.out.println(v4.getValue());
	}
}
