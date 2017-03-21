$(document).ready(function(){
    $("tr[data-url]").click(function() {
        location.href = $(this).attr("data-url");
    });
    
	$("div.pagination a").click(function(){
		$("input[name=cp]").val($(this).attr("data-page"));
		$("form").submit();
	});
	function stop_propagation_handler(e) {
	    e.stopPropagation();
	}
	$("td input:checkbox").each(function(c) {
	  	$(this).parent().click(stop_propagation_handler);
	})
	$("thead input:checkbox").click(function() {
	  	$("tbody input:checkbox").each(function() {
	  		$(this).prop("checked", !$(this).prop("checked"));
	  	});
	});
});
