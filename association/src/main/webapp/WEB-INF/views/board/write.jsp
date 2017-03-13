<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

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
					<a href="index.html" class="logo"><strong>커뮤니티</strong></a>
				</header>
				<br />
				<h4>글쓰기</h4>
				<br/>
				<form name="uploadFIle" method="POST" enctype="multipart/form-data">
					<input type="hidden" name="boardId" value="${boardId}"/>
					<input type="hidden" name="ac" value="board"/>
					<div style="display:inline-block;">
						<span>제목:</span> <input type="text" name="title"/>
					</div>
					<div id="files">
						<span>첨부 파일:</span> <input type="file" name="file"/>
						<button type="button" class="btn" id="addFile">
            				<i class="icon-plus"></i> 파일추가
        				</button>
					</div>
					<textarea id="body" name="content" class="smarteditor2" style="width:900px;min-height:300px;"></textarea>
					<button type="submit">저장</button>
				</form>
			</div>
		</div>
