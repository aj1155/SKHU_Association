$(function() {
    $("tr[data-url]").click(function() {
        location.href = $(this).attr("data-url");
    });
    
	$("div.pagination a").click(function(){
		$("input[name=cp]").val($(this).attr("data-page"));
		$("form").submit();
	});
});