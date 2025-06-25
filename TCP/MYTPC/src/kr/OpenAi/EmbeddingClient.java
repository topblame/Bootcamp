package kr.OpenAi;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class EmbeddingClient {

    // ❗ Embedding 전용 엔드포인트
	private static final String API_URL = "https://api.openai.com/v1/chat/completions";
	private static final String API_KEY = "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";
	
    public static List<Float> getEmbedding(String text) throws Exception {

        // 1. newHttpClinet() → newHttpClient() 오타
        HttpClient client = HttpClient.newHttpClient();

        // 2. 요청 바디 생성
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> body = Map.of(
                "model", "text-embedding-3-small",
                "input", text
        );
        String json = mapper.writeValueAsString(body);

        // 3. HttpRequest 빌더 체이닝 위치·괄호 수정, header 오타(aplication → application)
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL))
                .header("Authorization", "Bearer " + API_KEY)
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();

        // 4. 요청 전송
        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());

        // 5. 응답 파싱
        JsonNode embedding =
                mapper.readTree(response.body())
                      .get("data").get(0).get("embedding");

        List<Float> vector = new ArrayList<>();
        for (JsonNode value : embedding) {
            vector.add((float) value.asDouble());
        }
        return vector; //소수로 변환
    }
}
