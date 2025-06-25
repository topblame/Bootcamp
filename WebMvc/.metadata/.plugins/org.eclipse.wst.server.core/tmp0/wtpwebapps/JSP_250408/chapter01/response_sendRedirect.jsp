<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>response_sendRedirect</title>
</head>
<body>
<h2>response_sendRedirect.jsp</h2>
<%request.setCharacterEncoding("UTF-8"); %>
<%response.sendRedirect("page_control_end.jsp"); %>
<center>
      <h2>Reponse 로그인</h2>
      <form action="ResponseProc.jsp" method="post">
         <table align="center" width="300" border="1">
            <tr height="40">
               <td width="120" align="center">아이디</td>
               <td width="180" align="center">
               <input type="text" name=id>
               </td>
            </tr>
            <tr height="40">
               <td width="120" align="center">패스워드</td>
               <td width="180" align="center">
               <input type="password" name=pass></td>
            </tr>
            <tr>
               <td align="center" colspan="2">
               <input type="submit" value="로그인"></td>
            </tr>
         </table>
      </form>
   </center>
</body>
</html>