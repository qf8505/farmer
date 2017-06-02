<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
	<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
	<title>付款成功页面</title>
	<#assign ctx="${springMacroRequestContext.contextPath}">
	<link rel="stylesheet"  type="text/css" href="${ctx}/plugin/AmazeUI-2.4.2/assets/css/amazeui.css"/>
	<link href="${ctx}/plugin/AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet" type="text/css">
	<link href="${ctx}/plugin/basic/css/demo.css" rel="stylesheet" type="text/css" />
	
	<link href="${ctx}/plugin/farmer/css/sustyle.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="${ctx}/plugin/basic/js/jquery-1.7.min.js"></script>

	</head>

<body>


<#include "head.ftl"/>

<!--悬浮搜索框-->

<div class="nav white">
	<div class="logo"><img src="${ctx}/plugin/farmer/images/logo.png" /></div>
    <div class="logoBig">
      <li><img src="${ctx}/plugin/farmer/images/logobig.png" /></li>
    </div>
    
    <div class="search-bar pr">
        <a name="index_none_header_sysc" href="#"></a>       
        <form action="${ctx}/search/goods">
		<input id="searchInput" name="kw" type="text" placeholder="搜索" autocomplete="off">
        <input id="ai-topsearch" class="submit" value="搜索" index="1" type="submit"></form>
    </div>     
</div>

<div class="clear"></div>



<div class="take-delivery">
 <div class="status">
   <h2>基本信息</h2>
   <div class="successInfo">
     <ul>
       <div class="user-info">
         <p>用户名:${user.userName!}</p>
         <p>email:${user.email!}</p>
         <p>电话:${user.phone!}</p>
         <p>地址:${user.addRess!}</p>
       </div>
           	<a href="/store/addStore">注册店铺</a>
     </ul>
     <div class="option">
       <span class="info">您可以</span>
        <a href="${ctx}/person/order.html" class="J_MakePoint">查看<span>购物车</span></a>
        <a href="${ctx}/person/orderinfo.html" class="J_MakePoint">查看<span>订单列表</span></a>
     </div>
    </div>
  </div>
</div>


<#include "foot.ftl"/>


</body>
</html>
