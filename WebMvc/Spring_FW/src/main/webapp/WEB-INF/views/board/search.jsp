<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var='root' value="${pageContext.request.contextPath }/"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>검색 결과</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
</head>
<body>

<div class="container" style="margin-top:100px">
    <h2>검색 결과</h2>
    <p>"${keyword}"에 대한 검색 결과</p>
    
    <c:if test="${not empty searchResults}">
        <table class="table table-hover">
            <thead>
                <tr>
                    <th>번호</th>
                    <th>제목</th>
                    <th>작성자</th>
                    <th>작성 날짜</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="result" items="${searchResults}">
                    <tr>
                        <td>${result.content_idx}</td>
                        <td><a href="${root}board/read?board_info_idx=${result.content_board_idx}&content_idx=${result.content_idx}">${result.content_subject}</a></td>
                        <td>${result.content_writer_name}</td>
                        <td>${result.content_date}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>
    
    <c:if test="${empty searchResults}">
        <p>검색 결과가 없습니다.</p>
    </c:if>
</div>

</body>
</html>
