<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script type="text/javascript" src="<%=basePath%>script/jsPlumb/jquery-1.9.0.js"></script>
<script type="text/javascript" src="<%=basePath%>script/jsPlumb/jquery-ui-1.9.2-min.js"></script>
<script type="text/javascript" src="<%=basePath%>script/logon.js"></script>
<link rel="stylesheet" href="<%=basePath%>css/bootstrap.css">
<link rel="stylesheet" href="<%=basePath%>css/logon.css">

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录界面</title>
</head>
<body>

<input style="display: none" value="<%=basePath%>" id="basePath" />	
	
	<div class="container">

		<form class="form-signin" id="form1" name="form1" method="post" action="">
			<h3 class="form-signin-heading">登录界面</h3>
			<input id="username" name="username" type="text" class="input-block-level" placeholder="用户名"> 
			<br>
			<input id="password" name="password" type="password" class="input-block-level" placeholder="密码"> 
			<label class="checkbox">
				<input type="checkbox" value="remember-me">Remember me
			</label>
			<button name="main-log" class="btn btn-large btn-primary" type="submit" onclick="fun()">登录</button>

			<a href="regist" class="btn btn-large btn-info">注册</a>
			<br>
			<span id="errorSpan"><%if(request.getAttribute("message")!=null) out.println(request.getAttribute("message")); %></span>
		</form>

	</div>
	
	
	<br/><br/>

</body>
</html>
