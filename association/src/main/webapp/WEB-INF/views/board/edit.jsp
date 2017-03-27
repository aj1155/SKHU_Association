<%--
  Created by IntelliJ IDEA.
  User: iljun
  Date: 2017-02-13
  Time: 오후 3:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
 <script>
     $(function() {
         $("button#addFile").click(function() {
             var tag = "<input type='file' name='file' multiple /><br/>";
             $(tag).appendTo("div#files");
         });
     });
 </script>

<!-- Main -->
<div id="main">
    <div class="inner">

        <!-- Header -->
        <header id="header">
            <h2>커뮤니티</h2>
        </header>
		<section style="padding-top:10px;">
        <form name="uploadFIle" method="POST" enctype="multipart/form-data">
            <input type="hidden" name="boardId" value="${boardId}"/>
            <div class="table-wrapper">
            	<table>
            		<tr>
            			<td>제목</td>
            			<td><input type="text" name="title" value="${boardPost.title}"/><p>${error}</p></td>
            		</tr>
            		<tr>
            			<td>첨부파일</td>
            			<td>
				            <div id="files">
				                <c:forEach var="files" items="${boardPost.files}">
				                     ${files.name}<br/>
				                </c:forEach>
				                    <button type="button" class="btn" id="addFile">
				                        <i class="icon-plus"></i> 파일추가
				                    </button>
				                    <input type="file" name="file"/><br/>			                
				            </div>
				        </td>
				     </tr>
				     <tr>
				     	<td>내용</td>
				     	<td><textarea id="body" name="content" class="smarteditor2" style="width:900px;min-height:300px;">${boardPost.content}</textarea></td>
            		 </tr>
            		 <tr>
            		 	<td></td>
            		 	<td><button type="submit" class="button special">저장</button></td>
            		 </tr>
            		</table>
            	</div>
	     </form>
        </section>
    </div>
</div>

