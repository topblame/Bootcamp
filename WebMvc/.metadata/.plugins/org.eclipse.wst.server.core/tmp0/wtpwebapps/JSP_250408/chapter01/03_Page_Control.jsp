<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Forward_SendRedirect</title>
</head>
<body>
	<h2>Forward_SendRedirect</h2>
	<hr />
	<form action="forward_action.jsp" method = "post">
		forward_action: <input type="text" name=username> 
		<input type="submit" value="Requst">
	</form>
	<p/>
	<hr />
	<p/>
	<form action="response_sendRedirect.jsp" method = "post">
		response_sendRedirect: <input type="text" name=username> <input
			type="submit" value="Response">
	</form>
</body>
</html>