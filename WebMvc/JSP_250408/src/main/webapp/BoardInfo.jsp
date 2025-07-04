<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link
   href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
   rel="stylesheet">
<link rel="stylesheet" type="text/css" href="./css/board.css">
<script
   src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<title>BoardInfo</title>
</head>
<body>
<center>
	<h2>게시 글보기</h2>
	<table class ="table table-striped table-bordered table-hover" width="600">
		<tbody>
			<tr height="40">
				<th width="120" align = "center">글번호</th>
				<th width="180" align = "left">${bean.num}</th>
				<th width="120" align = "center">조회수</th>
				<th width="180" align = "left">${bean.readcount}</th>
			</tr>
			
			<tr height="40">
				<th width="120" align = "center">작성자</th>
				<td width="180" align = "left">${bean.writer}</td>
				<th width="120" align = "center">작성일</th>
				<td width="180" align = "left">${bean.reg_date}</td>
			</tr>
			
			<tr height="40">
				<th width="120" align = "center">이메일</th>
				<td width="180" align = "left" colspan = "3">${bean.email}</td>
			</tr>
			
			<tr height="40">
				<th width="120" align = "center">제목</th>
				<td width="180" align = "left" colspan = "3">${bean.subject}</td>
			</tr>
			
			<tr height="40">
				<th width="120" align = "center">글 내용</th>
				<td width="180" align = "left" colspan = "3">${bean.content}</td>
			</tr>
			
			<tr height="40">
				<th align="center" colspan="4">
				<input type = "button" value = "답글달기" onclick="location.href='BoardRewriteCon.do?num=${bean.num}&ref=${bean.ref}&re_step=${bean.re_step}&re_level=${bean.re_level}'"/> &nbsp;
				<input type = "button" value = "글수정" onclick="location.href='BoardUpdateCon.do?num=${bean.num}'"/> &nbsp;
				<input type = "button" value = "글삭제" onclick="location.href='BoardDeleteCon.do?num=${bean.num}'"/> &nbsp;
				<input type = "button" value = "목록보기" onclick="location.href='BoardListCon.do'"/>
				
				</th>
			</tr>
		</tbody>
	</table>
</center>

</body>
</html>