$(function() {
	$("#submitEmail").click(function(){
		$("#emailform").attr("action","/index/register");
		$("#emailform").submit();
	});
});