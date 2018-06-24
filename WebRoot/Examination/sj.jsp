<%@page import="java.io.PrintWriter"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE>
<html>
		<title>请使用电脑访问</title>

		<meta name="keywords" content="keyword1,keyword2,keyword3">
		<meta name="description" content="this is my page">
		<meta name="content-type" content="text/html; charset=UTF-8">
		<meta charset="utf-8" />
	</head>

	<style type="text/css">
		li {
			text-align: center;
			list-style: none;
		}
		
		ul {
			margin-top: 10%;
			font-size: 500%;
		}
	</style>


<body background="../img/Examination/sjbj.jpeg">
		<ul>
			<li>客</li>
			<li>官</li>
			<li>请</li>
			<li>使</li>
			<li>用</li>
			<li>电</li>
			<li>脑</li>
			<li>访</li>
			<li>问</li>
		</ul>

	</body>

</html>