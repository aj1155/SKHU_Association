<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>excel Upload</title>
</head>
<body>
	<form method="POST" enctype="multipart/form-data">
		<input type="file" name="excelFile"/>
		<button type="submit">제출</button>
	</form>
	
	<form method="POST" action="userExcelInsert">
		<c:forEach var="list" items="${excelList }" varStatus="status">
			<span>소속:</span><input type="text" name="categoryName" value="${list.categoryName }"/><br/>
			<span>기수:</span><input type="text" name="grade" value="${list.grade }"/><br/>
			<span>이름:</span><input type="text" name="name" value="${list.name }"/><br/>
			<span>직책:</span><input type="text" name="positionName" value="${list.positionName }"/><br/>
			<span>휴대전화번호:</span><input type="text" name="phoneNumber" value="${list.phoneNumber }"/><br/>
			<span>회사전화버호:</span><input type="text" name="companyNumber" value="${list.companyNumber }"/><br/>
			<span>생년월일:</span><input type="text" name="birth" value="${list.birth }"/><br/>
			<span>이메일:</span><input type="text" name="email" value="${list.email }"/><br/>
			<span>사회적지위:</span><input type="text" name="status" value="${list.status }"/><br/>
		</c:forEach>
		<button type="submit">회원 등록</button>
	</form>
</body>
</html>