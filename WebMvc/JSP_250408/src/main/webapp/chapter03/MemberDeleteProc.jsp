<%@page import="model.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean class = "model.MemberDTO" id="mbean">
	<jsp:setProperty name = "mbean" property ="*"/>
</jsp:useBean>
<%
MemberDAO mdao = new MemberDAO();
String pass =mdao.getPass(mbean.getId());

// 내가 입력한 패스워드와 데이터베이스의 패스워드가 일치하는지 여부
if(mbean.getPass1().equals(pass)){
	   mdao.deleteMember(mbean.getId());//업데이트 완료
	   %>
	   <script type = "text/javascript">
	   		alert("삭제 완료")
	   		location.replace("MemberList.jsp");
	   </script>
	   <% 
	   //response.sendRedirect("MemberList.jsp");
}else{
	   %>
	   <script type="text/javascript">
	      alert("패스워드가 일치하지 않습니다.")
	      history.go(-1);
	   </script>
<%   
}
%>

<script>
alert("패스워드가 일치하지 않습니다")
history.go(-1);
</script>
</body>
</html>