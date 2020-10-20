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
</head>
<body>
	<h1>로그인 폼</h1>
	<div>
		오늘 접속자 수 : ${todayStats.count}명
	</div>
	<div>
		총 접속자 수 : ${totalCnt}명
	</div>
	<form>
		<div>
			<input type="text" placeholder="ID">
		</div>
		<div>
			<input type="password" placeholder="PW">
		</div>
		<div>
			<button type="button">Log-In</button>
		</div>
	</form>
</body>
</html>