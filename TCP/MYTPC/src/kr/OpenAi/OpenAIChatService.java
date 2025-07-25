package kr.OpenAi;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class OpenAIChatService {
	private static final String API_URL = "https://api.openai.com/v1/chat/completions";
	private static final String API_KEY ="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";
	//NLP (딥러닝기법: Natural Language Processing) 자연어 처리
	//Transformer(Attention 알고리즘)
	//사전학습(Pre - training) + 미세조정(Fine-tuning)
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("질문을 입력하세요. ");
		String UserQuestion = scanner.nextLine();
		try {
			String response =getAnswerFromOpenAI(UserQuestion);
			System.out.println("AI 응답:");
			System.out.println(response);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static String getAnswerFromOpenAI(String question) throws Exception  {
		// TODO Auto-generated method stub
		//요청 데이터 생성
	      Map<String, Object> requestData = Map.of(
	                "model", "gpt-4o",
	                "messages", List.of(
	                    Map.of("role", "user", "content", question)
	                ),
	                "max_tokens", 500,
	                "temperature", 0.7
	            );
	      
	      //ObjectMapper():JSON 변환
	      ObjectMapper objectMapper = new ObjectMapper();
	        String requestBody = objectMapper.writeValueAsString(requestData);
	        System.out.println("요청 데이터: " + requestBody);//요청 데이터 로그
	        
	        //HTTP 요청 생성
	        HttpClient client = HttpClient.newHttpClient();
	        HttpRequest request=HttpRequest.newBuilder()
	              .uri(URI.create(API_URL)) //API URL 설정
	              .header("Content-Type", "application/json") //JSON
	              .header("Authorization", "Bearer " + API_KEY) //API 키
	              .POST(HttpRequest.BodyPublishers.ofString(requestBody))
	              .build();
	        
	        //HTTP 요청 전송 및 응답 처리
	        HttpResponse<String> response=client.send(request, HttpResponse.BodyHandlers.ofString());
	      
	        //상태 코드 확인 및 디버깅용 출력
	        if (response.statusCode() != 200) {
	            System.out.println("응답 상태 코드: " + response.statusCode());
	            System.out.println("응답 본문: " + response.body());
	            throw new RuntimeException("API 호출 실패: HTTP 상태 코드 " + response.statusCode());
	        }
	        
	        //JSON 응답처리
	        JsonNode responseJson=objectMapper.readTree(response.body());
	        System.out.println("API 응답 본문: " + response.body()); //디버깅
	        
	        //응답 받은 Json에 choices 필드가 존재하거나 배열인지를 확인
	        JsonNode choices = responseJson.get("choices");
	        if (choices == null || !choices.isArray()) {
	            throw new RuntimeException("'choices' 필드가 없습니다.");
	        }
	        //choices 배열의 첫 번째 요소에서 message 필드와 그안에 content 필드 가져오기
	        JsonNode message = choices.get(0).get("message");
	        if (message == null || !message.has("content")) {
	            throw new RuntimeException("'content' 필드가 없습니다.");
	        }
	        
	        return message.get("content").asText(); //content필드에 text내용 반환
	   }
	
}
