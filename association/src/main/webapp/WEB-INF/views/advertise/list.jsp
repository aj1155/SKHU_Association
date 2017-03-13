<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

		<!-- Main -->
		<div id="main">
			<div class="inner">

				<!-- Header -->
				<header id="header">
					<a href="index.html" class="logo"><strong>커뮤니티</strong></a>
				</header>
				<br />

				<!-- Content -->
				<section>
					<!-- Table -->
					<form>
					<div class="row uniform">
						<div class="2u">
							<div class="select-wrapper">
								<select name="demo-category" id="demo-category">
									<option value="">- 검색조건 -</option>
									<option value="1">분류</option>
									<option value="1">이름</option>
								</select>
							</div>
						</div>
						<div class="3u">
							<input type="text" placeholder=검색조건입력 />
						</div>
					</div>

					<div align="right">
						<ul class="actions">
							<li><a href="#" class="button">삭제</a></li>
							<li><a href="create"
								class="button special icon fa-plus">광고추가</a>
							</li>
							<li>
								<a href="#addCategory" class="button special icon fa-plus" data-toggle="modal">광고 분류 추가</a>
							</li>
						</ul>
					</div>
					<!-- Table -->
					<div class="table table-wrapper">
						<table>
							<thead>
								<tr>
									<th>CHECK</th>
									<th>분류</th>
									<th>이미지</th>
									<th>광고문구</th>
									<th>회사명</th>
									<th>광고자</th>
									<th>연락처</th>
									<th>시작일</th>
									<th>종료일</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="list" items="${ list.advertise }" varStatus="status">
								<tr data-url="edit?id=${list.id}">
									<td><input type="checkbox" id="demo-copy" name="demo-copy">
										<label for="demo-copy"></label>
									</td>
									<td>${list.category.name }</td>
									<td><img src="${list.image }"/></td>
									<td>${list.slogan }</td>
									<td>${list.company }</td>
									<td>${list.userName }</td>
									<td>${list.phoneNumber }</td>
									<td>${list.startDate }</td>
									<td>${list.endDate }</td>
								</tr>
							</c:forEach>
							</tbody>
						</table>
					</div>
					<div class="pagination pagination-small pagination-centered">
						<ul>
							<c:forEach var="p" items="${ pagination.pageIndexList }">
								<li class='${ p.cssClass }'>
									<a data-page="${ p.number }" href="#">${ p.label }</a>
								</li>
							</c:forEach>
						</ul>
					</div>
						<div id="addCategory" class="modal hide fade" tabindex="-1">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
								<h3>광고 카테고리 추가</h3>
							</div>
							<div class="modal-body">
								<span>카테고리 명:</span>
								<input type="text" name="name"/>
							</div>
							<div class="modal-footer">
								<button class="btn" data-dismiss="modal">닫기</button>
								<button class="btn btn-primary" onclick="addCategory()" data-dismiss="modal">추가</button>
							</div>
						</div>
				</form>
				</section>

			</div>
			</div>
<script>
	function addCategory(){
	    var categoryName = $("input[name=name]").val();
	    $.ajax({
	        url : 'categoryAdd',
			dataType : 'json',
			data : {
	            name : categoryName
			},
			success : function(result){

			}
		});
        location.href=location.href;
	}
</script>