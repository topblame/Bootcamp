package kr.project;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Project02_D {
	public static void main(String[] args) {
		try {
			String query = "서울 날씨";
            String url = "https://m.search.naver.com/search.naver?where=m&query=" +
                         java.net.URLEncoder.encode(query, "UTF-8");
            Document doc = Jsoup.connect(url)
                                .userAgent("Mozilla/5.0")
                                .get();
			Elements tempElem = doc.select(".temperature_text");
			Elements descElem = doc.select(".weather_main");
			if(!tempElem.isEmpty()&&!descElem.isEmpty()) {
				String temp = tempElem.first().text();
				String desc = descElem.first().text();
				System.out.println("현재 날씨: " + desc);
				System.out.println("현재 기온: " + temp);
			}
			else {
				System.out.println("날씨 정보를 가져오지 못했습니다.");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
