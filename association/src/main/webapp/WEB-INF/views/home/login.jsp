<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %> 
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인 test</title>
<body>
<h1>로그인</h1>
<hr />

<form method="POST" action="/login">
    <label>로그인ID</label>
    <input type="text" name="username" />

    <label>비밀번호</label>
    <input type="password" name="passwd" />

    <hr />
    <button type="submit" class="btn btn-primary">
        <i class="icon-check icon-white"></i> 로그인
   </button>
</form>


<h3>현재 사용자</h3>

<sec:authorize access="authenticated">
    <table class="table table-bordered" style="width:500px;">
        <tr>
            <td>로그인ID</td>
            <td><sec:authentication property="admin.loginId" /></td>
        </tr>
        <tr>
            <td>이름</td>
            <td><sec:authentication property="amin.name" /></td>
        </tr>
        
    </table>
</sec:authorize>

<sec:authorize access="not authenticated">
    <p style="font-size:14pt;">익명의 사용자</p>
</sec:authorize>

</body>
</html>