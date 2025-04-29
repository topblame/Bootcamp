package chapter14.arraylist;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayList_02 {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		System.out.println("list.size: " + list.size());
		
		int[] arr = {1, 2, 3 ,4 ,5};
		System.out.println(arr.length);
		
		list.add(100);
		list.add(50);
		System.out.println("list.size: " + list.size());
		
		for(int i  = 0 ; i <list.size(); i++) {
			System.out.println(list.get(i));
		}//for
		System.out.println("---Iterator----");
		//일반 데이터를 반복구조로 형변환
		Iterator<Integer> it = list.iterator();
		
		while(it.hasNext()) {
			int v = it.next();
			System.out.println(v);
		}//while
		
	}//main
	
}
