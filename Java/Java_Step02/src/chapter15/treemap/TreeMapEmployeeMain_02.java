package chapter15.treemap;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class TreeMapEmployeeMain_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeMap<Integer, Employees> employeeMap = new TreeMap<Integer, Employees>();
		
		//employeemap에 5개 추가
		employeeMap.put(1, new Employees("David", 20));
		employeeMap.put(2, new Employees("Charlie", 20));
		employeeMap.put(3,new Employees("ALICE", 20));
		employeeMap.put(4,new Employees("KON", 20));
		employeeMap.put(5,new Employees("Bob", 20));
		
		System.out.println();
		
		for(Entry<Integer, Employees> entry : employeeMap.entrySet()) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
		
		//출력
		Integer employeeId = 1;
		System.out.println("\n "+ employeeId + "는 " + employeeMap.get(employeeId));
		//특정 직원 출력
		
		
	}

}
