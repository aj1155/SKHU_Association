$(function() {
	$.ajax({
		url : '/home/menu/board',
		dataType : 'json',
		type : 'GET',
		success : function(result) {
			for (var i = 0; i < result.length; i++) {
				$("#community").append(
						'<li><a href="/board/list?boardId='
								+ result[i].boardId + '">'
								+ result[i].boardType + '<p class="badge badge-danger" id='+i+'></p></a></li>');
			}
		},
		error : function(request, status, error) {
			alert("code:" + request.status + "\n" + "message:"
					+ request.responseText + "\n" + "error:" + error);
		}
	});
});

$(function(){
	$.ajax({
		url : '/home/menu/advertise',
		dataType :'json',
		type : 'GET',
		success : function(result){
			for(var i = 0; i < result.length; i++){
				$("#advertise").append(
					'<li><a href="/advertise/list?categoryId='
						+result[i].id +'">'
						+result[i].name + '<p class="badge badge-danger" id='+i+'></p></a></li>');
			}
		},
		error : function(request, status, error){
			alert("code:" + request.status + "\n"+ "message:"+ request.responseText + "\n" + "error: " + error);
		}
	});
});

$(function(){
	$.ajax({
		url : '/home/menu/phoneNumberEdit',
		dataType : 'json',
		type : 'GET',
		success: function(result){
			$("#phoneNumberEdit").text(result);
		},
        error : function(request, status, error){
            alert("code:" + request.status + "\n"+ "message:"+ request.responseText + "\n" + "error: " + error);
        }
	});
});

$(function(){
	$.ajax({
		url : '/home/menu/userEdit',
		dataType : 'json',
		type : 'GET',
		success : function(result){
			$("#userEdit").text(result);
		},
        error : function(request, status, error){
            alert("code:" + request.status + "\n"+ "message:"+ request.responseText + "\n" + "error: " + error);
        }
	});
});

$(function(){
	$.ajax({
		url : '/home/menu/boardCount',
		dataType : 'json',
		type : 'GET',
		success : function(result){
			for(var i =0; i<result.length; i++) {
                $("#"+i).text(result[i]);
            }

		}
	});
});