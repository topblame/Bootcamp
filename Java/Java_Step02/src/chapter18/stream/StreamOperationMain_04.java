package chapter18.stream;

import java.util.Arrays;

public class StreamOperationMain_04 {

	public static void main(String[] args) {
		int arr[] = { 39, 58, 88, 56, 77, 99, 23 };
		System.out.println("기본형 스트림 통계 메서드");
		System.out.println("배열의 합" + Arrays.stream(arr).sum());
		System.out.println("배열의 평균: " + Arrays.stream(arr).average());
		System.out.println("배열의 최대값: " + Arrays.stream(arr).max());
		System.out.println("배열의 최소값: " + Arrays.stream(arr).min());
		System.out.println("배열의 요소 개수: " + Arrays.stream(arr).count());
	}

}
