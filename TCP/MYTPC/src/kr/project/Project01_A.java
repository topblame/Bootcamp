package kr.project;



import java.util.List;
import java.util.ArrayList;

import com.google.gson.Gson;

import kr.soldesk.BookDTO;



public class Project01_A {
    public static void main(String[] args) {
        BookDTO dto = new BookDTO("JAVA", 21000, "에이콘", 680);

        Gson g = new Gson();
        String json = g.toJson(dto); //BOOKDTO의 데이터(객체)를 json으로 변환

        System.out.println(json);

        System.out.println("------------Object(BookDTO) -> JSON(String)--------------");
        System.out.println(json);

        System.out.println("------------JSON(String) - >Object(BookDTO) --------------");
        // JSON(String) -> Object(BookDTO)
        BookDTO dto1 = g.fromJson(json, BookDTO.class);
        System.out.println(dto1);
        System.out.println("도서제목 : " + dto.getTitle() +", 가격 : "+dto.getPrice());
        //Object(List<BookDTO>) -> JSON(String) : [ {...}, {...}, {...} ]
        List<BookDTO> lst = new ArrayList<BookDTO>();
        lst.add(new BookDTO("JSP", 28000, "솔데스크", 720));
        lst.add(new BookDTO("JPA", 32000, "솔데스크", 680));
        lst.add(new BookDTO("Spring", 54000, "솔데스크", 900));
        System.out.println("------------------Object(List(BookDTO)) - > JSON(String)---------");
        String lst_json = g.toJson(lst);
    }
}
