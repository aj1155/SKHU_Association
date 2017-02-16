<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


		<!-- Main -->
		<div id="main">
			<div class="inner">

				<!-- Header -->
				<header id="header">
					<a href="index.html" class="logo"><strong>커뮤니티</strong></a>
				</header>
				<br />
				<h4>공지사항</h4>
				
				<button>
					<a href="create">글쓰기</a>
				</button>
				<form:form modelAttribute="pagination">
				<div class="form-inline" style="float: right;">
					<form:select path="st">
						<form:option value="0" label="검색조건" />
						<form:option value="1" label="제목" />
						<form:option value="2" label="작성자" />
					</form:select> 
					<form:input path="ss" />
					<button type="submit" class="btn btn-small btn-primary">검색</button>
				</div>
				<div class="table-wrapper">
					<table>
						<thead>
							<tr>
								<th><input type="checkbox">
									<label></label>
								</th>
								<th>제목</th>
								<th>작성자</th>
								<th>작성일</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="list" items="${ list.boardPostList }" varStatus="status">
								<tr data-url="read?id=${list.id}">
									<td><input type="checkbox">
										<label></label>
									</td>
									<td>${ list.title }</td>
									<td>${ list.content }</td>
									<td>${ list.writer_name }</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
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
				</div>
		</div>
		
	</div>
