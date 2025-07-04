<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>BoardReWriteForm</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" type="text/css" href="./css/board.css">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</head>
<body>
	<center>
		<h2>답글 쓰기</h2>
		<c:if test="${not empty error }">
			<div class="alert alert-danger" style="color: red; font-weight: bold;">
				${error}
			</div>
		</c:if>
		<form action="BoardReWriteProcCon.do" method="post">
			<table class="table table-striped table-bordered table-hover">
				<tbody>
					<tr height="40">
						<th width="200" align="center">작성자</th>
						<td width="400">
						 	<input type="text" name="writer" size="30" style="border: none; background: transparent"/>
						</td>
					</tr>
					
					<tr height="40">
						<th width="200" align="center">제목</th>
						<td width="400">
						 	<input type="text" name="subject" size="60" value="re:" style="border: none; background: transparent"/>
						</td>
					</tr>
					
					<tr height="40">
						<th width="200" align="center">이메일</th>
						<td width="400">
							<input type="email" name="email" size="60" style="border: none; background: transparent">
						</td>
					</tr>
					
					<tr height="40">
						<th width="200" align="center">패스워드</th>
						<td width="400">
							<input type="password" name="password" size="60" style="border: none; background: transparent">
						</td>
					</tr>
					
					<tr height="40">
						<th width="200" align="center">글내용</th>
						<td width="400">
							<textarea rows="10" cols="50" name="content" style="border: none; background: transparent">
							</textarea>
						</td>
					</tr>
					
					<tr height="40">
						<th colspan="2" align="center">
							<input type="hidden" name="ref" value="${ref}"> 
							<input type="hidden" name="re_step" value="${re_step}"> 
							<input type="hidden" name="re_level" value="${re_level}"> 
							<input type="submit" value="댓글작성">&nbsp;&nbsp;
							<input type="reset" value="취소">&nbsp;&nbsp;
							<input type="button" value="목록보기" onclick="location.href='boardList.jsp'"/> 
						</th>
					</tr>
				</tbody>
			</table>
		</form>
	</center>
</body>
</html>