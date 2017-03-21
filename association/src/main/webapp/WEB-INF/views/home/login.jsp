<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/WEB-INF/views/commons/header.jsp" %>
</head>
<style>
body{
	background-image:url("/resources/img/bg.jpg");
}
img{
	display:block;
	margin:auto;
	width:40%;
	height:300px; 
	width:300px;
}
.middle{
	position:absolute;
	top:20%;
	left:40%;
	margin:0 auto;
}
div.middle, form{
	background-color:#FFFFFF;
}
div.middle{
	margin:auto; 
	padding-top:20px; 
	height:650px; 
	width:450px; 
	border-radius:20px;
}
input{
	width:380px;
}
input[type=submit]{
	width:400px;
}
</style>
<body>
	<div class="middle" align="center">
		<img src='/resources/img/skhu_logo.png' >
		<form action="/loginProcessing" method="post">
			<br />
			<label>아이디</label>
			<input type="text"  name="loginId" placeholder="아이디를 입력해주세요" required="required" style="width:380px;"/>
			<label>비밀번호</label>
			<input type="password"  name="passwd" placeholder="비밀번호를 입력해주세요" required="required" style="width:380px;"/>
			<br />
			<br />	
			<input type="submit" value="로그인" style="width:380px;"/>
		</form>
	</div>	
</body>
</html>