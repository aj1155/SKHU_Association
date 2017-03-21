<%--
  Created by IntelliJ IDEA.
  User: iljun
  Date: 2017-02-20
  Time: 오전 11:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!-- Main -->

<div id="main">
    <div class="inner">

        <!-- Header -->
        <header id="header">
            <a href="index.html" class="logo"><strong>회원정보변경 관리</strong></a>
        </header>
        <section>
        <div>
            <div class="row">
                <div class="col-sm-3">
                <form:form modelAttribute="pagination" method="POST">
                    <form:select path="st">
                    <form:option value="0" label="검색조건" />
                    <form:option value="1" label="기수" />
                    <form:option value="2" label="이름" />
                    <form:option value="3" label="생년월일" />
                </form:select>
                </div>
                    <div class="col-sm-8">
                <form:input path="ss" />
                    </div>
                    <div class="col-sm-1">
                <button type="submit" class="btn btn-small btn-primary">검색</button>
                    </div>
                    </div>
            <div class="row">
                <div class="table-wrapper" style="width:100%;">
                    <table>
                        <thead>
                        <tr>
                            <th>기수</th>
                            <th>이름</th>
                            <th>생년월일</th>
                            <th>핸드폰번호</th>
                            <th>소속지위</th>
                            <th>직장전화번호</th>
                        </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="user" items="${userEditList}">
                            <tr data-url="userEditDetail?id=${user.id}">
                                <td>${user.grade}</td>
                                <td>${user.name}</td>
                                <td>${user.birth}</td>
                                <td>${user.phoneNumber}</td>
                                <td>${user.status}</td>
                                <td>${user.companyNumber}</td>
                            </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
                <input type="hidden" name="cp" value="1" />
                <div class="pagination pagination-small pagination-centered">
                    <c:forEach var="p" items="${ pagination.pageIndexList }">
                    <ul>
                        <li class='${ p.cssClass }'>
                        <a data-page="${ p.number }" href="#">${ p.label }</a>
                        </li>
                    </ul>
                    </c:forEach>
                </div>
            </form:form>
        </section>
    </div>
</div>