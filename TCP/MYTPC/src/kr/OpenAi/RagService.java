package kr.OpenAi;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;



public class RagService {
	private static final String API_URL = "https://api.openai.com/v1/chat/completions";
	private static final String API_KEY ="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";
	
	private static final String PROMPT_TEMPLATE = """
		    아래 문서를 기반으로 질문에 답하세요. 문서 외 지식은 사용하지 마세요.

		    문서:
		    %s

		    질문: %s
		    """;
	//GPT에게 질문하고 응답을 받아서 리턴하는 메서드
	//context: 문서, question: 질문
	public static String askWithContext(String context, String question)
	        throws IOException, InterruptedException {

	    String prompt = String.format(PROMPT_TEMPLATE, context, question);

	    Map<String, Object> request = Map.of(
	        "model", "gpt-4o",
	        "messages", List.of(
	            Map.of("role", "system", "content", "당신은 문서 기반 질의응답 어시스턴트입니다."),
	            Map.of("role", "user", "content", prompt)
	        ),
	        "max_tokens", 600,
	        "temperature", 0.3
	    );
	    
	    //JSON 변환(JAVA의 map객체를 변환
	    ObjectMapper mapper = new ObjectMapper();
	    String requestBody = mapper.writeValueAsString(request);

	    HttpRequest httpRequest = HttpRequest.newBuilder()
	        .uri(URI.create(API_URL))
	        .header("Content-Type", "application/json")
	        .header("Authorization", "Bearer " + API_KEY)
	        .POST(HttpRequest.BodyPublishers.ofString(requestBody))
	        .build();

	    //응답 처리 
	    HttpResponse<String> response = HttpClient.newHttpClient()
	        .send(httpRequest, HttpResponse.BodyHandlers.ofString());

	    if (response.statusCode() != 200) {
	        throw new RuntimeException("API 호출 실패: " + response.body());
	    }

	    JsonNode json = mapper.readTree(response.body());
	    return json.get("choices").get(0).get("message").get("content").asText();
	}
	//==================================================
}
