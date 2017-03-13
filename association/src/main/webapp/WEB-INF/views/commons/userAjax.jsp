<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<style>
#searchResult tr:hover { background-color: #ffe; cursor: pointer; }
#searchResult tr.selected { background-color: #fee; font-weight: bold; }
</style>
<div id="addMember" class="modal hide fade" tabindex="-1">
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
		<h3>회원 검색</h3>
	</div>
	<div class="modal-body">
		<form id="searchUser" class="form-inline">
            <span>이름:</span>
            <input type="text" name="name" />
            <button id="search" type="button" class="btn" onclick="searchUser()">검색</button>
        </form>
		<div id="searchResult" style="width: 100%; height: 200px;">
			<table class="table table-bordered">
				<tr>
				</tr>
			</table>
		</div>
	</div>
	<div class="modal-footer">
		<button class="btn" data-dismiss="modal">닫기</button>
		<button class="btn btn-primary" onclick="selectUser()" data-dismiss="modal">선택</button>
	</div>
</div>
<script>
function searchUser() {
    var params = $("input[name=name]").val();
    $.ajax({
        url: 'searchUser',
        dataType: 'json',
        data: {
            name: params
        },
        success: function (list) {
            for (var i = 0; i < list.length; i++) {
                var tag = '<tr>' +
                    '<td>' + list[i].category.name + list[i].grade + '기' + '</td>' +
                    '<td>' + list[i].name + '</td>' +
                    '<td>' + list[i].phoneNumber + '</td>' +
                    '</tr>';
                $("#searchResult tr:last-child").after(tag);
            }
        },
        error: function (err) {
            alert(err);
        }
    });
    $("#searchResult").load("searchUser", params, function() {
        $("#searchResult tr").click(function() {
            $("#searchResult tr").removeClass("selected");
            $(this).addClass("selected");
        })
    });
}
function selectUser() {
    var selectedTr = $("#searchResult tr.selected");
    var userName = selectedTr.find("td:nth-child(2)").text();
    var phoneNumber = selectedTr.find("td:nth-child(3)").text();
    $("input[name=userName]").val(userName);
    $("input[name=phoneNumber]").val(phoneNumber);
}
</script>