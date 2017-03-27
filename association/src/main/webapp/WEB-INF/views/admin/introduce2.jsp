<%--
  Created by IntelliJ IDEA.
  User: iljun
  Date: 2017-02-28
  Time: 오후 1:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<%@ include file="/WEB-INF/views/commons/header.jsp" %>
</head>
<body>
<!-- Main -->
<div id="main">
    <div class="inner">
        <!-- Header -->
        <header id="header">
            <a href="index.html" class="logo"><strong>인문학습원 소개</strong></a>
        </header>
       	<section>
       	<div style="float:right;"><a href="/admin/introduceEdit" class="button special">수정</a></div>
        <div>${introduce.content}</div> 
        </section>
    </div>
</div>
</body>
</html>
