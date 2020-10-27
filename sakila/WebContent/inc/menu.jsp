<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div style="padding-left: 10px; padding-right: 10px;">
	<div style="margin: auto; text-align:center;">
		<h2>Sakila Movie</h2>
	</div>
	
	<br>
	
	<div style="margin: auto;">
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
		<div style="width: 100%; text-align:center; margin-top:30px; margin-bottom:120px;">
			<a href="${pageContext.request.contextPath}/auth/logoutServlet"class="btn btn-dark" style="width: 100%;">Log-Out</a>
		</div>
		<div style="text-align:left;">
			<h4>Menu</h4>
		</div>
	</div>
</div>