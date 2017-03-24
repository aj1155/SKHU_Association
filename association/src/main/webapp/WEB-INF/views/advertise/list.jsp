<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<style>
img{
	max-width:200px;
	max-height:200px;
}
button.close{
	width:30px;
	height:30px;
}
</style>
<!-- Main -->
<div id="main">
	<div class="inner">

		<!-- Header -->
	<header id="header">
		<a href="index.html" class="logo"><strong>커뮤니티</strong></a>
	</header>
	<br />
	<section style="padding-top:50px;">
		<!-- Table -->
		<form:form modelAttribute="pagination">
		<div align="right">
			<ul class="actions">
				<li><a id="groupDelete" class="button">삭제</a></li>
				<li><a href="create" class="button special icon fa-plus">광고추가</a></li>
				<li><a href="#addCategory" class="button special icon fa-plus" data-toggle="modal">광고 분류 추가</a></li>
				<li><a href="#deleteCategory" class="button special icon fa-minus" data-toggle="modal">광고 분류 삭제</a></li>
			</ul>
		</div>
		
		<div class="form-group">
			<form:select path="st" style="width:200px;">
				<form:option value="0" label="검색조건"/>
				<form:option value="1" label="광고문구"/>
				<form:option value="2" label="회사명"/>
				<form:option value="3" label="광고자"/>
			</form:select>
			<form:input path="ss" placeholder="검색조건입력" style="width:200px;"/>
			<button type="submit" class="button">검색</button>
		</div>

		<!-- Table -->
		<div class="table table-wrapper" style="margin-top:10px;">
			<table>
				<thead>
					<tr>
						<th><input type="checkbox" /></th>
						<th>광고유형</th>
						<th>이미지</th>
						<th>[ 회사명 ] 광고문구</th>
						<th>광고자</th>
						<th>연락처</th>
						<th>시작일</th>
						<th>종료일</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="list" items="${ list.advertise }" varStatus="status">
					<tr data-url="edit?id=${ list.id }">
						<td onclick='event.cancelBubble=true;'><input type="checkbox" value="${list.id}" name="checkList"/><label for="${list.id}"></label></td>
						<td>${ list.category.name }</td>
						<td><img src="${ list.image }"/></td>
						<td>[ ${ list.company } ] ${ list.slogan }</td>
						<td>${ list.userName }</td>
						<td>${ list.phoneNumber }</td>
						<td><fmt:formatDate pattern="yyyy-MM-dd" value="${ list.startDate }" /></td>
						<td><fmt:formatDate pattern="yyyy-MM-dd" value="${ list.endDate }" /></td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
			<input type="hidden" name="categoryId" value="${categoryId}"/>
		</div>


		<div align="center">
			<div class="pagination">
				<ul class="pagination">
					<c:forEach var="p" items="${ pagination.pageIndexList }">
						<li class='${ p.cssClass }'>
							<a data-page="${ p.number }" href="#">${ p.label }</a>
						</li>
					</c:forEach>
				</ul>
			</div>
		</div>

		<div id="addCategory" class="modal fade" tabindex="-1" role="dialog">
			<div class="modal-dialog">
				<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
					<h3>광고 카테고리 추가</h3>
				</div>
				<div class="modal-body">
					<span>카테고리 명:</span>
					<input type="text" name="name"/>
				</div>
				<div class="modal-footer">
					<button class="button" data-dismiss="modal">닫기</button>
					<button class="button special" onclick="addCategory()" data-dismiss="modal">추가</button>
				</div>
				</div>
			<input type="hidden" name="categoryId" value="${categoryId}"/>
			</div>
		</div>
		
		<div id="deleteCategory" class="modal fade" tabindex="-1" role="dialog">
			<div class="modal-dialog">
				<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
					<h3>광고 카테고리 삭제</h3>
				</div>
				<div class="modal-body">
					<span>카테고리명:</span>
					<input type="text" name="categoryName"/>
					<button class="button" data-dismiss="modal" onclick="deleteCategory()">삭제</button>
				</div>
				</div>
			</div>
		</div>
		
	</form:form>
	</section>
  </div>
</div>
<script>
    function allCkeck(checkbox){
        $("tbody input").trigger("click");
    };

    $(document).on("click","#groupDelete",function(e){
        if($('tbody :checked').size()==0){
            alert("삭제할 광고를 선택해주세요");
            return false;
        }else {
            if(confirm("정말 삭제하시겠습니까?")==true) {
                var param = "";
                var categoryId = $("input[name=categoryId]").val();
                $("tbody tr :checked").each(function () {
                    param += "id=" + $(this).val();
                    param += "&";
                });
                e.preventDefault();
                document.location.href = "/advertise/groupDelete?" + param + "categoryId=" + categoryId;
            }
        }
    });

    function addCategory(){
        var categoryName = $("input[name=name]").val();
        $.ajax({
            url : 'categoryAdd',
            dataType : 'json',
            data : {
                name : categoryName
            },
            success : function(result){

            }
        });
        location.href=location.href;
    }

	function deleteCategory(){
		var categoryName = $("input[name=categoryName]").val();
		if(confirm("카테고리를 삭제하시면 해당 카테고리에 관련된 게시물은 모두 삭제됩니다,")==true) {
            $.ajax({
                url: 'categoryDelete',
                dataType: 'json',
                data: {
                    categoryName: categoryName
                },
                success: function (result) {
                    if (result == false)
                        alert("카테고리명을 정확히 입력해주세요");
                }
            });
            location.href = location.href;
        }
	}

    $(document).on("click","#groupDelete",function(e){
        if($('tbody :checked').size()==0){
            alert("삭제할 게시물을 선택해주세요");
            return false;
        }else {
            if(confirm("정말 삭제하시겠습니까?")==true) {
                var param = "";
                var categoryId= $("input[name=categoryId]").val();
                alert(categoryId);
                $("tbody tr :checked").each(function () {
                    param += "id=" + $(this).val();
                    param += "&";
                });
                e.preventDefault();
                document.location.href = "/advertise/groupDelete?" + param + "categoryId=" + categoryId;
            }
        }
    });
</script>