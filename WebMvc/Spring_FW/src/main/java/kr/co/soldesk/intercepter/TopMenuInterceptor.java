package kr.co.soldesk.intercepter;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import kr.co.soldesk.beans.BoardInfoBean;
import kr.co.soldesk.beans.UserBean;
import kr.co.soldesk.service.TopMenuService;

public class TopMenuInterceptor implements HandlerInterceptor{
	//interceptor에서는 autowired가 안되므로 생성자를 통해서 주입(@Autowired)
	private TopMenuService topMenuService;
	private UserBean loginUserBean;
	
	public TopMenuInterceptor(TopMenuService topMenuService, UserBean loginUserBean) {
		this.topMenuService = topMenuService;
		this.loginUserBean = loginUserBean;
	}
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		List<BoardInfoBean> topMenuList=topMenuService.getTopMenuList();
		//topMenuService.getTopMenuList(); 메서드가 실행 되기전의 수행문
		request.setAttribute("topMenuList", topMenuList);
		request.setAttribute("loginUserBean", loginUserBean);
		
		return true;
	}
	
	
}
