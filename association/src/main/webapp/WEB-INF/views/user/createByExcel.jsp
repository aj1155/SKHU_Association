<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<style>
img{
  width:100%; 
  max-width:70px;
  height:100%;
  max-height:70px;
}
</style>
<!-- Main -->
<div id="main">
	<div class="inner">
	<!-- Header -->
	<header id="header">
		<h2>동문추가 - 엑셀등록</h2>
	</header>
	<section style="padding-top:50px;">
		<div align="right">
			<form method="POST" enctype="multipart/form-data">
				<input type="file" name="excelFile" style="display:inline; margin-bottom:20px;"/>
				<button type="submit">엑셀읽기</button>
			</form>
		</div>
		<form:form id="excelInsert" method="POST" action="/user/userExcelInsert" modelAttribute="userForm">
		<table>
			<thead>
				<tr>
					<td onclick='event.cancelBubble=true;'><input type="checkbox" id="all" name="all" onClick="allCkeck(this)"/><label for="all"></label></td>
					<td>기수</td>
					<td>이미지</td>
					<td>핸드폰번호</td>
					<td>이름</td>
					<td>생년월일</td>
					<td>직장전화</td>
					<td>직책</td>
					<td>이메일</td>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="list" items="${excelList.list}" varStatus="status">
				<tr>
					<td onclick='event.cancelBubble=true;'><input type="checkbox" value="${status.count}" name="values"/><label for="${status.index}"></label></td>
					<td><input type="text" name="list[${status.index}].grade" value="${list.grade}" /></td>
					<td>
						<c:set var="image" value="${list.image}"/>
						<c:choose>
						<c:when test="${empty image}">
						<img src="/resources/upload/profileImg/user.png" class="img-circle profile_img" id="profileImg" name="image"/></td>
						</c:when>
						<c:when test="${!empty image}">
							<img src="${list.image}" class="img-circle profile_img" id="profileImg" name="list[${status.index}].image" value="${list.image}"/></td>
							<input type="hidden" name="list[${status.index}].image" value="${list.image}"/>
						</c:when>
					</c:choose>
					<td><input type="text" name="list[${status.index}].phoneNumber" value="${list.phoneNumber}" /></td>
					<td><input type="text" name="list[${status.index}].name" value="${list.name}" /></td>
					<td><input type="text" name="list[${status.index}].birth" value="${list.birth}" /></td>
					<td><input type="text" name="list[${status.index}].companyNumber" value="${list.companyNumber}"/></td>
					<td><input type="text" name="list[${status.index}].status" value="${list.status}" /></td>
					<td><input type="email" name="list[${status.index}].email" value="${list.email}" /></td>
				</tr>
			</c:forEach>
			<button class="button special" onclick="excelInsert()">동문추가</button>
			</tbody>
		</table>
		</form:form>
	</section>
	</div>
</div>
<script>
    $(function(){
        $("#allCheck").click(function(){
            if($("#allCheck").prop("checked")) {
                $("input[type=checkbox]").prop("checked",true);
            } else {
                $("input[type=checkbox]").prop("checked",false);
            }
        })
    })

    function excelInsert(){
        $("#userForm").submit();
	}
</script>