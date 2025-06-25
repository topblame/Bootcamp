package kr.OpenAi;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class TextChunker {
	//키워드가 포함된 텍스트만 추출
	public static String searchRelevantText(String filePath, String keyword) throws IOException {
		return Files.lines(Paths.get(filePath))
				.filter(line -> line.contains(keyword))
				.collect(Collectors.joining("\n"));
	}
}
