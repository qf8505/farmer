<!--顶部导航条 -->
<div class="am-container header">
	<ul class="message-l">
		<div class="topMessage">
			<div class="menu-hd" id="user-menu-hd">
				<#if user??>
				${user.userName!}&nbsp;&nbsp;<a href="#" onclick="$.logout({url:'logout?${_csrf.parameterName}=${_csrf.token}'})" target="_top" class="h">退出</a>
				<#else>
				<a href="/login" target="_top" class="h">亲，请登录</a>&nbsp;&nbsp;<a href="/register" target="_top">免费注册</a>
				</#if>
			</div>
		</div>
	</ul>
	<ul class="message-r">
		<div class="topMessage home">
			<div class="menu-hd"><a href="#" target="_top" class="h">商城首页</a></div>
		</div>
		<div class="topMessage my-shangcheng">
			<div class="menu-hd MyShangcheng"><a href="#" target="_top"><i class="am-icon-user am-icon-fw"></i>个人中心</a></div>
		</div>
		<div class="topMessage mini-cart">
			<div class="menu-hd"><a id="mc-menu-hd" href="#" target="_top"><i class="am-icon-shopping-cart  am-icon-fw"></i><span>购物车</span><strong id="J_MiniCartNum" class="h">0</strong></a></div>
		</div>
		<div class="topMessage favorite">
			<div class="menu-hd"><a href="#" target="_top"><i class="am-icon-heart am-icon-fw"></i><span>收藏夹</span></a></div>
	</ul>
</div>
<script src="../plugin/farmer/js/mall.js"></script>