<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri = "http://www.springframework.org/tags/form" %>
<c:set var='root' value="${pageContext.request.contextPath }/"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>미니 프로젝트</title>
<!-- Bootstrap CDN -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>

<script>
//사용자가 아이디란의 입력하면 무조건 false;(검사전)
function checkUserIdExist(){
	//변수선언 : 사용자가 입력한 id값 가져오기
    var user_id = $("#user_id").val()
    //입력값이 없을시 요청
    if(user_id.length == 0){
       alert('아이디를 입력해주세요')
       return
    }
    
    $.ajax({
       url : '${root}user/checkUserIdExist/' + user_id, //요청할 페이지의 주소
       type : 'get', //요청타입
       dataType : 'text', //문자열
       //성공시 호출할 함수
       success : function(result){
          if(result.trim() == 'true'){
             alert('사용할 수 있는 아이디입니다')
             $("#userIdExist").val('true')//유효성 체크
          } else {
             alert('사용할 수 없는 아이디 입니다')
             $("#userIdExist").val('false')
          }
       }
    })
}
function resetUserIdExist(){
$("#userIdExist").val('false')
}

</script>

</head>
<body>

<c:import url ="/WEB-INF/views/include/top_menu.jsp"/>

<div class="container" style="margin-top:100px">
	<div class="row">
		<div class="col-sm-3"></div>
		<div class="col-sm-6">
			<div class="card shadow">
				<div class="card-body">
					<form:form action="${root}user/join_pro" method="post" modelAttribute="joinUserBean">
						<form:hidden path="userIdExist" />
						<div class="form-group">
							<form:label path="user_name">이름</form:label>
							<form:input path="user_name" class="form-control"/>
							<form:errors path="user_name" style = 'color:red'/>
						</div>
						<div class="form-group">
							<form:label path="user_id">아이디</form:label>
							<div class="input-group">
								<form:input path="user_id" class="form-control"  onkeypress="resetUserIdExist()"/>
								<div class="input-group-append">
									<button type="button" class="btn btn-primary" onclick = 'checkUserIdExist()'>중복확인</button>
								</div>
							</div>
							<form:errors path="user_id" style = 'color:red'/>
						</div>
						<div class="form-group">
							<form:label path="user_pw">비밀번호</form:label>
							<form:password path="user_pw" class="form-control"/>
							<form:errors path="user_pw" style = 'color:red'/>
						</div>
						<div class="form-group">
							<form:label path="user_pw2">비밀번호 확인</form:label>
							<form:password path="user_pw2" class="form-control"/>
							<form:errors path="user_pw2" style = 'color:red'/>
						</div>
						<div class="form-group">
							<div class="text-right">
								<form:button type="submit" class="btn btn-primary">회원가입</form:button>
							</div>
						</div>
					</form:form>
				</div>
			</div>
		</div>
		<div class="col-sm-3"></div>
	</div>
</div>

<c:import url="/WEB-INF/views/include/bottom_Info.jsp"/>

</body>
</html>








