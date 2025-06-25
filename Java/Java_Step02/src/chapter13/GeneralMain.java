package chapter13;

public class GeneralMain {
	public static void main(String[] args) {
		//general
		
		General general = new General();
		
		//정수형 배열
		Integer[ ]  iArr = {10, 20, 30, 40, 50};
		general.printArr(iArr);
		
		Double[ ]  dArr = {10.1, 20.1, 30.1, 40.1, 50.1};
		general.printArr(dArr);
		
		Character[ ]  cArr = {'A', 'B', 'C', 'D', 'E'};
		general.printArr(cArr);
	}
	
}//class
