<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<style>
img{
  width:100%; 
  max-width:50px;
  height:100%;
  max-height:70px;
}
</style>
<!-- Main -->
<div id="main">
	<div class="inner">

	<!-- Header -->
	<header id="header">
		<h2>동문관리</h2>
	</header>
	<section style="padding-top:50px;">
		<form:form modelAttribute="pagination">
		<div align="right">
			<ul class="actions">
				<li><button type="submit" name="cmd" value="delete" class="button">삭제</button></li>
				<li><a href="create" class="button special icon fa-plus">동문 추가</a></li>
				<li><a href="createByExcel" class="button special icon fa-plus">동문목록 엑셀</a></li>
			</ul>
		</div>

		<div class="form-group">
			<form:select path="st" style="width:200px;">					
				<form:option value="0" label="검색조건" />
				<form:option value="1" label="이름" />
				<form:option value="2" label="기수" />
			</form:select> 
			<form:input path="ss" style="width:200px;"/>
			<form:select path="ut" style="width:200px;">
				<form:option value="0" label="일반회원/임원" />
				<form:options itemValue="id" itemLabel="name" items="${ position }" />
			</form:select>				
			<button type="submit" class="button special">검색</button>
			<a href="list" class="button">취소</a>
		</div>
		<div class="table-wrapper">
			<table>
				<thead>
					<tr>
						<th><input type="checkbox" /></th>
						<th>기수</th>
						<th>이미지</th>
						<th>이름</th>
						<th>생년월일</th>
						<th>핸드폰번호</th>
						<th>이메일</th>
						<th>소속지위</th>
						<th>직장전화번호</th>
						<th>일반회원/임원</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="user" items="${ list.user }" >
						<tr data-url="/user/edit?id=${ user.id }">
							<td><input type="checkbox" name="del" value="${ user.id }" /></td>
							<td>${ user.grade }기</td>
							<td>
								<c:if test="${ user.image == null }">
        							<img src="/resources/upload/profileImg/user.png" class="img-circle profile_img" id="profileImg" >
        						</c:if>
   								<c:if test="${ user.image != null }">
   									<img src="${ user.image }" class="img-circle profile_img" id="profileImg" >
   								</c:if>
        							</td>
							<td>${ user.name }</td>
							<td>${ user.birth }</td>
							<td>${ user.phoneNumber }</td>
							<td>${ user.email }</td>
							<td>${ user.status }</td>
							<td>${ user.companyNumber }</td>
							<td>${ user.position.name }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>	
		<a href="#" class="button special" style="float:right;">엑셀다운로드</a>
		<input type="hidden" name="cp" value="1" />

		<div align="center">
		<div class="pagination">
			<nav aria-label="Page navigation">
				<ul class="pagination">
					<c:forEach var="p" items="${ pagination.pageIndexList }">
						<li class='${ p.cssClass }'><a data-page="${ p.number }" href="#">${ p.label }</a></li>
					</c:forEach>
				</ul>
			</nav>
		</div>
		</div>

		</form:form>
			
		</section>
	</div>
</div>
