<!DOCTYPE html>
<html>

	<head lang="en">
		<meta charset="UTF-8">
		<title>店铺注册</title>
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
		<meta name="format-detection" content="telephone=no">
		<meta name="renderer" content="webkit">
		<meta http-equiv="Cache-Control" content="no-siteapp" />

		<link rel="stylesheet" href="../plugin/AmazeUI-2.4.2/assets/css/amazeui.min.css" />
		<script src="../plugin/AmazeUI-2.4.2/assets/js/jquery.min.js"></script>
		<script src="../plugin/AmazeUI-2.4.2/assets/js/amazeui.min.js"></script>

	</head>

	<body>

		<div class="login-boxtitle">
			<a href="/index/mall"><img alt="" src="../plugin/farmer/images/logobig.png" /></a>
		</div>

		<div class="res-banner">
			<div class="res-main" style="width:60%;margin-left:20%">
			
				<form action="/store/saveStore" method="post" class="am-form" data-am-validator>
				<input type="hidden" name="${_csrf.parameterName}"value="${_csrf.token}"/>
				  <fieldset>
				    <legend>店铺注册</legend>
				    <div class="am-form-group">
				      <label for="doc-vld-name-2">店铺名称：</label>
				      <input type="text" id="storeName" name="storeName" minlength="3" placeholder="输入店铺名（至少 3 个字符）" required/>
				    </div>
				
				    <div class="am-form-group">
				      <label for="doc-vld-pic-2">店铺广告图片：</label>
				      <input type="text" id="storeAdPic" name="storeAdPic" placeholder="店铺 广告图片" required/>
				    </div>
				
				    <div class="am-form-group">
				      <label for="doc-vld-address-2">店铺地址：</label>
				      <input type="text" id="addRess" name="addRess" placeholder="店铺地址" required/>
				    </div>
				
				    <div class="am-form-group">
				      <label for="doc-vld-url-2">店铺域名：</label>
				      <input type="url" class=""  id="storeDomain" name="storeDomain" placeholder="输入网址" min="18" max="120" required />
				    </div>
				
				    <div class="am-form-group">
				      <label>店铺类型： </label>
				      <label class="am-radio-inline">
				        <input type="radio"  value="0" name="storeType" required> 普通店铺
				      </label>
				      <label class="am-radio-inline">
				        <input type="radio" value="1" name="storeType"> 高级店铺
				      </label>
				      <label class="am-radio-inline">
				        <input type="radio" value="2" name="storeType"> 经销商店铺
				      </label>
				    </div>
					<div class="am-form-group">
				      <label for="doc-vld-name-2">电话：</label>
				      <input type="text" id="storeTel" name="storeTel" minlength="3" placeholder="输入店铺名（至少 3 个字符）" required/>
				    </div>
					<div class="am-form-group">
				      <label for="doc-vld-name-2">经度：</label>
				      <input type="text" id="lon" name="lon" maxlength="2" placeholder="经度" required/>
				    </div>
				    <div class="am-form-group">
				      <label for="doc-vld-name-2">纬度：</label>
				      <input type="text" id="lat" name="lat" maxlength="2" placeholder="纬度" required/>
				    </div>
				    <div class="am-form-group">
				      <label for="doc-vld-ta-2">店铺描述：</label>
				      <textarea id="storeDesc" name="storeDesc" minlength="10" maxlength="100"></textarea>
				    </div>
				
				    <button class="am-btn am-btn-secondary" type="submit">提交</button>
				  </fieldset>
				</form>
			
				</div>
			</div>
			
		<#include "foot.ftl"/>
	</body>
</html>