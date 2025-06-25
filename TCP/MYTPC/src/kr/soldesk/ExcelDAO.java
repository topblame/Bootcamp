package kr.soldesk;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.IOUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class ExcelDAO {
	private List<ExcelVO> list; //ExcelVO 객체
	private HSSFWorkbook wb;// 엑셀파일 생성객체
	
	public ExcelDAO() {
		list =new ArrayList<ExcelVO>();
		wb = new HSSFWorkbook();//파일
	}
	
	public void excel_input() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {	
			 HSSFSheet firstSheet = wb.createSheet("Book Sheet");
	         // row
	         HSSFRow rowA = firstSheet.createRow(0);
	         // cell 책제목, 저자, 출판사, isbn, 이미지 이름, 이미지
	         HSSFCell cellA = rowA.createCell(0);
	         cellA.setCellValue(new HSSFRichTextString("책제목"));
	         HSSFCell cellB = rowA.createCell(1);
	         cellB.setCellValue(new HSSFRichTextString("저자"));
	         HSSFCell cellC = rowA.createCell(2);
	         cellC.setCellValue(new HSSFRichTextString("출판사"));
	         HSSFCell cellD = rowA.createCell(3);
	         cellD.setCellValue(new HSSFRichTextString("isbn"));
	         HSSFCell cellE = rowA.createCell(4);
	         cellE.setCellValue(new HSSFRichTextString("이미지이름"));
	         HSSFCell cellF = rowA.createCell(5);
	         cellF.setCellValue(new HSSFRichTextString("이미지"));
	
	         int i = 1;
	         while (true) {
	            System.out.print("책제목:");
	            String title = br.readLine();
	            System.out.print("책저자:");
	            String author = br.readLine();
	            System.out.print("출판사:");
	            String company = br.readLine();
	
	            HSSFRow rowRal = firstSheet.createRow(i);
	
	            HSSFCell cellTitle = rowRal.createCell(0);
	            cellTitle.setCellValue(new HSSFRichTextString(title));
	            HSSFCell cellAuthor = rowRal.createCell(1);
	            cellAuthor.setCellValue(new HSSFRichTextString(author));
	            HSSFCell cellCompany = rowRal.createCell(2);
	            cellCompany.setCellValue(new HSSFRichTextString(company));
	            i++;
	
	            ExcelVO vo = new ExcelVO(title, author, company);
	            // isbn, image 검색
	            ExcelVO data = naver_search(vo);
	            list.add(data);
	            System.out.print("계속입력 하시려면 Y/ 입력종료 N: ");
	            String key = br.readLine();
	            if (key.equals("N"))
	               break;
	         }
	         System.out.println("데이터 추출중.....");
	         excel_save(); // 저장
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	}
	public ExcelVO naver_search(ExcelVO vo) {
		try {
			String URL_STATICMAP = "https://openapi.naver.com/v1/search/book_adv.xml?d_titl="
		               + URLEncoder.encode(vo.getTitle(), "UTF-8") + "&d_auth="
		               + URLEncoder.encode(vo.getAuthor(), "UTF-8") + "&d_publ="
		               + URLEncoder.encode(vo.getCompany(), "UTF-8");
	         URL url = new URL(URL_STATICMAP);
	         HttpURLConnection con = (HttpURLConnection) url.openConnection();
	         con.setRequestMethod("GET");
	         con.setRequestProperty("X-Naver-Client-Id", "hdNtmVBv0Yltn2KGN06d");
	         con.setRequestProperty("X-Naver-Client-Secret", "mO_vaj8DYa");
	         int responseCode = con.getResponseCode();
	         BufferedReader br;
	         if (responseCode == 200) {
	            br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
	         } else {
	            br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
	         }
	         String inputLine;
	         StringBuffer response = new StringBuffer(); // 문자열 추가 변경시 사용
	         while ((inputLine = br.readLine()) != null) {
	            response.append(inputLine);
	         }
	         br.close();

	         Document doc = Jsoup.parse(response.toString());
	         // System.out.println(doc.toString());
	         Element isbn = doc.select("isbn").first();
	         vo.setIsbn(isbn.text());
	         System.out.println("isbn: " + isbn.text());
	         String imgDoc = doc.toString();
	         String imgTag = imgDoc.substring(imgDoc.indexOf("<img>") + 5); // <img>테그 5글자 뒤부터 가져옴
	         String imgURL = imgTag.substring(0, imgTag.indexOf("<author>")); // 처음부터 ?전까지 잘라서
	         // 가져옴(https://bookthumb-phinf.pstatic.net/cover/160/313/16031391.jpg)
	         System.out.println("imgURL : " + imgURL);
	         String fileName = imgURL.substring(imgURL.lastIndexOf("/") + 1);// 마지막 /부터 끝까지
	         System.out.println("fileName : " + fileName);
	         vo.setImgurl(imgURL);
	         System.out.println(vo);
	         fileName = fileName.trim();
	         // DownloadBroker
	         Runnable dl = new DownloadBroker(imgURL, fileName);
	         Thread t = new Thread(dl);
	         t.start();

	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      return vo;
	}//naver_search
	
	//액셀에 저장
	public void excel_save() {
		try {
			HSSFSheet sheet = wb.getSheetAt(0);
	        if (wb != null && sheet != null) {
	            Iterator rows = sheet.rowIterator();
	            rows.next();
	            int i = 0; // list의 index
	            while (rows.hasNext()) {
	               HSSFRow row = (HSSFRow) rows.next();
	               HSSFCell cell = row.createCell(3);
	               cell.setCellType(CellType.STRING);
	               cell.setCellValue(list.get(i).getIsbn());

	               cell = row.createCell(4);
	               cell.setCellType(CellType.STRING);
	               cell.setCellValue(list.get(i).getImgurl());

	               URL url = new URL(list.get(i).getImgurl());
	               InputStream inputStream = url.openStream();
	               byte[] bytes = IOUtils.toByteArray(inputStream);
	               int pictureIdx = wb.addPicture(bytes, Workbook.PICTURE_TYPE_JPEG);
	               inputStream.close();

	               CreationHelper helper = wb.getCreationHelper();
	               Drawing drawing = sheet.createDrawingPatriarch();
	               ClientAnchor anchor = helper.createClientAnchor();

	               anchor.setCol1(5);// Column B
	               anchor.setRow1(i + 1);// Row3
	               anchor.setCol2(6);// Column C
	               anchor.setRow2(i + 2);// Row4

	               Picture pict = drawing.createPicture(anchor, pictureIdx);
	               Cell cellImg = row.createCell(5);
	               int widthUnits = 20 * 256;
	               sheet.setColumnWidth(5, widthUnits);
	               short heightUnits = 120 * 20; // 1/20
	               cellImg.getRow().setHeight(heightUnits);
	               i++;

	            }
	            FileOutputStream fos = new FileOutputStream("isbn.xls");
	            wb.write(fos);
	            fos.close();
	            System.out.println("ISBN,ImageURL 저장성공");
	         }
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	   }//excel_save
}
