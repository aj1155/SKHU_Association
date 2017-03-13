<%--
  Created by IntelliJ IDEA.
  User: iljun
  Date: 2017-02-28
  Time: 오후 1:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!-- Main -->

<div id="main">
    <div class="inner">
        <!-- Header -->
        <header id="header">
            <a href="index.html" class="logo"><strong>인문학습원 소개</strong></a>
        </header>
        <br />
        <form:form modelAttribute="introduce" method="POST" action="introduceEdit">
            <textarea id="body" name="content" class="smarteditor2" style="width:inherit;"></textarea>
            <button class="btn btn-primary" type="submit">저장하기</button>
        </form:form>
    </div>
</div>

