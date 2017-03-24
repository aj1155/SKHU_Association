<%--
  Created by IntelliJ IDEA.
  User: iljun
  Date: 2017-02-21
  Time: 오후 1:21
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
            <h2>회원정보변경 내용</h2>
        </header>
        <section>
        
	          <div class="table-wrapper">
				<table>
					<thead>
						<tr>
							<th>유형</th>
							<th>수정된 정보</th>
							<th>기존정보</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>기수</td>
							<td>${user.grade}</td>
							<td>${originUser.grade}</td>
						</tr>
						<tr>
							<td>이름</td>
							<td>${user.name}</td>
							<td>${originUser.name}</td>
						</tr>
						<tr>
							<td>로그인아이디</td>
							<td>${user.loginId}</td>
							<td>${originUser.loginId}</td>
						</tr>
						<tr>
							<td>핸드폰번호</td>
							<td>${user.phoneNumber}</td>
							<td>${originUser.phoneNumber}</td>
						</tr>
						<tr>
							<td>직장번호</td>
							<td>${user.companyNumber}</td>
							<td>${originUser.companyNumber}</td>
						</tr>
						<tr>
							<td>지위</td>
							<td>${user.status}</td>
							<td>${originUser.status}</td>
						</tr>
				</tbody>
			  </table>
			</div>	

        </section>
        <a href="userEditList" class="button">뒤로가기</a>
     
    </div>
</div>

