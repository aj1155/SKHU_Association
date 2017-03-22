<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!-- Main -->
<div id="main">
	<div class="inner">

		<!-- Header -->
		<header id="header">
			<h2>광고수정</h2>
		</header>
		<section style="padding-top:10px;">
			<form:form method="post" modelAttribute="advertiseDto" enctype="multipart/form-data">
								<div class="table-wrapper">
					<table>
						<tr>
							<td>광고분류</td>
							<td>
								<form:select path="categoryId" style="width: 800px;">
									<form:options itemValue="id" itemLabel="name" items="${ category }" />
								</form:select>
							</td>
						</tr>
						<tr>
							<td>회사명</td>
							<td><form:input path="company" style="width: 800px;" /></td>
						</tr>
						<tr>
							<td>광고문구</td>
							<td><form:input path="slogan" style="width: 800px;" /></td>
						</tr>
						<tr>
							<td>광고자</td>
							<td><form:input path="userName" style="width: 800px;" /></td>
						</tr>
						<tr>
							<td>휴대폰번호</td>
							<td><form:input path="phoneNumber" style="width: 800px; float:left;" /></td>
						</tr>
						<tr>
							<td>파일변경</td>
							<td><input type="file" name="image" /></td>
						</tr>
						<tr>
							<td>내용</td>
							<td>
								<form:textarea id="body" path="content" name="content" class="smarteditor2" style="width: 800px; min-height: 100px;"></form:textarea>
							</td>
						</tr>
						<tr>
							<td>광고기간</td>
							<td><form:input type="date" path="startDate" />~<form:input type="date" path="endDate" /></td>
						</tr>
					</table>
				</div>
					
				<div class="form-group">
						<ul class="actions">
							<li><button type="submit" class="button special">저장</button></li>
							<li><a href="list" class="button">취소</a></li>
						</ul>
				</div>
				
			</form:form>	
		</section>
	</div>
</div>
