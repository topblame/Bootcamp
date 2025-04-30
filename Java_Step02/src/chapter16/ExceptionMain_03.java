package chapter16;

public class ExceptionMain_03 {
	public static void main(String[] args) {
		String[] sarr = {"soldesk", "developer", "course"};
		
		for(int i =0; i<= sarr.length; i++) {			
			try {
				System.out.println(sarr[i]);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("예외발생.");
				System.out.println(e.getMessage());
			}//try catch
			finally {
				//에러가 나던지말던지
				System.out.println("무조건 실행");
			}//finally
		}//for
		System.out.println("프로그램 정상종료.");
	}//main
}
