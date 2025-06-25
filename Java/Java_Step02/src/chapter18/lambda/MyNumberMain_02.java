package chapter18.lambda;

public class MyNumberMain_02 {
	public static void main(String[] args) {
		//lambda 활용
		MyNumber max = (x,y)->(x>=y) ? x : y;
		System.out.println(max.getMax(10, 8));
		
		//일반적인 활용
		MyNumber aa = new MyNumber() {
			
			@Override
			public int getMax(int x, int y) {
				// TODO Auto-generated method stub
				int max = (x>=y) ? x : y;
				return max;
			}
		};
		System.out.println(aa.getMax(10, 20));
	}
}
