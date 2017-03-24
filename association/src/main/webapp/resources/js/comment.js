$(document).on("click","#commentSubmit",function(){
    var text = $("#comment").val();
    var id = $("input[name=boardPostId]").val();
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
                id = item.id;
            });
            var commentTr =
                '<tr>'+
                '<td colspan="2">작성자:'+name+'</td>'+
                '</tr>'+
                '<tr>'+
                '<td>댓글' + content + '</td>'+
                '<td>' + '<p id="commentDelete" class="btn btn-primary" style="float:right;" value="' + id + '">' + '삭제' + '</p>' + '</td>' +
                '</tr>';
            var lastTr=$('#commentList tbody').last();
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
        $.ajax({
            url: 'commentDelete',
            type: 'GET',
            dataType: 'text',
            data: {
                id: id
            },
            success: function (result) {
                if (result == 'success') {
                    var removeTr = $("tr[name=]");
                    var removeTr2 = removeTr.prev();
                    removeTr.remove();
                    removeTr2.remove();
                } else {
                    alert("삭제된 댓글입니다.");
                }
            },
            error: function (err) {
                alert(err.toString());
            }
        });
    }
});