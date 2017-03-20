$(document).on("click","#commentSubmit",function(){
    var text = $("#comment").val();
    var id = $("input[name=boardId]").val();
    $.ajax({
        url : 'commentSave',
        type : 'POST',
        dataType :'text',
        data :{
            comment : text,
            boardId : id
        },
        success : function(result){
            var data = $.parseJSON(result);
            var name;
            var content;
            $(data).each(function(index,item){
                name=item.writer_name;
                content=item.content;
            });
            var commentTr ='<tr>'+
                '<td colspan="2">'+name+'</td>'+
                '</tr>'+
                '<tr>'+
                '<td>'+content+'</td>'+
                '<td>'+'<p id="commentDelete" class="btn btn-primary">'+'삭제'+'</p>'+'</td>'+
                '</tr>';
            var lastTr=$('#CommentList').last();
            lastTr.after(commentTr);
            $("#comment").val("");
        },
        error : function(error){
            alert("error");
        }
    })
});

$(document).on("click","#commentDelete",function(){
    if(confirm("댓글을 삭제하시겠습니까?")==true) {
        var id = $(this).attr('value');
        alert("id : " +id );
        $.ajax({
            url: 'commentDelete',
            type: 'GET',
            dataType: 'text',
            data: {
                id: id
            },
            success: function (result) {
                if (result == 'success') {
                    var removeTr = $("#commentDelete").parent().parent();
                    var removeTr2 = removeTr.prev();
                    removeTr.remove();
                    removeTr2.remove();
                } else {
                    alert("fail");
                }
            },
            error: function (err) {
                alert(err.toString());
            }
        });
    }
});