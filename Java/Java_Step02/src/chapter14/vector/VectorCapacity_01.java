package chapter14.vector;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class VectorCapacity_01 {
	public static void main(String[] args) {
		//Vector 방식 : 동기화 즉 멀티 스레드에서 사용
		// 최근에는 Arraylist를  기본으로 사용하고 synchronizedList를 추가하여 사용
		
		// 구버젼 기본용량 10
		Vector<String> vector = new Vector<String>();
		//ArrayList를 synchronizedList로 추가
		//List<String> syscList = Collections.synchronizedList(new ArrayList<>());
		
		
		System.out.println("------------ 기본크기 ---------------");
		System.out.println("초기 크기: "+vector.size());
		System.out.println("초기용량 : "+vector.capacity());
		
		vector.add("Apple");
		vector.add("Banana");
		vector.add("Cherry");
		
		System.out.println("추가 후 크기: "+vector.size());
		System.out.println("추가후 용량 : "+vector.capacity());
		
		for(int i  = 0 ; i<8; i++) {
			vector.add("K");
		}
		System.out.println("추가 후 크기: "+vector.size());
		System.out.println("추가후 용량 : "+vector.capacity());
		
		for(int i  = 0 ; i<10; i++) {
			vector.add("K");
		}
		System.out.println("추가 후 크기: "+vector.size());
		System.out.println("추가후 용량 : "+vector.capacity());
	}
}
