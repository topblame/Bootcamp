<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>delete_tweet.jsp</title>
</head>
<body>
<%
//삭제할 트윗의 인덱스를 가져오기

int index = Integer.parseInt(request.getParameter("index"));
// 트윗 리스트
ArrayList<String> msgs = (ArrayList<String>)application.getAttribute("msgs");

//인덱스가 유효하면 삭제.
if(msgs != null && index >= 0 && index < msgs.size()){
	msgs.remove(index);
}

//tweet list로 이동
response.sendRedirect("twitter_list.jsp");
%>

</body>
</html>