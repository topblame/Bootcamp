package chapter12.string;

import java.util.Date;

public class ToStringMain_06 {

	public static void main(String[] args) {
		Object obj1 = new Object(); //최상위
		Date obj2 = new Date();
		
		System.out.println("Object: " + obj1.toString());
		System.out.println(obj2);
	}

}
