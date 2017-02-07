<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/main.css" />
<link href="http://maxcdn.bootstrapcdn.com/bootstrap/2.3.2/css/bootstrap.min.css" rel="stylesheet" media="screen">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="${pageContext.request.contextPath }/resources/editor/js/HuskyEZCreator.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/editor/init.js" type="text/javascript"></script>
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
<script>
$(function() {
    $("button#addFile").click(function() {
        var tag = "<span>파일:</span> <input type='file' name='file' multiple /><br/>";
        $(tag).appendTo("div#files");
    });
});
</script>

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
				<h4>글쓰기</h4>
				<br/>
				<form name="uploadFIle" method="POST" enctype="multipart/form-data">
					<input type="hidden" name="userId" value="1"/>
					<input type="hidden" name="userName" value="test"/>
					<div style="display:inline-block;">
						<span>제목:</span> <input type="text" name="title" />
					</div>
					<div id="files">
						<span>첨부 파일:</span> <input type="file" name="file"/>
						<button type="button" class="btn" id="addFile">
            				<i class="icon-plus"></i> 파일추가
        				</button>
					</div>
					<textarea id="body" name="content" class="smarteditor2" style="width:900px;min-height:300px;"></textarea>
					<button type="submit">저장</button>
				</form>
			</div>
		</div>
		<c:import url="../commons/sidebar.jsp" />
	</div>
	<!-- Scripts -->
		<c:import url="../commons/script.jsp"/>
</body>
</html>