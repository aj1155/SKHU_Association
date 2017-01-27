<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판1</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/main.css" />
<link href="http://maxcdn.bootstrapcdn.com/bootstrap/2.3.2/css/bootstrap.min.css" rel="stylesheet" media="screen">
<style>
ul.pagination li>.page {
	color: blue;
}

ul.pagination li>.page.active {
	background-color: #BEEFFF;
	color: blue !important;
}

ul.pagination li>.page.active:hover {
	background-color: #00FFFF;
}

ul.pagination li>.page.active:active {
	background-color: C0FFFF;
}
</style>
</head>
<body>
	<div id="wrapper">

		<!-- Main -->
		<div id="main">
			<div class="inner">

				<!-- Header -->
				<header id="header">
					<a href="index.html" class="logo"><strong>커뮤니티</strong></a>
				</header>
				<br />
				<h4>공지사항</h4>
				<button><a href="create">글쓰기</a></button>
				<div class="table-wrapper">
					<table>
						<thead>
							<tr>
								<th>No.</th>
								<th>제목</th>
								<th>작성자</th>
								<th>작성일</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="list" items="${ list.boardPostList }" varStatus="status">
				               <tr data-url="read?id=${list.id}">
				                    <td>${ list.title }</td>
				                    <td>${ list.content }</td>
				                    <td>${ list.writer_name }</td>
				                </tr>
							</c:forEach>            
				        </tbody>
					</table>
					<div class="pagination pagination-small pagination-centered">
						<ul>
							<li><a href="#" class="button" style="font-size: 5px;">Prev</a></li>
							<li><a href="#" class="page active">1</a></li>
							<li><a href="#" class="page">2</a></li>
							<li><a href="#" class="page">3</a></li>
							<li><a href="#" class="page">4</a></li>
							<li><a href="#" class="page">5</a></li>
							<li><a href="#" class="page">6</a></li>
							<li><a href="#" class="page">7</a></li>
							<li><a href="#" class="page">8</a></li>
							<li><a href="#" class="page">9</a></li>
							<li><a href="#" class="page">10</a></li>
							<li><a href="#" class="button" style="font-size: 5px;">Next</a></li>
						</ul>

					</div>
				</div>
				<h4>자유게시판</h4>
				<div class="table-wrapper">
					<div class="form-inline" style="float:right;">
						<select>
							<option value="0" label="검색조건" />
							<option value="1" label="아이디" />
							<option value="2" label="이름" />
							<option value="3" label="학과" />
						</select>
						<input name="st"/>
						<button type="submit" class="btn btn-small btn-primary">검색</button>
					</div>
					<br/>
					<table class="alt">
						<thead>
							<tr>
								<th>No.</th>
								<th>제목</th>
								<th>작성자</th>
								<th>작성일</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>Item1</td>
								<td>Ante turpis integer aliquet porttitor.</td>
								<td>29.99</td>
								<td>2017-01-13</td>
							</tr>
							<tr>
								<td>Item2</td>
								<td>Vis ac commodo adipiscing arcu aliquet.</td>
								<td>19.99</td>
								<td>2017-01-13</td>
							</tr>
							<tr>
								<td>Item3</td>
								<td>Morbi faucibus arcu accumsan lorem.</td>
								<td>29.99</td>
								<td>2017-01-13</td>
							</tr>
							<tr>
								<td>Item4</td>
								<td>Vitae integer tempus condimentum.</td>
								<td>19.99</td>
								<td>2017-01-13</td>
							</tr>
							<tr>
								<td>Item5</td>
								<td>Ante turpis integer aliquet porttitor.</td>
								<td>29.99</td>
								<td>2017-01-13</td>
							</tr>
							<tr>
								<td>Item5</td>
								<td>Ante turpis integer aliquet porttitor.</td>
								<td>29.99</td>
								<td>2017-01-13</td>
							</tr>
							<tr>
								<td>Item5</td>
								<td>Ante turpis integer aliquet porttitor.</td>
								<td>29.99</td>
								<td>2017-01-13</td>
							</tr>
							<tr>
								<td>Item5</td>
								<td>Ante turpis integer aliquet porttitor.</td>
								<td>29.99</td>
								<td>2017-01-13</td>
							</tr>
							<tr>
								<td>Item5</td>
								<td>Ante turpis integer aliquet porttitor.</td>
								<td>29.99</td>
								<td>2017-01-13</td>
							</tr>
							<tr>
								<td>Item5</td>
								<td>Ante turpis integer aliquet porttitor.</td>
								<td>29.99</td>
								<td>2017-01-13</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			
		</div>
		<c:import url="../commons/sidebar.jsp" />
	</div>
		<!-- Scripts -->
		<script src="${pageContext.request.contextPath}/resources/assets/js/jquery.min.js"></script>
		<script src="${pageContext.request.contextPath}/resources/assets/js/skel.min.js"></script>
		<script src="${pageContext.request.contextPath}/resources/assets/js/util.js"></script>
		<script src="${pageContext.request.contextPath}/resources/assets/js/main.js"></script>
		<script src="${pageContext.request.contextPath}/resources/common.js"></script>
</body>
</html>