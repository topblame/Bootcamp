package kr.OpenAi;

import java.util.Scanner;

public class LangchainMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("긴문장을 입력하세요: ");
		String input = sc.nextLine();
		
		try {
			String result = OpenAIChainService.askChain(input);
			System.out.println("\n 요약 및 질문 생성 결과. ");
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		sc.close();
	}

}
