<!DOCTYPE html>
<html>

	<head lang="en">
		<meta charset="UTF-8">
		<title>登录</title>
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
		<meta name="format-detection" content="telephone=no">
		<meta name="renderer" content="webkit">
		<meta http-equiv="Cache-Control" content="no-siteapp" />

		<link rel="stylesheet" href="../plugin/AmazeUI-2.4.2/assets/css/amazeui.min.css" />
		<link href="../plugin/farmer/css/dlstyle.css" rel="stylesheet" type="text/css">
		<script src="../plugin/AmazeUI-2.4.2/assets/js/jquery.min.js"></script>
		<script src="../plugin/AmazeUI-2.4.2/assets/js/amazeui.min.js"></script>
	</head>

	<body>

		<div class="login-boxtitle">
			<a href="/index/mall"><img alt="logo" src="../plugin/farmer/images/logobig.png" /></a>
		</div>

		<div class="login-banner">
			<div class="login-main">
				<div class="login-banner-bg"><span></span><img src="../plugin/farmer/images/big.jpg" /></div>
				<div class="login-box">

							<h3 class="title">登录商城</h3>

							<div class="clear"></div>
						
						<div class="login-form">
						  <form method="post" id="loginform" data-am-validator>
						  <input type="hidden" name="${_csrf.parameterName}"value="${_csrf.token}"/>
							   <div class="user-name">
								    <label for="user"><i class="am-icon-user"></i></label>
								    <input type="text" name="userName" id="user" placeholder="邮箱/手机/用户名" minlength="3" required>
                 </div>
                 <div class="user-pass">
								    <label for="password"><i class="am-icon-lock"></i></label>
								    <input type="password" name="passWord" id="password" placeholder="请输入密码" minlength="6" required>
                 </div>
              </form>
           </div>
            
            <div class="login-links">
                <label for="remember-me"><input id="remember-me" type="checkbox">记住密码</label>
								<a href="#" class="am-fr">忘记密码</a>
								<a href="/index/register" class="zcnext am-fr am-btn-default">注册</a>
								<br />
            </div>
								<div class="am-cf">
									<input type="submit" id="submitLogin" name="" value="登 录" class="am-btn am-btn-primary am-btn-sm">
								</div>
						<div class="partner">		
								<h3>合作账号</h3>
							<div class="am-btn-group">
								<li><a href="#"><i class="am-icon-qq am-icon-sm"></i><span>QQ登录</span></a></li>
								<li><a href="#"><i class="am-icon-weibo am-icon-sm"></i><span>微博登录</span> </a></li>
								<li><a href="#"><i class="am-icon-weixin am-icon-sm"></i><span>微信登录</span> </a></li>
							</div>
						</div>	
<font color="#FF0000">${msg!}</font> 
				</div>
			</div>
		</div>


		<#include "foot.ftl"/>
	</body>
<script src="../plugin/farmer/js/login.js"></script>
</html>