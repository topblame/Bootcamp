<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ELTEST</title>
</head>
<body>
<h3> 스크립트 테크 </h3>
<%
int i = 3;
out.println("i = "+i);
request.setAttribute("j", 3);
request.setAttribute("k", "5");
%>
<hr />
<h3>스크립트 태그 표현식</h3>
i = <%=i %> <br/>
i = <%=i>4 %> <br/>
i = <%=i + "4" %> <br/>
<hr />
<h3>EL 태그 표현식(Expression Language)</h3>
1. i=${i} <br/>
2. j=${j} <br/> <!-- 서버에 있는 데이터로 수행됨  -->
3. k=${k>j} <br/> <!-- String이여도 연산가능 (연산자 우선수행) -->
4. res=${k+7} <br/>
</body>
</html>