<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${ list.size() ==0 }">
	<span>조회 결과가 없습니다.</span>
</c:if>

<c:if test = "${ list.size() > 0 }">
	<table class="table">
		<c:forEach var="user" items="${ list }">
			<tr>
				<td><input type="checkbox" name="email" value="${ user.email }" /></td>
				<td>${ user.grade }기</td>
				<td>${ user.name }</td>
				<td>${ user.email }</td>
			</tr>
		</c:forEach>
	</table>
</c:if>
	
	


