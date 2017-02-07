$(function() {
	$.ajax({
		url : '/home/sideBar?categoryId=1',
		dataType : 'json',
		type : 'GET',
		success : function(result) {
			for (var i = 0; i < result.length; i++) {
				$("#community").append(
						'<li><a href="/boardpost/list?categoryId='
								+ result[i].categoryId + '">'
								+ result[i].boardType + '</a></li>');
			}
		},
		error : function(request, status, error) {
			alert("code:" + request.status + "\n" + "message:"
					+ request.responseText + "\n" + "error:" + error);
		}
	});
});