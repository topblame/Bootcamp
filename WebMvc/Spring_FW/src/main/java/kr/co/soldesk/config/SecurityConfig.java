package kr.co.soldesk.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/", "/user/login", "/user/login_pro", "/user/join").permitAll()
				.anyRequest().authenticated().and().csrf(); // CSRF 방지 활성화
	}
	/*
	 * - CSRF 방지(Cross Site Requst Forgrey): 사용자의 요청과는 무관하게 공격자가 불필요한 요청을 숨겨놓고 요청을
	 * 보내는 것 <input type="hidden" name="csrf" value="랜던토큰">
	 * 
	 * - SQL Injection 방지: 사용자가 입력한 값 또는 이벤트한 값을 통해서 진입하여 SQL을 조작하여 공격(? #{..})
	 * 
	 * - XSS 방지(Cross Site Scripting): 악성 스크립트 언어를 삽입하여 공격 <script> alert </script>
	 * : &lt; < > &gt; &nbsp; -> 에 공격
	 * 
	 * - HTTPS
	 * 브루트 포스 공격 방지 - 로그인 실패 횟수제한
	 */
}
