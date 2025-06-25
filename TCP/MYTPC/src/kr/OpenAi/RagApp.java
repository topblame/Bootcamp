package kr.OpenAi;

import java.util.List;
import java.util.Scanner;

public class RagApp {
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

        // 초기 문서 업로드
        String[] docs = {
                "인공지능은 데이터를 기반으로 의사결정을 내리는 기술이다.",
                "기계학습은 AI의 하위 분야로 학습된 데이터를 통해 예측을 수행한다."
        };
        for (int i = 0; i < docs.length; i++) {
            List<Float> vector = EmbeddingClient.getEmbedding(docs[i]);
            QdrantClient.uploadEmbedding("doc" + i, vector, docs[i]);
        }

        // 질문 입력 및 유사 문서 검색
        System.out.println("질문을 입력하세요:");
        String query = sc.nextLine();

        List<Float> queryVec = EmbeddingClient.getEmbedding(query);
        String relevantDoc = QdrantClient.search(query, queryVec);

        // OpenAI Chat 호출
        String prompt = "다음 문서를 참고하여 질문에 답하세요:\n" + relevantDoc + "\n\n질문: " + query;
        String answer = OpenAIChatService.getAnswerFromOpenAI(prompt);
        System.out.println("AI 응답:\n" + answer);
	}
}
