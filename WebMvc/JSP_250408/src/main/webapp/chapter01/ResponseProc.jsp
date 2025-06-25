<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
//오라클에 저장된 데이터로 가설
String dbid = "soldesk";
String dbpass = "12345";


String id = request.getParameter("id"); 
String pass = request.getParameter("pass"); 
if (dbid.equals(id) && dbpass.equals(pass)){ 
	session.setAttribute("id", id); //session
	session.setAttribute("pass", pass);
	response.sendRedirect("ResponseLogin.jsp");
}
else{
	%> 
	<script>
	alert("아이디와 비밀번호가 틀립니다.")
	history.go(-1);
	</script>	
<% 
	//response.sendRedirect("04_login.jsp");
}
%>

지금 문장은 출력될까?
</body>
</html>