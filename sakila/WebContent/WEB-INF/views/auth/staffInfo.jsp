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
	<div class="row">
		<div class="col-3"style="background-color:#e9e9e9; width:100%; min-height: 960px;">
			<jsp:include page="/inc/menu.jsp"></jsp:include>
		</div>
		<div class="col-9">
			<div>
				<h1>관리자 정보</h1>
				
			</div>
			<div>
				<hr style="border: solid 1px; color: #a9a9a9;">
			</div>
		</div>
	</div>
	<table>
		<tr>
			<td>
			 	별명:
			</td>
		</tr>
		<tr>
			<td>
				이름:
			</td>
		</tr>
		<tr>
			<td>
				연락처:
			</td>
		</tr>
		<tr>
			<td>
				주소:
			</td>
		</tr>
		<tr>
			<td>
			E-mail:
			</td>
		</tr>
	</table>
</div>
</body>
</html>