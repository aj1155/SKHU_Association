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
            <h2>회원정보변경 관리</h2>
        </header>
        <section style="padding-top:50px;">
            <form:form modelAttribute="pagination" method="POST">
            	<div class="form-group">
                	<form:select path="st" style="width:200px;">
		                <form:option value="0" label="검색조건" />
		                <form:option value="1" label="기수" />
		                <form:option value="2" label="이름" />
		                <form:option value="3" label="생년월일" />
            		</form:select>
            		<form:input path="ss" style="width:200px;" />
            		<button type="submit" class="button special">검색</button>
            		<a href="userEditList" class="button">취소</a>
             	</div>
             	
                <div class="table-wrapper">
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
                            <tr data-url="userEditDetail?id=${ user.id }">
                                <td>${ user.grade }</td>
                                <td>${ user.name }</td>
                                <td>${ user.birth }</td>
                                <td>${ user.phoneNumber }</td>
                                <td>${ user.status }</td>
                                <td>${ user.companyNumber }</td>
                            </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
                
                <input type="hidden" name="cp" value="1" />
                <div align="center">
					<div class="pagination">
						<nav aria-label="Page navigation">
							<ul class="pagination">
								<c:forEach var="p" items="${ pagination.pageIndexList }">
									<li class='${ p.cssClass }'><a data-page="${ p.number }" href="#">${ p.label }</a></li>
								</c:forEach>
							</ul>
						</nav>
					</div>
				</div>
            </form:form>
        </section>
    </div>
</div>