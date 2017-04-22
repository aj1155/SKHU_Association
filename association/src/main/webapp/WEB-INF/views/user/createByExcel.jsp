<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<style>
img{
  width:100%; 
  max-width:70px;
  height:100%;
  max-height:70px;
}
</style>
<!-- Main -->
<div id="main">
	<div class="inner">
	<!-- Header -->
	<header id="header">
		<h2>동문추가 - 엑셀등록</h2>
	</header>
	<section style="padding-top:50px;">
		<div align="right">
			<form id="excelForm" method="POST" enctype="multipart/form-data">
				<input type="file" id="excelFile" name="excelFile" style="display:inline; margin-bottom:20px;"/>
				<span class="button" onclick="excelForm()">엑셀읽기</span>
			</form>
		</div>
		<form:form id="excelInsert" method="POST" action="/user/userExcelInsert" modelAttribute="userForm">
		<table>
			<thead>
				<tr>
					<td onclick='event.cancelBubble=true;'><input type="checkbox" id="all" name="all" onClick="allCkeck(this)"/><label for="all"></label></td>
					<td>기수</td>
					<td>핸드폰번호</td>
					<td>이름</td>
					<td>생년월일</td>
					<td>직장전화</td>
					<td>직책</td>
					<td>이메일</td>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="list" items="${excelList.list}" varStatus="status">
				<tr>
					<td onclick='event.cancelBubble=true;'><input type="checkbox" value="${status.count}" name="values"/><label for="${status.index}"></label></td>
					<td><input type="text" name="list[${status.index}].grade" value="${list.grade}" /></td>
					<td><input type="text" name="list[${status.index}].phoneNumber" value="${list.phoneNumber}" /></td>
					<td><input type="text" name="list[${status.index}].name" value="${list.name}" /></td>
					<td><input type="text" name="list[${status.index}].birth" value="${list.birth}" /></td>
					<td><input type="text" name="list[${status.index}].companyNumber" value="${list.companyNumber}"/></td>
					<td><input type="text" name="list[${status.index}].status" value="${list.status}" /></td>
					<td><input type="email" name="list[${status.index}].email" value="${list.email}" /></td>
				</tr>
			</c:forEach>
			<span class="button special" onclick="excelInsert(this.form)">동문추가</span>
			</tbody>
		</table>
		</form:form>
	</section>
	</div>
</div>
<script>
    $(function(){
        $("#allCheck").click(function(){
            if($("#allCheck").prop("checked")) {
                $("input[type=checkbox]").prop("checked",true);
            } else {
                $("input[type=checkbox]").prop("checked",false);
            }
        })
    });

    function excelInsert(frm){
        if($('tbody :checked').size()==0) {
            alert("등록할 회원을 선택해주세요.");
            return false;
        }
        $("#excelInsert").submit();
	};

	function excelForm(){
        var file = $("#excelFile").val();
        if(file == "" || file == null){
            alert("파일을 선택해야 가능합니다.");
            return false;
		}else if(!CheckFileType(file)){
            alert(".xlsx 파일만 업로드 가능합니다,");
            return false;
		}else {
            $("#excelForm").submit();
        }
	};

	function CheckFileType(filePath) {
        var fileType = filePath.split(".");
        if (fileType.indexOf('xlsx') > -1) {
            return true;
        }
        return false;
    }
</script>