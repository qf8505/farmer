<html>
<head>
</head>
<body>
	<div class="container">
		<h2>登录跳转...</h2>
		<p>
			正在登录:"${authorizationRequest.clientId!}"
		</p>
		<form id="confirmationForm" name="confirmationForm"
			action="../oauth/authorize" method="post">
			<input name="user_oauth_approval" value="true" type="hidden" />
			<input type="hidden" id="csrf_token" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		</form>
	</div>
	<script src="../plugin/AmazeUI-2.4.2/assets/js/jquery.min.js"></script>
	<script src="../plugin/farmer/js/authorize.js"></script>
</body>
</html>