<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var='root' value='${pageContext.request.contextPath }/' />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>미니 프로젝트</title>
<!-- Bootstrap CDN -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>

<style>
/* 슬라이드바 스타일 */
#searchSidebar {
	height: 100%;
	width: 0;
	position: fixed;
	z-index: 1;
	top: 0;
	right: 0;
	background-color: #f4f4f4;
	overflow-x: hidden;
	transition: 0.5s;
	padding-top: 160px;
}

#searchSidebar .closebtn {
	position: absolute;
	top: 20px;
	right: 25px;
	font-size: 36px;
	margin-top: 120px;
}

#searchSidebar form {
	padding: 15px;
}

#searchSidebar h4 {
	text-align: center;
	margin-bottom: 20px;
}

#searchSidebar ul {
	list-style-type: none;
	padding: 0;
}

#searchSidebar ul li {
	margin-bottom: 15px;
}
/* 검색 버튼 스타일 */
#searchButton {
	position: fixed;
	top: 70px; /* 기존 20px에서 수정 */
	right: 20px; /* 기존 위치 유지 */
	z-index: 2;
	background-color: #007bff; /* 버튼 색상 (파란색) */
	color: white;
	border: none;
	padding: 10px 15px;
	border-radius: 5px;
	font-size: 16px;
	box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
}

#searchButton:hover {
	background-color: #0056b3; /* hover 효과 */
	cursor: pointer;
}
</style>
<script>
	// 슬라이드바 열기
	function openSearch() {
		document.getElementById("searchSidebar").style.width = "300px";
	}
	// 슬라이드바 닫기
	function closeSearch() {
		document.getElementById("searchSidebar").style.width = "0";
	}
</script>
</head>
<body>

	<c:import url="/WEB-INF/views/include/top_menu.jsp" />
	<!-- 검색 버튼 -->
	<button id="searchButton" class="btn btn-primary"
		onclick="openSearch()">검색</button>

	<!-- 검색 슬라이드바 -->
	<div id="searchSidebar">
		<a href="javascript:void(0)" class="closebtn" onclick="closeSearch()">&times;</a>

		<h4>게시글 검색</h4>
		<form action="${root}board/search" method="get">
			<input type="text" name="keyword" class="form-control"
				placeholder="검색어를 입력하세요" required>
			<button type="submit" class="btn btn-primary btn-block mt-2">검색</button>
		</form>

	</div>

	<!-- 게시판 미리보기 부분 -->
	<div class="container" style="margin-top: 100px">
		<div class="row">
			<c:forEach var='sub_list' items="${list }" varStatus="idx">
				<div class="col-lg-6" style="margin-top: 20px">
					<div class="card shadow">
						<div class="card-body">
							<h4 class="card-title">${board_list[idx.index].board_info_name }</h4>
							<table class="table table-hover" id='board_list'>
								<thead>
									<tr>
										<th class="text-center w-25">글번호</th>
										<th>제목</th>
										<th class="text-center w-25 d-none d-xl-table-cell">작성날짜</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var='obj' items="${sub_list }">
										<tr>
											<td class="text-center">${obj.content_idx }</td>
											<th><a
												href='${root}board/read?board_info_idx=${board_list[idx.index].board_info_idx}&content_idx=${obj.content_idx}&page=1'>${obj.content_subject }</a></th>
											<td class="text-center d-none d-xl-table-cell">${obj.content_date }</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
							<a
								href="${root }board/main?board_info_idx=${board_list[idx.index].board_info_idx}"
								class="btn btn-primary">더보기</a>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>

	<c:import url="/WEB-INF/views/include/bottom_Info.jsp" />

</body>
</html>









