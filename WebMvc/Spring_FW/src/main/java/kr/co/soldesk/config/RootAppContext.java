package kr.co.soldesk.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import kr.co.soldesk.beans.UserBean;

@Configuration //프로젝트에 관련된 설정을 하는 클래스 /컴포넌트 처리가되어있음.
public class RootAppContext implements WebMvcConfigurer{
	
	@Bean("loginUserBean")
	@SessionScope
	public UserBean loginUserBean() {
		return new UserBean();
		//세션영역에서 쓸려고 만듬.
	}
}
