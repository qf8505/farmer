jQuery.extend({
	logout:function(_seting){
		var _defSeting={
				url:'/logout',
		}
		_seting=$.extend(_defSeting,_seting);
		$.ajax({
			type: "post",
			url: _seting.url,
		    success: function(data,status) {
				$("#user-menu-hd").html('<a href="/login" target="_top" class="h">亲，请登录</a>&nbsp;&nbsp;<a href="/register" target="_top">免费注册</a>');
			} 
		});
	}
});