<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String username=request.getSession().getAttribute("username").toString();
	Object userid=request.getSession().getAttribute("userid");
	
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>主界面</title>
<link rel="stylesheet" href="<%=basePath%>/script/dijit/themes/claro/claro.css">
<link rel="stylesheet" href="<%=basePath%>/style/ScrollPane.css">

<link rel="stylesheet" href="<%=basePath%>/style/flow.css">
<link rel="stylesheet" href="<%=basePath%>/style/flow.ui.css">
<link rel="stylesheet" href="<%=basePath%>/style/flow.main.css">


<script type="text/javascript"
	src="script/jsPlumb/jquery-1.9.0.js"></script>
<script type="text/javascript"
	src="script/jsPlumb/jquery-ui-1.9.2-min.js"></script>
<script type="text/javascript"
	src="script/jsPlumb/jquery.ui.touch-punch.min.js"></script>
<script type="text/javascript"
	src="script/jsPlumb/jquery.jsPlumb-1.4.1-all.js"></script>
	
<script type="text/javascript"
	src="script/dojo/dojo.js"></script>
	
<script type="text/javascript" src="<%=basePath%>script/flow.js"></script>
<script type="text/javascript" src="<%=basePath%>script/flow.ui.js"></script>
<script type="text/javascript" src="<%=basePath%>script/flow.main.js"></script>


</head>
<body class="claro">
	<script type="text/javascript">
		var username="<%=username%>";
		var userid=<%=userid%>;
	</script>
	<input type="hidden" value="<%=basePath%>" id="basePath" />	
	
	<!--
	<a href="http://192.168.11.45:8080/WorkFlowExe/">工作流执行引擎</a>
	<a href="http://192.168.11.45/demo/workflowviewer.htm">工作流浏览页面</a> <br/>
	-->

</body>
</html>
