package Chapter05;

public class Example03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers = {7, 2, 9, 1, 5};
		int maxnum = findMax(numbers);
		System.out.println("최대값: "+ maxnum);
	}

	public static int findMax(int[] numbers) {
		// TODO Auto-generated method stub
		int max = 0;
//		for(int i = 0; i<numbers.length; i++) {
//			if(max < numbers[i]) {
//				max = numbers[i];
//			}//if
//		}//for
		for (int num:numbers) {
			if(max < num) {
				max = num;
			}//if
		}//
		return max;
	}

}
