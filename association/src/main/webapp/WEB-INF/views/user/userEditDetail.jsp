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
            <a href="index.html" class="logo"><strong>회원정보변경 내용</strong></a>
        </header>
        <section>
            <div>
                <div class="posts">
                    <article>기존정보
                        <p>기수: ${user.grade}</p>
                        <p>이름: ${user.name}</p>
                        <p>로그인 아이디: ${user.loginId}</p>
                        <p>휴대폰 번호: ${user.phoneNumber}</p>
                        <p>직장 전화번호: ${user.companyNumber}</p>
                        <p>지위 : ${user.status}</p>
                    </article>
                    <article>수정정보
                        <p>기수 : ${originUser.grade}</p>
                        <p>이름 : ${originUser.name}</p>
                        <p>로그인 아이디 : ${originUser.loginId}</p>
                        <p>휴대폰 번호: ${originUser.phoneNumber}</p>
                        <p>직장 전화번호 : ${originUser.companyNumber}</p>
                        <p>지위 : ${originUser.companyNumber}</p>
                    </article>
                </div>
        </section>
        <a href="userEditList">뒤로가기</a>
    </div>
</div>
