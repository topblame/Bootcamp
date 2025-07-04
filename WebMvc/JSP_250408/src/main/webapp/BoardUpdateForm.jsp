<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<title>BoardUpdateForm</title>
</head>
<body>
	<center>게시글 수정하기 </center>
	<form action="BoardUpdateProcCon.do" method = "post">
		<table width="600"
            class="table table-striped table-bordered table-hover">
            <tr height = "40">
            	<td width="150" align="center">작성자</td>
            	<td width="150" align="center">${bean.writer }</td>
            	<td width="150" align="center">작성일</td>
            	<td width="150" align="center">${bean.reg_date }</td>
            </tr>
            
            <tr height = "40">
            	<td width="150" align="center">제목</td>
            	<td width="150" colspan = "3">
				<input type="text" name= "subject" value = "${bean.subject }" size = "60"
				style="border: none; background: transparent" />
				</td>
            </tr>
            
            <tr height = "40">
            	<td width="150" align="center">패스워드</td>
            	<td width="150" colspan = "3">
				<input type="password" name= "password" size = "60"
				style="border: none; background: transparent" />
				</td>
            </tr>
            
            <tr height = "40">
            	<td width="150" align="center">글 내용</td>
            	<td width="450" colspan = "3">&nbsp;
				<textarea rows ="10" cols = "60" name = "content" align = "left">
				${bean.content }
				</textarea>
				</td>
            </tr>
            
            <tr height = "40">
            	<td width="150" align="center"> 
            	<input type="hidden" name = "num" value = "${bean.num }" />
            	<input type="hidden" name = "pass" value = "${bean.password }" />
            	<input type="submit" value = "수정하기"/> &nbsp;&nbsp;
            	<input type="reset" value = "취소"/> &nbsp;&nbsp;
            	<input type="button" value = "전체글보기" onclick="location.href = 'BoardListCon.do'"/> ;            	
				</td>
            </tr>
            
        </table>
	</form>
</body>
</html>