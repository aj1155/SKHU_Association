<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!-- Main -->
<div id="main">
	<div class="inner">

		<!-- Header -->
		<header id="header">
			<a href="index.html" class="logo"><strong>회원유형</strong></a>
		</header>
		<section style="paddin-top:50px;">
		<div align="right">
			<ul class="actions">
				<li><a href="createType" class="button special icon fa-plus">임원추가</a></li>
			</ul>
		</div>
		<div class="table-wrapper">
			<table>
				<thead>
					<tr>
						<th>명칭</th>						
					</tr>
				</thead>
				<tbody>
					<c:forEach var="type" items="${ list }" >
						<tr>
							<td>${ type.name }</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</div>
		
			</section>
	</div>
</div>

