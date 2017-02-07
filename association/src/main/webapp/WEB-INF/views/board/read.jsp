<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판1</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/main.css" />
<link href="http://maxcdn.bootstrapcdn.com/bootstrap/2.3.2/css/bootstrap.min.css" rel="stylesheet" media="screen">
<style>
ul.pagination li>.page {
	color: blue;
}

ul.pagination li>.page.active {
	background-color: #BEEFFF;
	color: blue !important;
}

ul.pagination li>.page.active:hover {
	background-color: #00FFFF;
}

ul.pagination li>.page.active:active {
	background-color: C0FFFF;
}
</style>
</head>
<body>
	<div id="wrapper">

		<!-- Main -->
		<div id="main">
			<div class="inner">

				<!-- Header -->
				<header id="header">
					<a href="index.html" class="logo"><strong>커뮤니티</strong></a>
				</header>
				<br />
				<h4>읽기</h4>
				<br/>
				
				<table>
					<tr>
						<td style="width:80px;">제목:</td>
						<td colspan="3" style="text-align:left;">읽기view</td>
					</tr>
					<tr>
						<td>작성자:</td>
						<td style="width:500px;">${boardPost.title }</td>
						<td style="width:80px;">작성일</td>
						<td>${boardPost.modifiedTime }</td>
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
				<div style="float:right;">
					<button class="btn btn-primary">
						<i class="icon-ok icon-white"><a href="edit?id=${boardPost.id }"> 수정하기</a></i>
					</button>
					<button class="btn"><a href="list?${ pagination.queryString }">목록으로</a></button>
					<button type="submit"><a href="delete?id=${boardPost.id }">삭제</a></button>
				</div>
			</div>
		</div>
		<c:import url="../commons/sidebar.jsp" />
	</div>
		<!-- Scripts -->
		<c:import url="../commons/script.jsp"/>
</body>
</html>