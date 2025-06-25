package kr.project;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Project02_B {
	public static void main(String[] args) {	
		try {
			String url = "https://news.naver.com/main/list.naver?mode=LSD&mid=sec&sid1=105"; // IT/과학
			Document doc = Jsoup.connect(url).get();
			Elements newsItems = doc.select("ul.type06_headline li dt:not(.photo) a");
			for(Element el: newsItems) {
				System.out.println(el.text());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
