<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!-- Main -->
		<div id="main">
			<div class="inner">

				<!-- Header -->
				<header id="header">
					<a href="index.html" class="logo"><strong>동문관리</strong></a>
				</header>
				<section>
				<form:form modelAttribute="pagination">
				<div align="right">
					<ul class="actions">
						<li><a href="#" class="button">삭제</a></li>
						<li><a href="create" class="button special icon fa-plus">동문 추가</a></li>
						<li><a href="create" class="button special icon fa-plus">동문목록 엑셀</a></li>
					</ul>
				</div>

				<div class="form-inline">
					<form:select path="st">
						<form:option value="0" label="검색조건" />
						<form:option value="1" label="이름" />
						<form:option value="2" label="기수" />
						<form:option value="3" label="임원" />
					</form:select> 
					<form:input path="ss" />
					<button type="submit" class="btn btn-small btn-primary">검색</button>
				</div>
				<div class="table-wrapper">
					<table>
						<thead>
							<tr>
								<th>CHECK</th>
								<th>기수</th>
								<th>이미지</th>
								<th>이름</th>
								<th>생년월일</th>
								<th>핸드폰번호</th>
								<th>이메일</th>
								<th>소속지위</th>
								<th>직장전화번호</th>
								<th>일반회원/임원</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="user" items="${ list.user }" >
								<tr data-url="edit?id=${user.id}">
									<td><input type="checkbox" name="demo-user" /></td>
									<td>${ user.grade } 기</td>
									<td>이미지</td>
									<td>${ user.name }</td>
									<td>${ user.birth }</td>
									<td>${ user.phoneNumber }</td>
									<td>${ user.email }</td>
									<td>${ user.status }</td>
									<td>${ user.companyNumber }</td>
									<td>${ user.position.name }</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<input type="hidden" name="cp" value="1" />
				<div class="pagination pagination-small pagination-centered">
					<ul>
						<c:forEach var="p" items="${ pagination.pageIndexList }">
							<li class='${ p.cssClass }'>
								<a data-page="${ p.number }" href="#">${ p.label }</a>
							</li>
						</c:forEach>
					</ul>
				</div>
			</form:form>
					</section>
			</div>
	</div>



