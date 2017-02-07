<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Sidebar -->
<div id="sidebar">
	<div class="inner">

		<!-- Menu -->
		<nav id="menu">
			<header class="major">
				<h2>Menu</h2>
			</header>
			<ul>
				<li><a href="index.html">Homepage</a></li>
				<li><a href="generic.html">Generic</a></li>
				<li><a href="elements.html">Elements</a></li>
				<li><span class="opener">Submenu</span>
					<ul>
						<li><a href="#">Lorem Dolor</a></li>
						<li><a href="#">Ipsum Adipiscing</a></li>
						<li><a href="#">Tempus Magna</a></li>
						<li><a href="#">Feugiat Veroeros</a></li>
					</ul></li>
				<li><a href="#">Etiam Dolore</a></li>
				<li><a href="#">Adipiscing</a></li>
				<li><span class="opener">커뮤니티</span>
					<ul id="community">
					</ul>
				</li>
				<li><span class="opener">광고</span>
					<ul>
						<li><a href="/advertise/list?categoryId=1">금융보험</a></li>
						<li><a href="/advertise/list?categoryId=2">요식업</a></li>
						<li><a href="/advertise/list?categoryId=3">컨설팅</a></li>
						<li><a href="/advertise/list?categoryId=4">서비스</a></li>
						<li><a href="/advertise/list?categoryId=5">출판인쇄</a></li>
						<li><a href="/advertise/list?categoryId=6">임대업</a></li>
						<li><a href="/advertise/list?categoryId=7">IT</a></li>
						<li><a href="/advertise/list?categoryId=8">전문직</a></li>
						<li><a href="/advertise/list?categoryId=9">자동차</a></li>
						<li><a href="/advertise/list?categoryId=10">일반제조</a></li>
						<li><a href="/advertise/list?categoryId=11">기타</a></li>
					</ul>
				</li>
				<li><a href="#">Sapien Mauris</a></li>
				<li><a href="#">Amet Lacinia</a></li>
			</ul>
		</nav>
		<!-- Footer -->
		<footer id="footer">
			<p class="copyright">
				&copy; Untitled. All rights reserved. Demo Images: <a
					href="https://unsplash.com">Unsplash</a>. Design: <a
					href="https://html5up.net">HTML5 UP</a>.
			</p>
		</footer>

	</div>
</div>
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<script>
	<c:import url="${pageContext.request.contextPath}/resources/js/sideBarAjax.js"/>
</script>