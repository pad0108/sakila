<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div style="padding-left: 10px; padding-right: 10px;">
	<div style="margin: auto; text-align:center;">	
		<h2>
			<a style="color: black;" href="${pageContext.request.contextPath}/auth/IndexServlet">Sakila Movie</a>
		</h2>
	</div>
	
	<br>
	
	<div style="margin: auto;">
	<a style="color: black;" href="${pageContext.request.contextPath}/auth/StaffInfoServlet">
			<table style="width: 100%; margin:auto; text-align: right;">
				<tr>
					<td rowspan="2" style="text-align: left;">
						<i class='far fa-user-circle' style='font-size:50px'></i>
					</td>
					<td>
						<span>${loginStaff.storeId}</span>지점
					</td>
				</tr>
				<tr>
					<td>
						<span>${loginStaff.userName}</span>관리자님
					</td>
				</tr>
			</table>
		</a>
		<div style="width: 100%; text-align:center; margin-top:30px; margin-bottom:120px;">
			<a href="${pageContext.request.contextPath}/auth/logoutServlet"class="btn btn-dark" style="width: 100%;">Log-Out</a>
		</div>
		<div style="text-align:left;">
			<h4>Menu</h4>
		</div>
		<table style="width: 100%; margin:auto; text-align: left;">
		<tr>
			<td><a style="color: black;" href="#">홈</a></td>
		</tr>
		<tr>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td><a style="color: black;" href="#">영화반납</a></td>
		</tr>
		<tr>
			<td><hr></td>
		</tr>
		<tr>
			<td><a style="color: black;" href="#">회원목록 관리</a></td>
		</tr>
		<tr>
			<td><a style="color: black;" href="#">영화목록 관리</a></td>
		</tr>
		<tr>
			<td><a style="color: black;" href="#">영화재고 관리</a></td>
		</tr>
		<tr>
			<td><a style="color: black;" href="#">영화배우 관리</a></td>
		</tr>
		<tr>
			<td><hr></td>
		</tr>
		<tr>
			<td><a style="color: black;" href="#">매장 통계</a></td>
		</tr>
		<tr>
			<td><a style="color: black;" href="#">MVP</a></td>
		</tr>
		</table>
	</div>
</div>