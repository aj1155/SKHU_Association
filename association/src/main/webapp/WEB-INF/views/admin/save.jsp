<%--
  Created by IntelliJ IDEA.
  User: iljun
  Date: 2017-02-16
  Time: 오후 1:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form method="POST">

    <span>아이디</span><input type="text" name="loginId" value="${adminDto.loginId}">
    <span>비밀번호</span><input type="text" name="password" value="${adminDto.password}">
    <input type="hidden" name="categoryId" value="${adminDto.categoryId}"/>
    <input type="hidden" name="categoryName"value="${adminDto.categoryName}"/>
    <span>email</span><input type="email" name="email" value="${adminDto.email}">
    <span>birth</span><input type="text" name="birth" value="${adminDto.birth}">
    <span>phoneNumber</span><input type="text" name="phoneNumber" value="${adminDto.phoneNumber}">
    <span>name</span><input type="text" name="name" value="${adminDto.name}">
    <button type="submit">입력</button>
</form>
