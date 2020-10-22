<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<!-- 부트 스트랩 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<!-- 아이콘 사용 -->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css">
</head>
<body>
<div class="container">
	<h1>Index</h1>
	<div>
		<span><!--${loginStaff.email}-->
		</span>관리자님
	</div>
	<div>
		<a href="${pageContext.request.contextPath}/auth/logoutServlet"class="btn btn-primary">로그아웃</a>
	</div>

</div>
</body>
</html>