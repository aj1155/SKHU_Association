<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
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
						<h3>광고 등록</h3>
					</div>
					<form name="uploadFIle" method="POST" enctype="multipart/form-data">
						<div style="display: inline-block;">
							<div class="select-wrapper">
								<span>광고분류:</span> <select name="categoryId">
									<c:forEach var="category" items="${category }">
										<option value="${category.id }">${category.name }</option>
									</c:forEach>
								</select>
							</div>

							<span>회사명:</span> 
							<input type="text" name="company" style="width: 800px;" /> 
							<span>광고문구:</span> <input type="text" name="slogan" style="width: 800px;" /> 
							<span>광고자:</span> 
							<input type="text" name="userName" style="width: 800px;" /> 
							<span>휴대폰 번호:</span>
							<input type="text" name="phoneNumber" style="width: 800px;" />
							<div align="right">
								<ul class="actions">
									<li><a href="#addMember" class="button special icon fa-plus" data-toggle="modal">임원추가</a></li>
								</ul>
							</div>
							<input type="file" name="image"/>
						</div>
						<br />
						<textarea id="body" name="content" class="smarteditor2" style="width: 800px; min-height: 100px;"></textarea>
						<br /> 
						<span>광고기간:<input type="date" name="startDate" />~<input type="date" name="endDate" /></span> <br /> <br />
						<button class="button special">저장</button>
						<a href="#" class="button">취소</a>
						<c:import url="../commons/userAjax.jsp"/>
					</form>
					</div>
			</div>
		</div>
		<c:import url="../commons/sidebar.jsp" />
		<!-- Scripts -->
		<c:import url="../commons/script.jsp" />
	</div>
	
	<!-- <script>
		$(document).ready(function(){
			$.ajax({
				url : "searchUser",
				method : "GET",
				success: function(response){
					$("#addUser").html(response);
				}
			})
		})
	</script>
	 -->
</body>
</html>