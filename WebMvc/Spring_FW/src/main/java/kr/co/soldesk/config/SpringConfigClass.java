package kr.co.soldesk.config;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

// 최상단 SpringConfigClass -> WebApplicationInitializer-> servletAppContext
public class SpringConfigClass implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {

		//frontend 환경설정
		AnnotationConfigWebApplicationContext servletAppContext = new AnnotationConfigWebApplicationContext();
		servletAppContext.register(ServletAppContext.class);

		// 요청 발생 시 요청을 처리하는 서블릿을 DispatcherServlet으로 설정해준다.
		DispatcherServlet dispatcherServlet = new DispatcherServlet(servletAppContext);
		// 매개변수로 선언된 servletContext객체를 이용하여 servlet 추가 load-on
		ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", dispatcherServlet);

		servlet.setLoadOnStartup(1);// 가장먼저 받아들이겠다는 뜻
		servlet.addMapping("/");

		// ============================================
		// BackEnd 환경설정
		// Bean을 정의하는 클래스를 지정한다
		AnnotationConfigWebApplicationContext rootAppContext = new AnnotationConfigWebApplicationContext();
		rootAppContext.register(RootAppContext.class);
		// (web.xml에서 <listener>구현부와 같음)
		ContextLoaderListener listener = new ContextLoaderListener(rootAppContext);
		servletContext.addListener(listener);
		// (web.xml에서 <filter>구현부와 같음)
		// 파라미터 인코딩 설정
		FilterRegistration.Dynamic filter = servletContext.addFilter("encodingFilter", CharacterEncodingFilter.class);
		filter.setInitParameter("encoding", "UTF-8");
		// dispatcher에 의해서 추가된 Servlet에 UTF-8로 encoding하겠다는 구현부
		filter.addMappingForServletNames(null, false, "dispatcher");

	}

}
