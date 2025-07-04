package board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BoardUpdateProcCon
 */
@WebServlet("/BoardUpdateProcCon.do")
public class BoardUpdateProcCon extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        reqPro(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        reqPro(request, response);
    }

    protected void reqPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
       request.setCharacterEncoding("UTF-8");
       
       //FRONT
       String subject = request.getParameter("subject");
       String password = request.getParameter("password");
       String content = request.getParameter("content");
       int num =Integer.parseInt(request.getParameter("num"));
       String pass = request.getParameter("pass");
       
       // String rawPassword = request.getParameter("password");
       // String encryptPassword  = PasswordUtil.encrypt(rawPassword);
       
       // JAVA (BACK)
       if(pass.equals(password)) {
    	   BoardDAO bdao = new BoardDAO();
    	   bdao.UpdateBoard(num, subject, content); //update board set subject = ?, content = ? where num = ?
    	   
    	   //출력
   		   RequestDispatcher dis = request.getRequestDispatcher("BoardListCon.do");
   		   dis.forward(request, response); //jsp
       }else {
    	   request.setAttribute("msg", "0");
    	   
    	 //출력
   		   RequestDispatcher dis = request.getRequestDispatcher("BoardListCon.do");
   		   dis.forward(request, response); //jsp
       }
       
       //---------------MODEL-------------------
       
       
    }
}
