<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div id="main">
	<div class="inner">
<h2>${ param.id == null ? "관리자 추가" : "관리자 정보 수정" }</h2>
<hr />

<form:form class="form-horizontal form-label-left" method="post" modelAttribute="adminDto">
<div class="table-wrapper">
<table>
	<tr>
		<td>로그인아이디</td>
		<td><form:input path="loginId"  /></td>
	</tr>
	<tr>
		<td>이름</td>
		<td><form:input path="name"  /></td>
	</tr>
	<tr>
		<td>생년월일</td>
		<td><form:input path="birth"  /></td>
	</tr>
	<tr>
		<td>이메일</td>
		<td><form:input path="email"  /></td>
	</tr>
	<tr>
		<td>핸드폰번호</td>
		<td><form:input path="phoneNumber"  /></td>
	</tr>
	<tr>
		<td>카테고리</td>
		<td><form:select path="categoryId" itemValue="id" itemLabel="name" items="${ category }" /></td>
	</tr>
</table>
</div>

	
<hr />
	<div class="form-group">
		<div class="col-md-9 col-sm-9 col-xs-12 col-md-offset-3">
			<ul class="actions">
				<li><button type="submit" class="button special">저장</button></li>
				<li><a href="list" class="button">취소</a></li>
				<c:if test='${ param.id != null }'>
					<li><a href="delete?id=${ param.id }" class="button special">삭제</a></li>
				</c:if>
			</ul>
		</div>
	</div>
</form:form>
</div>
</div>