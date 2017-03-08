<%--
  Created by IntelliJ IDEA.
  User: iljun
  Date: 2017-02-21
  Time: 오후 2:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<style>
    .asd{
        background-color:red;
    }
</style>
<!-- Main -->
<div id="main">
    <div class="inner">

        <!-- Header -->
        <header id="header">
            <a href="index.html" class="logo"><strong>아이디 변경 관리</strong></a>
        </header>
        <section>
            <div>
                <div class="form-inline">
                    <form:form modelAttribute="pagination" method="POST">
                    <p id="allAgrees" class="btn btn-small btn-primary">일괄승인</p>
                    <form:select path="st">
                        <form:option value="0" label="검색조건" />
                        <form:option value="1" label="기수" />
                        <form:option value="2" label="이름" />
                        <form:option value="3" label="핸드폰 번호" />
                    </form:select>
                    <form:input path="ss" />
                    <button type="submit" class="btn btn-small btn-primary">검색</button>
                </div>
                <div class="table-wrapper">
                    <table>
                        <thead>
                        <tr>
                            <th><input type="checkbox" id="all" name="all" onClick="allCkeck(this)"/><label for="all"></label></th>
                            <th>기수</th>
                            <th>이름</th>
                            <th>생년월일</th>
                            <th>핸드폰번호</th>
                            <th>변경핸드폰 번호</th>
                            <th>승인여부</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="user" items="${list}">
                            <tr>
                                <td><input type="checkbox" id="${user.id}"/><label for="${user.id}"></label></td>
                                <td>${user.user.grade}</td>
                                <td>${user.user.name}</td>
                                <td>${user.user.birth}</td>
                                <td>${user.user.phoneNumber}</td>
                                <td>${user.loginId}</td>
                                <!--
                               <c:if test="${user.agree eq true}">
                                   <td><p>승인완료</p></td>
                               </c:if>
                                <c:if test="${user.agree eq false}">
                                    <td><p id="submit" class="btn btn-small btn-primary" value="${user.id}">승인</p></td>
                                </c:if>-->
                                <td><p id="submit" class="btn btn-small btn-primary" value="${user.id}">승인</p></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <input type="hidden" name="cp" value="1" />
                <div class="pagination pagination-small pagination-centered">
                    <c:forEach var="p" items="${ pagination.pageIndexList }">
                        <ul>
                            <li class='${ p.cssClass }'>
                                <a data-page="${ p.number }" href="#">${ p.label }</a>
                            </li>
                        </ul>
                    </c:forEach>
                </div>
                </form:form>
        </section>
    </div>
</div>

<script>
    $(document).on("click","#submit",function() {
            event.stopPropagation();
             var id = $(this).attr('value');
             var parent = $(this).parent();
             $.ajax({
                 type : 'GET',
                 url : 'agree'+'?id='+id,
                 success : function(msg){
                     if(msg=='success') {
                         var q = '<p>' + '승인완료' + '</p>';
                         $(parent).children("p").after(q);
                         $(parent).children("p#submit").remove();
                     }else{
                         alert('잠시후 다시 시도해주세요');
                     }
                 },
                 error : function(err){
                     alert("err : " + err);
                 }
             })
    });

    function allCkeck(checkbox){
        $("tbody input").trigger("click");
    };

    $(document).on("click","#allAgrees",function(){
            if($("tbody :checked").size()<2){
                alert("승인 목록을 확인해주세요");
                return;
            }else{
                var param="";
                $("tbody tr :checked").each(function(){
                    param += "id="+$(this).attr("id");
                    param += "&";
                });
                $.ajax({
                    url : 'agrees',
                    type : 'GET',
                    data : param,
                    dataType : 'text',
                    success : function(data){
                        if(data!='success'){
                            alert("실패");
                            return;
                        }else{
                            $("tbody tr :checked").each(function(){
                                var t = $(this).parent().parent();
                                var target = t.children(":last");
                                target.replaceWith('<p>승인 완료</p>');
                            });
                        }
                    },
                    error : function(){
                        alert('error');
                    }
                });
            }
    });
</script>

