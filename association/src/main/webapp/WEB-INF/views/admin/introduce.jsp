<%--
  Created by IntelliJ IDEA.
  User: iljun
  Date: 2017-02-28
  Time: 오후 1:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!-- Main -->
</head>
<div id="main">
    <div class="inner">
        <!-- Header -->
        <header id="header">
            <a href="index.html" class="logo"><strong>인문학습원 소개</strong></a>
        </header>
        <br />
        <div>${introduce.content}</div>
        <div style="float:right;"><a href="/admin/introduceEdit">수정</a></div>
    </div>
</div>

