<%@page import="java.util.Set"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="java.util.List"%>	
<%
	String path = request.getContextPath();

	
	//basePath2 is used for special use: creating flows
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String username=request.getSession().getAttribute("username").toString();
	Object userid=request.getSession().getAttribute("userid");

	
%>
<!doctype html>
<html lang="en">

<head>
	<meta charset="utf-8"/>
	<title>index界面</title>
</head>


<body>
	<input  value="<%=basePath%>" id="basePath" />
	<input  value="<%=userid%>" id="userId" />	
</body>

</html>