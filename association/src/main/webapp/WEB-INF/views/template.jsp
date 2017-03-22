<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<tiles:insertAttribute name="header" />
</head>
<style>
	ul.pagination li:first-child{ padding-right:0; }
	ul.pagination li:last-child{ padding-left:0;}
</style>
<body>
<div id="wrapper">
		<tiles:insertAttribute name="content" />
		<tiles:insertAttribute name="menu" />
</div>		 	
</body>
<script src="${pageContext.request.contextPath}/resources/js/common.js"></script>
</html>