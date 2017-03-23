<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!-- Main -->
<div id="main">
	<div class="inner">
		<!-- Header -->
		<header id="header">
			<h2>광고등록</h2>
		</header>
		<section style="padding-top:10px;">
		
			<form method="post" enctype="multipart/form-data">
				<div class="table-wrapper">
					<table>
						<tr>
							<td>광고분류</td>
							<td>
								<select name="categoryId" style="width: 800px;">
									<c:forEach var="category" items="${ category }">
										<option value="${ category.id }">${ category.name }</option>
									</c:forEach>
								</select>
							</td>
						</tr>
						<tr>
							<td>회사명</td>
							<td><input type="text" name="company" style="width: 800px;" /></td>
						</tr>
						<tr>
							<td>광고문구</td>
							<td><input type="text" name="slogan" style="width: 800px;" /></td>
						</tr>
						<tr>
							<td>광고자</td>
							<td><input type="text" name="userName" style="width: 800px;" /></td>
						</tr>
						<tr>
							<td>휴대폰번호</td>
							<td><input type="text" name="phoneNumber" style="width: 800px; float:left;" />
							<div align="right">
								<ul class="actions">
									<li><a href="#addMember" class="button special icon fa-plus" data-toggle="modal">회원 검색</a></li>
								</ul>
							</div>
							</td>
						</tr>
						<tr>
							<td>파일추가</td>
							<td><input type="file" name="image" /></td>
						</tr>
						<tr>
							<td>내용</td>
							<td>
								<textarea id="body" name="content" class="smarteditor2" style="width: 800px; min-height: 100px;"></textarea>
							</td>
						</tr>
						<tr>
							<td>광고기간</td>
							<td><input type="date" name="startDate" />~<input type="date" name="endDate" /></td>
						</tr>
					</table>
				</div>
					
				<div class="form-group">
						<ul class="actions">
							<li><button type="submit" class="button special">저장</button></li>
							<li><a href="list" class="button">취소</a></li>
						</ul>
				</div>
				<%@ include file="/WEB-INF/views/commons/userAjax.jsp" %>
			</form>	

	</section>
	</div>
</div>
