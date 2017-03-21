<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<style>
	#img{
		width:150px;
		height:150px;
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

					<!-- Table -->
					<form:form modelAttribute="pagination">
					<div class="row uniform">
						<div class="2u">
							<div class="select-wrapper">
								<form:select path="st" style="width:200px;">
									<form:option value="0" label="검색조건"/>
									<form:option value="1" label="광고문구"/>
									<form:option value="2" label="회사명"/>
									<form:option value="3" label="광고자"/>
								</form:select>
							</div>
						</div>
						<div class="3u">
							<form:input path="ss" style="width:300px;"/>
						</div>
						<button type="submit">검색</button>
					</div>

					<div align="right">
						<ul class="actions">
							<li><a id="groupDelete" class="button">삭제</a></li>
							<li><a href="create"
								class="button special icon fa-plus">광고추가</a>
							</li>
							<li>
								<a href="#addCategory" class="button special icon fa-plus" data-toggle="modal">광고 분류 추가</a>
							</li>
							<li>
								<a href="#deleteCategory" class="button special icon fa-minus" data-toggle="modal">광고 분류 삭제</a>
							</li>
						</ul>
					</div>
					<!-- Table -->
					<div class="table table-wrapper">
						<table>
							<thead>
								<tr>
									<th onclick='event.cancelBubble=true;'><input type="checkbox" id="all" name="all" onClick="allCkeck(this)"/><label for="all"></label></th>
									<th>분류</th>
									<th>이미지</th>
									<th>광고문구</th>
									<th>회사명</th>
									<th>광고자</th>
									<th>연락처</th>
									<th>시작일</th>
									<th>종료일</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="list" items="${ list.advertise }" varStatus="status">
								<tr data-url="edit?id=${list.id}">
									<td onclick='event.cancelBubble=true;'><input type="checkbox" value="${list.id}" name="checkList"/><label for="${list.id}"></label>
									</td>
									<td>${list.category.name }</td>
									<td><img id="img" src="${list.image }"/></td>
									<td>${list.slogan }</td>
									<td>${list.company }</td>
									<td>${list.userName }</td>
									<td>${list.phoneNumber }</td>
									<td>${list.startDate }</td>
									<td>${list.endDate }</td>
								</tr>
							</c:forEach>
							</tbody>
						</table>
					</div>
					<div class="pagination pagination-small pagination-centered">
						<ul>
							<c:forEach var="p" items="${ pagination.pageIndexList }">
								<li class='${ p.cssClass }'>
									<a data-page="${ p.number }" href="#">${ p.label }</a>
								</li>
							</c:forEach>
						</ul>
					</div>
						<div id="addCategory" class="modal hide fade" tabindex="-1">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
								<h3>광고 카테고리 추가</h3>
							</div>
							<div class="modal-body">
								<span>카테고리 명:</span>
								<input type="text" name="name"/>
							</div>
							<div class="modal-footer">
								<button class="btn" data-dismiss="modal">닫기</button>
								<button class="btn btn-primary" onclick="addCategory()" data-dismiss="modal">추가</button>
							</div>
						</div>
						<div id="deleteCategory" class="modal hide fade" tabindex="-1">
							<div class="modal-header">
								<h3>광고 카테고리 삭제</h3>
							</div>
							<div class="modal-body">
								<span>카테고리명:</span>
								<select id="advertiseCategory">

								</select>
								<button class="btn" data-dismiss="modal" onclick="deleteCategroy()">삭제</button>
							</div>
						</div>
				</form:form>
			</div>
			<input type="hidden" name="categoryId" value="${categoryId}"/>
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

</script>