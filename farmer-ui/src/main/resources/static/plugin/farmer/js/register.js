$(function() {
	$("#submitEmail").click(function(){
		$("#emailform").attr("action","/user/register");
		$("#emailform").submit();
	});
});