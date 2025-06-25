<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SessionLoginProc.jsp</title>
</head>
<body>
<%
request.setCharacterEncoding("UTF-8");
//request 영역에서 받음 .

String id = request.getParameter("id");

//session영역에 저장 
session.setAttribute("id", id);

//세션 유지시간
session.setMaxInactiveInterval(5);
%>

<h2><%=id %>님 환영합니다.</h2>
<a href = "SessionShopping.jsp">solshopping</a>
</body>
</html>