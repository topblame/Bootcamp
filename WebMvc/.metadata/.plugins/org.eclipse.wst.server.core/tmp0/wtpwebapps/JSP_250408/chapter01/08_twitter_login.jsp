<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>twitter</title>
<link rel = "stylesheet" type = "text/css" href = "../css/twitter.css">
</head>
<body>
	<div align="center">
      <h2>로그인</h2>
      <form method="POST" action="twitter_list.jsp">
         <label>아이디:</label> 
         <input type="text" name="id" placeholder="아이디를 입력하세요" required /> <br>
         <br> <input type="submit" value="로그인" />
      </form>
   </div>
</body>
</html>