package soloproject;

import java.util.HashMap;

public class FruitManager {
	private HashMap<String, Integer> fruits;
	private int total;
	private int count;
	
	public FruitManager() {
		fruits = new HashMap<>();
        fruits.put("apple", 1000);
        fruits.put("grapes", 1500);
        fruits.put("mango", 1200);
        fruits.put("melon", 1400);
        fruits.put("strawberry", 1100);
        total = 0;
        count = 0;
	}
	public boolean purchase(String fruitName) {
        if (fruits.containsKey(fruitName)) {
            total += fruits.get(fruitName);
            count++;
            return true;
        }
        return false;
    }

    public void printSales() {
        System.out.println("손님수: " + count + "명, 총 매출: " + total + "원");
    }


}
