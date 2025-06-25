<%@ page language = "java" contentType = "text/html; charset = UTF-8" pageEncoding = "UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>getdata</title>
</head>
<body>
    <%
    request.setCharacterEncoding("UTF-8");
    request.getParameter("name");
    request.getParameter("major");
    
    out.println("이름: "+ strName + "<br>");
    out.println("전공: "+ strMajor);
    
    %>
</body>
</html>