<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--jQuery-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 구글 CDN -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!-- JQuery -->
<script>
	$(document).ready(function() {	
		$("#btn").click(function() {	
			if ($("#id").val().length < 1) {
				alert("아이디를 입력해주세요");
				return;
			} 
			else if ($("#pw").val() < 1) {
				alert("비밀번호를 입력해주세요");
				return;
			}
			$("#loginForm").submit();
		});	
	});
</script>
<!-- 부트 스트랩 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<!-- 아이콘 사용 -->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css">
</head>
<body>
<div class="container">
	<h1>로그인 폼</h1>
	<form method="post" action="${pageContext.request.contextPath}/LoginServlet" id="loginForm">
	<table class="table" style="margin: auto; text-align: center; width: 50%;">
			<tr>
				<td>
					<i class='far fa-user-circle' style='font-size:100px; text-align:center'></i>
				</td>
			</tr>
			<tr>
				<td width="50%">
					<input type="text" placeholder="id" class="form-control"id="id"name="id" onClick="this.value='chkc90@naver.com'">
				</td>
			</tr>
			<tr>
				<td  width="50%">
					<input type="password" placeholder="pw" class="form-control" id="pw"name="pw" onClick="this.value='1234'">
				</td>
			</tr>
			<tr>
				<td  width="50%">
					<button type="button" class="btn btn-primary btn-block" id="btn">Log-in</button>
				</td>
			</tr>
	</table>
	<table class = "table" style="margin: auto; text-align: center; width: 50%";>
		<tr>
			<td>
				<div>
					Today : ${todayStats.count}명
				</div>
				<div>
					Total : ${totalCnt}명
				</div>
			</td>
		</tr>
	</table>
	</form>
</div>
</body>
</html>