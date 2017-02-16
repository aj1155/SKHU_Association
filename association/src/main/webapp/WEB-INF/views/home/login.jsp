<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %> 
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>


<h1>로그인을 해봅시다.!!</h1>

<form action="/loginProcessing" method="post">
    <h2>로그인 폼</h2>

    <!-- 파라미터 error가 있는경우 IF 통과 -->


    <input type="text" name="username" placeholder="계정" required="required"/>
    <input type="password" name="password" placeholder="암호" required="required"/>
    <input type="submit" value="로그인"/>
</form>
