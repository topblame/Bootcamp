package chapter18.lambda;

@FunctionalInterface
interface MyFunctionInterface{
	void showMsg(String message);
}
public class LambdaMain_03 {
	public static void main(String[] args) {
		//람다식
		MyFunctionInterface f= s -> System.out.println(s);
		
		//#1
		f.showMsg("람다식 생성");
		
		//매개변수 람다식
		showMyMsg(f);
	}
	//---------------------------------------
	public static void showMyMsg(MyFunctionInterface f){
		f.showMsg("String형 매개변수로 사용되는 lambda식");
	}
}
