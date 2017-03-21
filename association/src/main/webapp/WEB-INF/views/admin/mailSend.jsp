<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<script>
$(function(){
	$("button#addFile").click(function(){
		var tag="<input type='file' name='file' multiple /><br/>";
		$(tag).appendTo("td#files");
	})
})
</script>
<style>
div.modal-content { height: 800px; }
div#scroll{ 
	height :500px; 
	width:100%; 
	overflow-y:scroll; 
	border:1px solid #808080; 
}
button.close{
	width:30px;
	height:30px;
}
</style>
<div id="main">
	<div class="inner">
		<header id="header">
			<h2>메일 보내기</h2>
		</header>
		<section style="padding-top:10px;">
		<hr />
			<form method="post" enctype="multipart/form-data">
				<div class="table-wrapper">
					<table>
						<tr>
							<td>받는사람</td>
							<td><input type="text"  name="sendTo" />
								<a href="#searchEmail" class="searchButton button" data-toggle="modal">검색</a></td>
						</tr>
						<tr>
							<td>제목</td>
							<td><input type="text"  name="mailSubject" /></td>
						</tr>
						<tr>
							<td>첨부파일</td>
							<td id="files">
							<button type="button" class="button" id="addFile">
		            				<i class="icon-plus"></i> 파일추가
		        			</button>
		        			<br/>
							<input type="file" name="file" multiple />
							<br/>
		        			</td>
						<tr>
						<tr>
							<td>내용</td>
							<td><textarea id="body"  name="mailContent" class="smarteditor2" style="width:900px; min-height:300px;"></textarea></td>
						</tr>
					</table>
				</div>
					
				<hr />
				<div class="form-group">
						<ul class="actions">
							<li><button type="submit" class="button special">전송</button></li>
							<li><a href="list" class="button">취소</a></li>
						</ul>
				</div>
			</form>	
		</section>
	</div>
</div>


<!-- 메일 받는사람 -->
<div id="searchEmail" class="modal fade" role="dialog">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
        <h3>메일 받는사람</h3>
      </div>
      <div class="modal-body" style="max-height:650px;">
      	<form id="searchUser" class="form-inline" >
      		<select name="st" style="width:200px;">
      			<option value="0" label="검색조건" />
      			<option value="1" label="기수" />
      			<option value="2" label="이름" />
      		</select>
      		<input name="srchText" style="width:200px;"/>  
      		<button type="button" class="btn" onclick="searchUser()">검색</button>
      	</form>
        <div id="scroll">
        	<div id="searchResult">
        	</div>
        </div>
      </div>
      <div class="modal-footer">
        <button id="addMail" class="btn btn-default" data-dismiss="modal">선택완료</button>
      </div>
    </div>
  </div>
</div>

<script>
$(document).ready(function(){
	$("button[id='addMail']").click(function(){
		var mailAddress = [];
		$.each($("input[name='email']:checked"), function(){
			mailAddress.push($(this).val());
		});
		$("input[name='sendTo']").val(mailAddress.join(", "));		
	});
});

function searchUser() {
	var params = { srchType:$("select[name=st]").val(), 
					   srchText:$("input[name=srchText]").val()  };
	$("#searchResult").load("searchUser", params);
}

</script>