<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>광고</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/main.css" />
<link href="http://maxcdn.bootstrapcdn.com/bootstrap/2.3.2/css/bootstrap.min.css" rel="stylesheet" media="screen">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="${pageContext.request.contextPath }/resources/editor/js/HuskyEZCreator.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/editor/init.js" type="text/javascript"></script>
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

				<div>
					<div class="title_left">
						<h3>광고 선택</h3>
					</div>
					<form method="GET" action="list">
						<button type="submit" name="categoryId" value="1">금융보험</button>
						<button type="submit" name="categoryId" value="2">요식업</button>
						<button type="submit" name="categoryId" value="3">컨설팅</button>
						<button type="submit" name="categoryId" value="4">서비스</button>
						<button type="submit" name="categoryId" value="5">출판인쇄</button>
						<button type="submit" name="categoryId" value="6">임대업</button>
						<button type="submit" name="categoryId" value="7">IT</button>
						<button type="submit" name="categoryId" value="8">전문직</button>
						<button type="submit" name="categoryId" value="9">자동차</button>
						<button type="submit" name="categoryId" value="10">일반제조</button>
						<button type="submit" name="categoryId" value="11">기타</button>
					</form>

				</div>
			</div>
		</div>
		<c:import url="../commons/sidebar.jsp" />
		</div>
		<!-- Scripts -->
		<c:import url="../commons/script.jsp"/>
</body>
</html>