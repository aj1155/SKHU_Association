<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<script>
$(function() {
    $("button#addFile").click(function() {
        var tag = "<span>파일:</span> <input type='file' name='file' multiple /><br/>";
        $(tag).appendTo("div#files");
    });
});
</script>
<!-- Main -->
<div id="main">
	<div class="inner">
		<!-- Header -->
		<header id="header">
			<h2>글쓰기</h2>
		</header>
		<section style="padding-top:10px;">
		<form name="uploadFIle" method="POST" enctype="multipart/form-data">
			<input type="hidden" name="boardId" value="${boardId}"/>
			<div class="table-wrapper">
				<table>
					<tr>
						<td style="vertical-align: middle;">제목</td>
						<td><input type="text" name="title" value="${boardPostDto.title}"/><p>${error}</p></td>
					</tr>
					<tr>
						<td style="vertical-align: middle;">첨부파일</td>
						<td><input type="file" name="file"/>
							<button type="button" class="btn" id="addFile"><i class="icon-plus"></i> 파일추가</button>
						</td>
					</tr>
					<tr>
						<td style="vertical-align: middle;">내용</td>
						<td><textarea id="body" name="content" class="smarteditor2" style="width:800px;min-height:300px;">${boardPostDto.content}</textarea>
						</td>
					</tr>
					<tr>
						<td></td>
						<td><button type="submit" class="button special">저장</button></td>
				</table>
			</div>
				
		</form>
		</section>
	</div>
</div>