package chapter09;

public class HttpServletMain_03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		method(new LoginService());
		method(new FileDownloadService());
	}
	public static void method(HttpServlet http) {
		http.service();
	}
}
