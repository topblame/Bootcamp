package chapter14.treeset;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetMain_01 {
	public static void main(String[] args) {
		Set<String> treeSet = new TreeSet<String>();
		//요소추가
		
		treeSet.add("Apple");
		treeSet.add("Orange");
		treeSet.add("Banana");
		
		treeSet.add("Apple");
		System.out.println("TreeSet : " + treeSet);
		
		if (treeSet.contains("Banana")) {
			System.out.println("Banana is in the TreeSet");
		}
		//요소 삭제
		treeSet.remove("orange");
		System.out.println("After Remove "+treeSet);
	}
}
