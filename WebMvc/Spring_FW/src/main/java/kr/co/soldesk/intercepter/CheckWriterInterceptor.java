package kr.co.soldesk.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import kr.co.soldesk.beans.ContentBean;
import kr.co.soldesk.beans.UserBean;
import kr.co.soldesk.service.BoardService;

public class CheckWriterInterceptor implements HandlerInterceptor{
	private UserBean loginUserBean;
	private BoardService boardService;
	//생성자를 이용해서 구현
	public CheckWriterInterceptor(UserBean loginUserBean, BoardService boardService) {
		this.loginUserBean = loginUserBean;
		this.boardService = boardService;
	}
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		//read.jsp에서 주입된 content_idx
		String str1 = request.getParameter("content_idx");
		int content_idx = Integer.parseInt(str1);
		
		ContentBean currentContentBean = boardService.getContentInfo(content_idx);
		
		
		//작성한 사람의 글번호와 로그인한 사람의 글번호가 다름.
		if(currentContentBean.getContent_writer_idx() != loginUserBean.getUser_idx()) {
	         //경로를 읽어와서
	         String contextPath = request.getContextPath();
	         //not_writer 호출
	         response.sendRedirect(contextPath + "/board/not_writer");
	         return false;
	      }
		
		return true;
		
	}
	
	
	
	
}
