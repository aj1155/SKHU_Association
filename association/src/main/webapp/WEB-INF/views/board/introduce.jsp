<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>인문학습원 소개</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/assets/css/main.css" />
<link
	href="http://maxcdn.bootstrapcdn.com/bootstrap/2.3.2/css/bootstrap.min.css"
	rel="stylesheet" media="screen">
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
				<h4>소개글</h4>
				<br/>
				
				<textarea style="width:900px;height:400px;">
				사진이나 글 관리자 마음대로 배치
				</textarea>
				<div style="float:right">
					<button class="btn btn-primary">
						저장
					</button>
					<button>
						수정
					</button>
					<button>
						삭제
					</button>
				</div>
			</div>
		</div>
		<c:import url="../commons/sidebar.jsp" />
	</div>
		<!-- Scripts -->
		<script
			src="${pageContext.request.contextPath}/resources/assets/js/jquery.min.js"></script>
		<script
			src="${pageContext.request.contextPath}/resources/assets/js/skel.min.js"></script>
		<script
			src="${pageContext.request.contextPath}/resources/assets/js/util.js"></script>
		<script
			src="${pageContext.request.contextPath}/resources/assets/js/main.js"></script>
</body>
</html>