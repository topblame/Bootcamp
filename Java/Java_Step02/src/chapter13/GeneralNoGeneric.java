package chapter13;

public class GeneralNoGeneric {
	//정수 배열 출력 메서드
	public void printIntArr(Integer[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(" "+ arr[i]);
		}
		System.out.println();
	}//printIntArr
	// 실수 배열 출력 메서드
	public void printDoubleArr(Double[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(" "+ arr[i]);
		}
		System.out.println();
	}//printDoubleArr
	//문자배열 출력 메서드
	public void printCharArr(Character[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(" "+ arr[i]);
		}
		System.out.println();
	}// printCharArr
}//class
