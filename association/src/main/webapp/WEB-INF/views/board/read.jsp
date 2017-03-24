<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>
<!-- Main -->
<div id="main">
	<div class="inner">

		<!-- Header -->
		<header id="header">
			<h2>게시글</h2>
		</header>
		<input type="hidden" name="boardId" value="${boardId}"/>
		<table>
			<tr>
				<td style="width:100px;">제목:</td>
				<td colspan="3" style="text-align:left;">${boardPost.title}</td>
			</tr>
			<tr>
				<td>작성자:</td>
				<td style="width:400px;">${boardPost.userName }</td>
				<td style="width:80px;">작성일</td>
				<td><joda:format value="${boardPost.modifiedTime}" style="SM"/></td>
			</tr>
			<tr>
				<td>파일:</td>
				<td colspan="3">
				<c:forEach var = "f" items="${fileList.files}">
					<a href="download?id=${f.id }">${f.name }</a><br/>
				</c:forEach>
			</tr>
			<tr>
				<td colspan="4"style="height:300px;">${boardPost.content }</td>
			</tr>
		</table>
		<div>
			댓글:
			<textarea id="comment"></textarea><button id = "commentSubmit">댓글달기</button>
			<input type="hidden" name="boardPostId" value="${boardPost.id}"/>
		</div>
		<div id="commentList">
			<table>
			<c:forEach var="comment" items="${ comment.list }">
				<tr>
					<td colspan="2">작성자:${comment.writer_name}</td>
				</tr>
				<tr>
					<td>댓글:${comment.content}</td>
					<td><p id="commentDelete" name="${comment.id}" class="btn btn-primary" style="float:right;" value="${comment.id}">삭제</p></td>
				</tr>
			</c:forEach>
			</table>
		</div>
		<div style="float:right;">
			<a href="edit?id=${boardPost.id }&boardId=${boardId}" class="button special">수정하기</a>
			<button class="button"><a href="list?${ pagination.queryString }&boardId=${boardId}">목록으로</a></button>
			<button type="button special"><a href="delete?id=${boardPost.id }">삭제</a></button>
		</div>
	</div>
  </div>
<script src="/resources/js/comment.js"></script>