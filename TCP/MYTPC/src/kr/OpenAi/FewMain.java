package kr.OpenAi;

import java.io.FileReader;
import java.util.Scanner;

import com.google.gson.Gson;

public class FewMain {
	public static void main(String[] args) {
		try {
		    // JSON 데이터 읽기
		    Gson gson = new Gson();
		    ChatRequest chatRequest = gson.fromJson(new FileReader("data.json"), ChatRequest.class);

		    // 모델 및 설정 출력
		    System.out.println("모델: " + chatRequest.getModel());
		    System.out.println("온도 (Temperature): " + chatRequest.getTemperature());

		    // 기존 메시지 출력
		    System.out.println("\n학습 데이터:");
		    chatRequest.getMessages().forEach(message -> {
		        System.out.println("Role: " + message.getRole());
		        System.out.println("Content Text: " + message.getContent());
		        System.out.println("--------------------------");
		    });

		    // 사용자 입력 받기
		    Scanner scanner = new Scanner(System.in);
		    System.out.println("\n질문을 입력하세요 (종료: exit):");

		    while (true) {
		        System.out.print("> ");
		        String userInput = scanner.nextLine();

		        if (userInput.equalsIgnoreCase("exit")) {
		            System.out.println("프로그램을 종료합니다.");
		            break;
		        }

		        // OpenAI API 호출 및 응답 출력
		        String response = OpenAIApi.getResponse(chatRequest, userInput);
		        System.out.println("답변: " + response);
		        System.out.println("--------------------------");
		    }

		} catch (Exception e) {
		    e.printStackTrace();
		}
	}
}
