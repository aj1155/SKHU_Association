<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>


		<!-- Main -->
		<div id="main">
			<div class="inner">

				<!-- Header -->
				<header id="header">
					<a href="index.html" class="logo"><strong>커뮤니티</strong></a>
				</header>
				<br />
				<h4>공지사항</h4>
				

				<form:form modelAttribute="pagination">
				<div class="row">
					<div class="col-sm-3">
					<form:select path="st" cssStyle="width:100%;">
						<form:option value="0" label="검색조건" />
						<form:option value="1" label="제목" />
						<form:option value="2" label="작성자" />
					</form:select>
					</div>
					<div class="col-sm-8">
					<form:input path="ss" cssStyle="width:100%;"/>
					</div>
					<div class="col-sm-1">
					<button type="submit" class="btn btn-small btn-primary" style="width:100%;">검색</button>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-10">
					</div>
					<div class="col-sm-1">
					<button style="float:right;">
						<a href="/board/create?boardId=${boardId}">글쓰기</a>
					</button>
					</div>
					<div class="col-sm-1">
						<button style="float:right;">
							<a href="#" id="groupDelete">삭제</a>
						</button>
					</div>
				</div>
				<div class="row">
				<div class="table-wrapper" style="width:100%;">
					<table>
						<thead>
							<tr>
								<th><input type="checkbox" onClick="allCkeck(this)">
									<label></label>
								</th>
								<th>제목</th>
								<th>작성자</th>
								<th>작성일</th>
							</tr>
						</thead>
						<tbody>
							<input type="hidden" name="boardId" value="${boardId}"/>
							<c:forEach var="list" items="${ list.boardPostList }" varStatus="status">
								<tr data-url="/board/read?id=${list.id}">
									<td onclick='event.cancelBubble=true;'>
										<input type="checkbox" id="${list.id}"><label for="${list.id}"></label>
									</td>
									<td>${ list.title }</td>
									<td>${ list.writer_name }</td>
									<td><joda:format value="${list.lastModifiedDate}" style="SM"/></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<input type="hidden" name="cp" value="1" />
					<div class="text-center">
						<ul class="pagination">
							<c:forEach var="p" items="${ pagination.pageIndexList }">
								<li class='${ p.cssClass }'>
									<a data-page="${ p.number }" href="#">${ p.label }</a>
								</li>
							</c:forEach>
						</ul>
					</div>
				</form:form>
				</div>
				</div>
		</div>
		
	</div>

<script>
    function allCkeck(checkbox){
        event.stopPropagation();
        $("tbody input").trigger("click");
    };

    $(document).on("click","#groupDelete",function(){
            var param="";
            var boardId=$("input[name=boardId]").val();
            $("tbody tr :checked").each(function(){
                param += "id="+$(this).attr("id");
                param += "&";
            });
            location.href="/board/groupDelete?"+param+"boardId="+boardId;
    });
</script>