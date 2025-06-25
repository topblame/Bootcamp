package kr.project;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;

import javax.imageio.ImageIO;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import kr.soldesk.ExcelVO;

public class Project03_D {
	public static void main(String[] args) {
//		P6g6VslOy16Op9Zl3Leg
//
//		Ux7fpz50f6
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
	         System.out.print("책제목:");
	         String title = br.readLine();
	         System.out.print("책저자:");
	         String author = br.readLine();
	         System.out.print("출판사:");
	         String company = br.readLine();
	         
	         ExcelVO vo=new ExcelVO(title, author, company);
	         getIsbnImage(vo);
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      }   
	}
	
	private static void getIsbnImage(ExcelVO vo) {
		try {
			//네이버 요청()
			String openApi = "https://openapi.naver.com/v1/search/book_adv.xml?d_titl="
					+URLEncoder.encode(vo.getTitle(), "UTF-8")
					+URLEncoder.encode(vo.getAuthor(), "UTF-8")
					+URLEncoder.encode(vo.getCompany(), "UTF-8");
			// 요청
			URL url = new URL(openApi);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("X-Naver-Client-Id", "P6g6VslOy16Op9Zl3Leg");
	        con.setRequestProperty("X-Naver-Client-Secret", "Ux7fpz50f6");
	        //----------
	        int responseCode = con.getResponseCode();
	        System.out.println(responseCode); //200
	        
	        BufferedReader brl = null;
	        if(responseCode == 200) {
	        	brl = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
	        }
	        else {
	        	brl = new BufferedReader(new InputStreamReader(con.getErrorStream()));
	        	
	        }
	        String inputLine;
	        StringBuffer response = new StringBuffer();
	        
	        while((inputLine = brl.readLine()) !=null) {
	        	response.append(inputLine);
	        }
	        brl.close();
	        System.out.println(response.toString());
	        //isbn image
	        Document doc = Jsoup.parse(response.toString());
	        System.out.println(doc.toString());
	        
	        Element total = doc.select("total").first();
	        
	        if(!total.text().equals("0")) {
	        	//isbn
	        	Element isbn = doc.select("isbn").first();
	        	String isbnStr = isbn.text();
	        	String isbn_find = isbnStr.split(" ")[0];
	        	System.out.println("isbn_find: " + isbn_find);
	        	
	        	String imgDoc = doc.toString();
	        	String imgURL =imgDoc.substring(imgDoc.indexOf("<img>")+5, imgDoc.indexOf("<author>"));
	        	System.out.println("imgTag: "+ imgURL);
	        	vo.setImgurl(imgURL);
	        	
	        	String fileName = imgURL.substring(imgURL.lastIndexOf("/")+1 );
	        	System.out.println("fileName : " + fileName);
	        	System.out.println();
	        	System.out.println("최종 vo 출력");
	        	System.out.println(vo);
	        	
	        	String desinationFile ="image";
	        	String tempName = Long.valueOf(new Date().getTime()).toString();
	        	desinationFile += tempName;
	        	desinationFile += ".jpg";
	        	URL url1 = new URL(imgURL);
	        	
	        	BufferedImage image = ImageIO.read(url1);
	        	File destination = new File(desinationFile);
	        	ImageIO.write(image, "jpg", destination);
	        	System.out.println("이미지 다운로드 완료");
	        }
	        else {
	        	System.out.println("검색 데이터가 없습니다.");
	        }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
