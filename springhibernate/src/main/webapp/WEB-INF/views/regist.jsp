<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户注册界面</title>

<script type="text/javascript" src="<%=basePath%>script/jsPlumb/jquery-1.9.0.js"></script>
<script type="text/javascript" src="<%=basePath%>script/jsPlumb/jquery-ui-1.9.2-min.js"></script>
<script type="text/javascript" src="<%=basePath%>script/regist.js"></script>
<link rel="stylesheet" href="<%=basePath%>css/bootstrap.css">
<link rel="stylesheet" href="<%=basePath%>css/logon.css">

</head>
<body>
	
	<div class="container">
		<form class="form-signin" id="registform" method="post">
			<h3 class="form-signin-heading">用户注册</h3>
			<input id="username" name="name" type="text" class="input-block-level" placeholder="用户名"> 
			<br>
			<input id="password" name="password" type="password" class="input-block-level" placeholder="密码">
			<br>
			<input id="email" name="email" type="text" class="input-block-level" placeholder="邮箱"> 
			<br>
			<button name="main-log" class="btn btn-large btn-primary" type="submit" onclick="fun()">保存</button>
			<button name="main-log" class="btn btn-large btn-primary" type="submit" onclick="gotoindex()">登录</button>
		</form>

	</div>
	
	
</body>
</html>
