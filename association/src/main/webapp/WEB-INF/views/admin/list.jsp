<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!-- Main -->
<div id="main">
	<div class="inner">

		<!-- Header -->
		<header id="header">
			<h2>관리자목록</h2>
		</header>
		<section style="padding-top:50px;">
		<div align="right">
			<ul class="actions">
				<li><a href="create" class="button special icon fa-plus">관리자 추가</a></li>
			</ul>
		</div>
		<div class="table-wrapper">
			<table>
				<thead>
					<tr>
						<th>카테고리</th>
						<th>아이디</th>
						<th>이름</th>
						<th>이메일</th>
						<th>핸드폰번호</th>						
					</tr>
				</thead>
				<tbody>
					<c:forEach var="admin" items="${ list.admin }" >
						<tr data-url="edit?id=${ admin.id }">
							<td>${ admin.category.name }</td>
							<td>${ admin.loginId }</td>
							<td>${ admin.name }</td>
							<td>${ admin.email }</td>
							<td>${ admin.phoneNumber }</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</div>
		
			</section>
	</div>
</div>



