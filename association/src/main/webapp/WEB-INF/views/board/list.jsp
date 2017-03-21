<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>
<!-- Main -->
<div id="main">
	<div class="inner">

	<!-- Header -->
	<header id="header">
		<h2>게시판</h2>
	</header>
	<section style="padding-top:50px;">
		<form:form modelAttribute="pagination">
			<div align="right">
				<ul class="actions">
					<li><button type="submit" class="button">삭제</button></li>
					<li><a href="/board/create?boardId=${boardId}" class="button special">글쓰기</a></li>
				</ul>
			</div>
			
			<div class="form-group">		
				<form:select path="st" style="width:200px;">
					<form:option value="0" label="검색조건" />
					<form:option value="1" label="제목" />
					<form:option value="2" label="작성자" />
				</form:select>
				<form:input path="ss" style="width:300px;"/>
				<button type="submit" class="button" >검색</button>
			</div>
		
		
		<div class="row">
			<div class="table-wrapper" style="width:100%;">
				<table>
					<thead>
						<tr>
							<th><input type="checkbox" /></th>
							<th>제목</th>
							<th>작성자</th>
							<th>작성일</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="list" items="${ list.boardPostList }" varStatus="status">
							<tr data-url="/board/read?id=${list.id}">
								<td><input type="checkbox" /></td>
								<td>${ list.title }</td>
								<td>${ list.writer_name }</td>
								<td><joda:format value="${ list.lastModifiedDate }" style="SM"/></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
		
				<input type="hidden" name="cp" value="1" />
				<div class="text-center">
					<ul class="pagination">
						<c:forEach var="p" items="${ pagination.pageIndexList }">
							<li class='${ p.cssClass }'>
								<a data-page="${ p.number }" href="#">${ p.label }</a>
							</li>
						</c:forEach>
					</ul>
				</div>
				
			</div>
		</div>
		</form:form>
		</section>
	</div>
</div>
		

