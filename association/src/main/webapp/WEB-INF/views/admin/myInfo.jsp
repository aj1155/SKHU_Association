<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div id="main">
	<div class="inner">
	<header id="header">
		<h2>내 정보 수정</h2>
	</header>
<section style="padding-top:50px;">

<form:form class="form-horizontal form-label-left" method="post" modelAttribute="adminDto">
	<div class="table-wrapper">
		<table>
			<tr>
				<td>로그인아이디</td>
				<td><form:input path="loginId"  /></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><form:input type="password" path="passwdEdit" /></td>
			</tr>
			<tr>
				<td>비밀번호확인</td>
				<td><form:input type="password" path="passwdCheck" /></td>
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
				<li><a href="#" class="button">취소</a></li>
			</ul>
		</div>
	</div>

</form:form>
</section>
</div>
</div>
