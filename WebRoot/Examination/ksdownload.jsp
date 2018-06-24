<%@page import="java.io.PrintWriter"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE>
<html>

	<head>
		<title>来自czs的考试帮助</title>
		<base href="<%=basePath%>">
		<meta name="keywords" content="keyword1,keyword2,keyword3">
		<meta name="description" content="this is my page">
		<meta name="content-type" content="text/html; charset=UTF-8">
		<meta charset="utf-8" />

	</head>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/Examination/CSS/ks.css" />

	<body style="background-image: url(../img/Examination/danbj.jpg);background-repeat: no-repeat;background-size:100%;">

		<%
		out.write("<div id='a'>");
		out.write("<marquee behavior='alternate' scrollamount='1' scrolldelay='1' width='1000'>");
		out.write("为了测试我服务器的下载传输速率，多个人同时下载看服务器蹦不蹦，谢谢大家访问此网站！也可通过www.czssix.com/Ks来直达本站。");
		out.write("</marquee>");
		out.write("</div>");

		/* <div id="a">
		<marquee behavior="alternate" scrollamount="1" scrolldelay="1"
			width="1000">
			为了测试我服务器的下载传输速率，多个人同时下载看服务器蹦不蹦，谢谢大家访问此网站！也可通过www.czssix.com/Ks来直达本站。
		</marquee>
		</div> */
	%>

		<div style="position: relative;top:20px;">
			<%
		out.write("亲,您的IP地址为：" + (String) request.getAttribute("ip"));
		out.write("你是第 " + (String) request.getAttribute("num") + " 个访问本站的用户");
	%>
		</div>
		
		<!--登陆注册-->
		
		<div>
			<span>你好</span>
		
		</div>	
		
		
		<div id="daan">
			<ul>
				<li>
					<a class="button big green" href="${pageContext.request.contextPath}/ksdownload?filename=java考试的9道题.zip">java考试的9道题.zip(24KB)</a><br>
					<img class="jstp" src="../img/Examination/mbf.jpg" /> <span class="js">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					田老师故意提早一个月说好一定考这里面的三道题</span></li>
				<li>
					<a class="button big green" href="${pageContext.request.contextPath}/ksdownload?filename=oracle复习.docx">oracle复习.docx(66KB)</a>
					<br> <img class="jstp" src="../img/Examination/trxs.jpg">
					<span class="js">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;oracle这个不是答案，这是老师发下来的复习题，跟着文档的语法走，错不了</span>
				</li>
				<li>
					<a class="button big green" href="${pageContext.request.contextPath}/ksdownload?filename=网络组建与调试.zip">网络组建与调试.zip(1.97MB)</a>
					<br> <img class="jstp" src="../img/Examination/笑.jpg" /> <span class="js">几乎每一节网络课的作业，虽然这学期比较浪的放个假就是四五天不来...但&nbsp;&nbsp;&nbsp;你要相信我
			</span></li>
			</ul>
		</div>
	</body>

</html>