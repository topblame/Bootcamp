<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>page_control_end</title>
</head>
<body>
	<div align="center">
		<h2>forward action 및 sendredirect 결과</h2>
		<hr />
		지금 보여지는 화면은 page_control_end.jsp에서 출력되는 결과
		<hr />
		이름: <%=request.getParameter("username")%> <br>
		전화번호: <%=request.getParameter("phone") %>
	</div>
</body>
</html>