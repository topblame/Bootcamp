package kr.project;



import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Project02_A {
	public static void main(String[] args) {
		String url = "https://news.naver.com/";
		try {
			// 크롤링 봇으로 차단 되지 않게. 브라우징으로 위장
			Document doc = Jsoup.connect(url)
					.userAgent("Mozilla/5.0")
					.get(); //html을 가져옴
			
			Elements headlines = doc.select("a[href^=https://n.news.naver.com/article/]");
			System.out.println("▶ 주요 뉴스 헤드라인:");
            for (Element headline : headlines) {
                System.out.println(" - " + headline.text());
            }
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
