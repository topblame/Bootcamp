package kr.OpenAi;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class QdrantClient {
	//https://cloud.qdrant.io
	private static final String QDRANT_URL = "http://localhost:6333";
    //docs: qdrant의 컬렉션의 이름.
	private static final String COLLECTION_NAME = "docs";
     
    public static void uploadEmbedding(String id, List<Float> vector, String content) throws Exception {
        Map<String, Object> payload = Map.of(
                "points", List.of(
                        Map.of(
                                "id", id,
                                "vector", vector,
                                "payload", Map.of("text", content)
                        )
                )
        );
        String json = new ObjectMapper().writeValueAsString(payload);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(QDRANT_URL + "/collections/" + COLLECTION_NAME + "/points"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();
        HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
    }

    public static String search(String query, List<Float> vector) throws Exception {
        Map<String, Object> body = Map.of(
                "vector", vector,
                "top", 1,
                "with_payload", true
        );
        String json = new ObjectMapper().writeValueAsString(body);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(QDRANT_URL + "/collections/" + COLLECTION_NAME + "/points/search"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();

        // 2️⃣ HttpClient.send()에 올바른 타입 전달
        HttpResponse<String> response =
                HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        JsonNode result = new ObjectMapper().readTree(response.body());
        return result.get("result").get(0).get("payload").get("text").asText();
    }
}
