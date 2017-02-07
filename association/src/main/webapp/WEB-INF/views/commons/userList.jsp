<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${ list.size() == 0 }">
    <span>조회 결과가 없습니다.</span>
</c:if>

<c:if test="${ list.size() > 0 }">
    <table class="table table-bordered">
      <c:forEach var="user" items="${ list }">
        <tr>
            <td>${ user.category.name } ${ user.grade }기</td>
            <td>${ user.name }</td>
            <td>${ user.phoneNumber }</td>
        </tr>
      </c:forEach>
    </table>
</c:if>
