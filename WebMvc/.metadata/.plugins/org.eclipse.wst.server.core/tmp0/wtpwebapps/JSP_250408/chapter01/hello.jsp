<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%> <!-- 맨위에 엑박은 서버가 안들어온거. -->
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
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