package kr.OpenAi;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class OpenAIChainService {
	private static final String API_URL = "https://api.openai.com/v1/chat/completions";
	private static final String API_KEY ="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";
	
	private static final String PROMPT_TEMPLATE = """
		너는 똑똑한 요약봇이야. 아래 내용을 요약한 뒤, 요약 내용을 기반으로 중요한 질문 두 개를 만들어줘.
        내용:
        %s
        """;
	public static String askChain(String userInput) throws Exception{
		String finalPrompt = String.format(PROMPT_TEMPLATE, userInput);
		
		Map<String, Object> requestData = Map.of(
	            "model", "gpt-4o",
            "messages", List.of(
                Map.of("role", "system", "content", "너는 요약과 질문 생성을 잘하는 어시스턴트야."),
                Map.of("role", "user", "content", finalPrompt)
            ),
            "max_tokens", 600,
            "temperature", 0.7
        );

        ObjectMapper mapper = new ObjectMapper();
        String requestBody = mapper.writeValueAsString(requestData);

        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(API_URL))
            .header("Content-Type", "application/json")
            .header("Authorization", "Bearer " + API_KEY)
            .POST(HttpRequest.BodyPublishers.ofString(requestBody))
            .build();

        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new RuntimeException("OpenAI API 호출 오류: " + response.body());
        }

        JsonNode root = mapper.readTree(response.body());
        return root.get("choices").get(0).get("message").get("content").asText();
		
	}
}	
