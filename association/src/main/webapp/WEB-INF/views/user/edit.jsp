<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<script>
function getThumbnailPrivew(html, $target) {
  if (html.files && html.files[0]) {
    var reader = new FileReader();
    reader.onload = function (e) {
      $target.css('display', '');
      //$target.css('background-image', 'url(\"' + e.target.result + '\")'); // 배경으로 지정시
      $target.html('<img src="' + e.target.result + '" border="0" alt="" />');
    }
    reader.readAsDataURL(html.files[0]);
    $("img[id=profileImg]").hide();
  }
}
</script>
<style>
input{ width:250px; }
img{
  	width:100%;
  	height:100%;
  	border-radius: 100%;
}
.profileImg{
	display:inline-block; 
	float:left; 
	width:400px; 
	margin-right:10%;
}
</style>
<div id="main">

<div class="inner">
<header id="header">
	<h2>${ param.id == null ? "동문 추가" : "정보 변경" }</h2>
</header>
<section style="padding-top:50px;">

<div class="form-group">

	<div class="profileImg">
		<c:if test="${ param.id != null }">
		<form name="form" id="form" action="profile" method="post" enctype="multipart/form-data" >
	        	<div class="filebox" style="margin-left : 0%;">
			        <label for="cma_file" >프로필 사진 편집</label>
			        <input type="hidden" name="id" value="${ param.id }" />
			        <input type="file" name="cma_file" id="cma_file" accept="image/*" onchange="getThumbnailPrivew(this,$('#cma_image'))"/>
			        <br /><br />
			        <c:if test="${ imgPath == null }">
			        	<img src="/resources/upload/profileImg/user.png" class="img-circle profile_img" id="profileImg" style="width:70%; max-width:70%;">
			        </c:if>
			        <c:if test="${ imgPath != null }">
			        	<img src="${ imgPath }" class="img-circle profile_img" id="profileImg" >
			        </c:if>
			        <div id="cma_image" style="width:70%; max-width:70%;"></div>
			          
		        </div>
		        <br />
		        <br />
		        <button type="submit" class="button special">프로필 사진 저장</button>
		</form> 
		</c:if>
	</div>

	<div class="profileInfo" >
	<form:form class="form-horizontal form-label-left" method="post" modelAttribute="userDto">
	
		<div class="table-wrapper">
		<table>
			<tr>
				<td>이름</td>
				<td><form:input path="name"  /></td>
			</tr>
			<tr>
				<td>기수</td>
				<td><form:input path="grade"  /></td>
			</tr>
			<tr>
				<td>생년월일</td>
				<td><form:input path="birth"  /></td>
			</tr>
			<tr>
				<td>소속지위</td>
				<td><form:input path="status"  /></td>
			</tr>	
			<tr>
				<td>핸드폰번호</td>
				<td><form:input path="phoneNumber"  /></td>
			</tr>
			<tr>
				<td>직장전화</td>
				<td><form:input path="companyNumber"  /></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><form:input path="email"  /></td>
			</tr>
			
			<tr>
				<td>카테고리</td>
				<td>
					<form:select path="user_type" style="width:200px;">
						<form:option value="0" label="일반회원/임원" />
						<form:options itemValue="id" itemLabel="name" items="${ position }" />
					</form:select>	
				</td>
			</tr>
		</table>
		</div>
		
		<div class="form-group" style="float:right;">
			<ul class="actions">
				<li><button type="submit" class="button special" name="cmd" value="save">저장</button></li>
				<li><a href="list" class="button">취소</a></li>
				<c:if test="${ param.id != null }">
					<li><button type="submit" class="button" name="cmd" value="delete">삭제</button></li>
				</c:if>
			</ul>
		</div>
			
	</form:form>
	</div>
	
</div>
</section>
</div>
</div>
