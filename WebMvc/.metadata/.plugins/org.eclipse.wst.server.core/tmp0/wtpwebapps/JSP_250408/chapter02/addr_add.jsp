<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>주소록 등록</title>
<link rel="stylesheet" type="text/css" href="../css/addrlist.css">
</head>
<body>
<%
request.setCharacterEncoding("UTF-8");
%>
<!-- AddrDTO의 addr  -->
<jsp:useBean class = "jspbook.AddrDTO" id = "addr">
	<jsp:setProperty name = "addr" property="*"/>
</jsp:useBean>
<!--  AddrDAO의 am -->
<jsp:useBean class = "jspbook.AddrDAO" id = "am" scope = "application"/>
<%am.add(addr); %>
<div class ="container">
	<h2>등록 완료.</h2>
	<p>이름: <jsp:getProperty name="addr" property="username"/></p>
	<p>전화번호: <jsp:getProperty name="addr" property="tel"/></p>
	<p>이메일: <jsp:getProperty name="addr" property="email"/></p>
	<p>성별: <jsp:getProperty name="addr" property="gender"/></p>
	<hr />
	<a href="addr_list.jsp">주소 목록 보기</a>
</div>
</body>
</html>