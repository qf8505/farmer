<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
<title>付款成功页面</title>
<link rel="stylesheet"  type="text/css" href="../plugin/AmazeUI-2.4.2/assets/css/amazeui.css"/>
<link href="../plugin/AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet" type="text/css">
<link href="../plugin/basic/css/demo.css" rel="stylesheet" type="text/css" />

<link href="../plugin/farmer/css/sustyle.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../plugin/basic/js/jquery-1.7.min.js"></script>

</head>

<body>


<#include "head.ftl"/>

<!--悬浮搜索框-->

<div class="nav white">
	<div class="logo"><img src="../plugin/farmer/images/logo.png" /></div>
    <div class="logoBig">
      <li><img src="../plugin/farmer/images/logobig.png" /></li>
    </div>
    
    <div class="search-bar pr">
        <a name="index_none_header_sysc" href="#"></a>       
        <form>
        <input id="searchInput" name="index_none_header_sysc" type="text" placeholder="搜索" autocomplete="off">
        <input id="ai-topsearch" class="submit" value="搜索" index="1" type="submit"></form>
    </div>     
</div>

<div class="clear"></div>



<div class="take-delivery">
 <div class="status">
   <h2>注册成功</h2>
   <div class="successInfo">
     <ul>
       <div class="user-info">
         <p>您可以点击链接,<a href="/index/login">登录系统</a></p>
         <p>您可以点击链接,<a href="">完善基本信息</a></p>
       </div>
           	请保存好您的账号和密码，通过邮箱可以找回密码!
     </ul>
     <div class="option">
       <span class="info">您可以</span>
        <a href="../person/order.html" class="J_MakePoint">查看<span>购物车</span></a>
        <a href="../person/orderinfo.html" class="J_MakePoint">查看<span>订单列表</span></a>
     </div>
    </div>
  </div>
</div>


<#include "foot.ftl"/>


</body>
</html>
