package jspbook;

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

//ServletContextListener: 프로젝트 시작(초기화)과 종료.
@WebListener
public class InitialMember implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext context = sce.getServletContext(); //서버 메모리 공간확보
		ArrayList<Member> datas = new ArrayList<Member>();
	
		for(int i =0; i<8; i++) {
			Member data = new Member("김자바" + i, "soldesk" + i+ "@sol.com");
			
			datas.add(data);
		}
		
		context.setAttribute("members", datas);
	}
	
	
	//소멸
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	}
	
	
	
	
}
//서블릿(Servlet): 웹브라우저 요청(request)을 하면 그에 맞는 결과를 가져오는데 결과를 java 코드로 만들어서 보내주는것.
//응답은 동적(실시간으로 변화하는 내용생성)으로 이루어짐.
