<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>forward_action</title>
</head>
<body>
	<h2>forward_action.jsp</h2>
	<%
	request.setCharacterEncoding("UTF-8");
	%>

	<jsp:forward page="page_control_end.jsp">
		<jsp:param name="phone" value="010-1234-5678" />
	</jsp:forward>
</body>
</html>