<%@page import="jspbook.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MemberJoinProc</title>
<link rel="stylesheet" type="text/css" href="../css/twitter.css">
</head>
<body>
<center>
	<h2>Member Info</h2>
	<%
	request.setCharacterEncoding("UTF-8");
	
	%>
	<!-- MemberDTO mDTO = new MemberDTO(); -->
	<jsp:useBean class = "jspbook.MemberDTO" id = "mdto" >
		<jsp:setProperty name = "mdto" property="*"/>
	</jsp:useBean>
	<h2>
	ID:
	<jsp:getProperty name = "mdto" property="id"/>
	</h2>
	<h2>
	EMAIL:
	<jsp:getProperty name = "mdto" property="email"/>
	</h2>
	<h2>
	Phone:
	<jsp:getProperty name = "mdto" property="tel"/>
	</h2>
	<h2>
	Address:
	<jsp:getProperty name = "mdto" property="address"/>
	</h2>
	
</center>
</body>
</html>