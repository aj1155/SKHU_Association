<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div id="main">
	<div class="inner">
<h2>개인정보 변경</h2>
<hr />
<form:form class="form-horizontal form-label-left" method="post" modelAttribute="userDto">

	<div class="form-group">
		<label class="control-label col-md-3 col-sm-3 col-xs-12">이름 </label>
		<div class="col-md-4 col-sm-9 col-xs-12">
			<form:input path="name" class="form-control" />
		</div>
	</div>

	<div class="form-group">
		<label class="control-label col-md-3 col-sm-3 col-xs-12">기수 </label>
		<div class="col-md-4 col-sm-9 col-xs-12">
			<form:input path="grade" class="form-control" />
		</div>
	</div>

	<div class="form-group">
		<label class="control-label col-md-3 col-sm-3 col-xs-12">생년월일</label>
		<div class="col-md-4 col-sm-9 col-xs-12">
			<form:input path="birth" name="social_status" class="form-control" />
		</div>
	</div>

	<div class="form-group">
		<label class="control-label col-md-3 col-sm-3 col-xs-12">소속지위</label>
		<div class="col-md-4 col-sm-9 col-xs-12">
			<form:input path="status" class="form-control" />
		</div>
	</div>

	<div class="form-group">
		<label class="control-label col-md-3 col-sm-3 col-xs-12">휴대전화</label>
		<div class="col-md-4 col-sm-9 col-xs-12">
			<form:input path="phoneNumber" class="form-control" />		
	</div>
</div>

<div class="form-group">
	<label class="control-label col-md-3 col-sm-3 col-xs-12">직장전화</label>
	<div class="col-md-4 col-sm-9 col-xs-12">
		<form:input path="companyNumber" class="form-control" />
	</div>
</div>

<div class="form-group">
	<label class="control-label col-md-3 col-sm-3 col-xs-12">e-mail</label>
	<div class="col-md-4 col-sm-9 col-xs-12">
		<form:input path="email" class="form-control" />
		</div>
	</div>
	
	
	<div class="form-group">
	<label class="control-label col-md-3 col-sm-3 col-xs-12">일반회원 / 임원</label>
	<div class="col-md-4 col-sm-9 col-xs-12">
		<form:select path="user_type" itemValue="id" itemLabel="name" items="${ position }" />		
		</div>
	</div>

<hr />
	<div class="form-group">
		<div class="col-md-9 col-sm-9 col-xs-12 col-md-offset-3">
			<ul class="actions">
				<li><button type="submit" class="button special">추가</button></li>
				<li><a href="list" class="button">취소</a></li>
			</ul>
		</div>
	</div>
</form:form>
</div>
</div>