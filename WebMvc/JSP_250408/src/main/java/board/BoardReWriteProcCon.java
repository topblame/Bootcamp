package board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BoardReWriteProcCon
 */
@WebServlet("/BoardReWriteProcCon.do")
public class BoardReWriteProcCon extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		reqProc(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		reqProc(request, response);
	}

	protected void reqProc(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		// 작성자, 제목, 이메일, 패스워드, 내용
		String writer = request.getParameter("writer");
		String subject = request.getParameter("subject");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String content = request.getParameter("content");
		// 예외처리
		if (writer == null || writer.trim().isEmpty() || subject == null || subject.trim().isEmpty() || email == null
				|| email.trim().isEmpty() || password == null || password.trim().isEmpty() || content == null
				|| content.trim().isEmpty()) {
			//필수 입력값이 누락된 경우 처리
			request.setAttribute("error", "필수 입력 항목이 비어있습니다.");
			RequestDispatcher dis = request.getRequestDispatcher("BoardReWriteForm.jsp");
			dis.forward(request, response); // jsp
			return;
		}
		// ref, re_step, re_level
		int ref = Integer.parseInt(request.getParameter("ref"));
		int re_step = Integer.parseInt(request.getParameter("re_step"));
		int re_level = Integer.parseInt(request.getParameter("re_level"));
		// DTO에 저장
		BoardDTO bean = new BoardDTO();
		bean.setWriter(writer);
		bean.setSubject(subject);
		bean.setEmail(email);
		bean.setPassword(password);
		bean.setContent(content);
		
		bean.setRef(ref);
		bean.setRe_step(re_step); // 답글
		bean.setRe_level(re_level);// 계층레벨로 하나씩 증가
		// 데이터로 메서드 구현 reInsertBoard())

		BoardDAO bdao = new BoardDAO();
		bdao.reInsertBoard(bean);
		// 답글 작성후 목록으로 이동
		RequestDispatcher dis = request.getRequestDispatcher("BoardListCon.do");
		dis.forward(request, response); // jsp
	}
}
