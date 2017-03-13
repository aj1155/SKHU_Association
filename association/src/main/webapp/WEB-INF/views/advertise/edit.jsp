<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

		<!-- Main -->
		<div id="main">
			<div class="inner">

				<!-- Header -->
				<header id="header">
					<a href="index.html" class="logo"><strong>커뮤니티</strong></a>
				</header>
				<br />

				<div>
					<div class="title_left">
						<h3>광고 등록</h3>
					</div>
					<form method="POST">
						<div style="display: inline-block;">
							<div class="select-wrapper">
								<span>광고분류:</span>
								<input type="hidden" name="categoryId" value="1"/>
							</div>
						
							<span>회사명:</span> 
							<input type="text" name="company" style="width: 800px;" value="${advertiseDto.company }"/> 
							<span>광고문구:</span> 
							<input type="text" name="slogan" style="width: 800px;" value="${advertiseDto.slogan }"/>
							<span>광고자:</span>
							<input type="text" name="userName" style="width: 800px;"value="${advertiseDto.userName }"/>
							<span>휴대폰 번호:</span>
							<input type="text" name="phoneNumber" style="width: 800px;" value="${advertiseDto.phoneNumber }"/>
							<input type="hidden" name="image" value="ss"/>
						</div>
						<br /> 
						<span>본문</span>
						<textarea id="body" name="content" class="smarteditor2" style="width: 800px; min-height: 100px;" >${advertiseDto.content }</textarea>
						<br /> 
						<span>광고기간:<input type="date" name="startDate" value="${advertiseDto.startDate }"/>~<input type="date" name="endDate" value="${advertiseDto.endDate }"/></span> 
						<br /> 
						<br />
						<button class="button special">저장</button>
						<a href="#" class="button">취소</a>
					</form>

				</div>
			</div>
		</div>
