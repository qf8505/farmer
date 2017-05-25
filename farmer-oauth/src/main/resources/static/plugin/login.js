$(function() {
	$("#submitLogin").click(function(){
		$("#loginform").attr("action","/user/login");
		$("#loginform").submit();
	});
});