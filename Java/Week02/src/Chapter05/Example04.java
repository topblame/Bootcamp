package Chapter05;

public class Example04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Example04 calculator = new Example04();
		
		int[] numbers = {5, 10, 15, 20, 25};
		double average = calculator.calculatorAverage(numbers);
		System.out.println("배열의 평균 : " + average);
	}

	public double calculatorAverage(int[] numbers) {
		// TODO Auto-generated method stub
		double avg;
		int sum = 0;
//		for(int num = 0; num < numbers.length; num++) {
//			sum += numbers[num];
//		}
		for (int num : numbers) {
			sum += num;
		}
		System.out.println("합계: " + sum);
		avg = (double)sum/numbers.length;
		return avg;
	}

}
