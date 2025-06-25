package kr.project;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Project02_C {
	public static void main(String[] args) {
		try {
			String url = "https://finance.naver.com/marketindex/exchangeList.naver";
			Document doc = Jsoup.connect(url).get();
			
			Elements rows = doc.select("table.tbl_exchange tbody tr");
			
			for (Element row: rows) {
				String nation = row.select("td.tit").text();
				String rate = row.select("td.sale").text();
				System.out.println(nation + ": "+ rate +"원");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
