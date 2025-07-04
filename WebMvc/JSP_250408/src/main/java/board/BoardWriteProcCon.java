package board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BoardWriteProcCon
 */
@WebServlet("/BoardWriteProcCon.do")
public class BoardWriteProcCon extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		reqPro(req, resp);
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		reqPro(req, resp);
	}
	
	protected void reqPro(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		//---------FRONT--------------
		String writer = req.getParameter("writer");
		String subject = req.getParameter("subject");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String content = req.getParameter("content");
		//---------------JAVA (BACK)----------
		BoardDTO bean = new BoardDTO();
		bean.setWriter(writer);
		bean.setSubject(subject);
		bean.setEmail(email);
		bean.setPassword(password);
		bean.setContent(content);
		
		//---------------MODEL-------------------
		BoardDAO bdao = new BoardDAO();
		bdao.insertBoard(bean); 
		
		//출력
		RequestDispatcher dis = req.getRequestDispatcher("BoardListCon.do");
		dis.forward(req, resp); //jsp
	}
}
