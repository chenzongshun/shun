<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE>
<html>

	<head>
		<base href="<%=basePath%>">
		<title>这个人是头猪</title>
		<meta charset="utf-8" />
	</head>
	<link rel="stylesheet" type="text/css" href="css/one.css" />
	
	
	<body>
		<div class="top">
			<div class="top-1">
				<ul>
					<li>首页</li>
					<li>生活</li>
					<li>旅行</li>
					<li>技术</li>
				</ul>

				<div style="position:relative;bottom:20px">
					<img src="img/tx.png" width="26%" />
				</div>
			</div>
			<div class="top-2">
				我叫陈宗顺，一名计算机专业大二的学生<br> 爱生活，爱旅行，爱技术
			</div>
		</div>

		<div class="bankuai">
			<span id="ashfont">爱技术</span>
			<hr class="lx" />
			<br /><br />
			  <img src="img/ajs.jpg" width="100%" />
		</div>
		
		<!--用来显示成果的轮播图，借鉴了酷狗的广告===开始-->
		<!--
		<script type="text/javascript" src="js/借鉴了酷狗的广告/jquery.min.js"></script>
		<script type="text/javascript" src="js/借鉴了酷狗的广告/jquery.focus.js"></script>
		<script type="text/javascript" src="js/借鉴了酷狗的广告/load.js"></script>
		<link rel="stylesheet" type="text/css" href="css/借鉴了酷狗的广告/styles.css" />
		<div>
			<div class="focusWrap">
			
				<div class="focusCon" id="j_Focus">
			
					<div class="focusL">
						<ul class="ulFocus" id="j_FocusNav">
							<li rel="0"><span>酷狗7正式版发布<br/>音乐魔力全线绽放</span></li>
							<li rel="1"><span>海量免费高清MV<br/>更清晰更流畅</span></li>
							<li rel="2"><span>酷狗7:音乐魔方<br/>带给你全新播放体验</span></li>
							<li rel="3"><span>个性化歌曲推荐<br/>酷狗猜你喜欢</span></li>
							<li rel="4"><span>酷狗收音机<br/>重新认识电台魅力</span></li>
							<li rel="5"><span>手机酷狗3.0<br/>无线音乐新序章</span></li>
						</ul>
						<div class="back" id="j_FocusBack"></div>
					</div>
			
					<div class="focusM">
						<ul class="ulFCon" id="j_FocusCon">
							<li>
								<a href="#"><img src="img/借鉴了酷狗的广告/1.jpg" alt="酷狗7正式版发布" /></a>
							</li>
							<li>
								<a href="#"><img src="img/借鉴了酷狗的广告/2.jpg" alt="海量免费高清MV" /></a>
							</li>
							<li>
								<a href="#"><img src="img/借鉴了酷狗的广告/3.jpg" alt="酷狗7:音乐魔方" /></a>
							</li>
							<li>
								<a href="#"><img src="img/借鉴了酷狗的广告/4.jpg" alt="个性化歌曲推荐" /></a>
							</li>
							<li>
								<a href="#"><img src="img/借鉴了酷狗的广告/5.jpg" alt="酷狗收音机" /></a>
							</li>
							<li>
								<a href="#"><img src="img/借鉴了酷狗的广告/6.jpg" alt="手机酷狗3.0" /></a>
							</li>
			
							<li>
								<a href="#"><img src="img/借鉴了酷狗的广告/6.jpg" alt="手机酷狗3.0" /></a>
							</li>
							<li>
								<a href="#"><img src="img/借鉴了酷狗的广告/6.jpg" alt="手机酷狗3.0" /></a>
							</li>
							<li>
								<a href="#"><img src="img/借鉴了酷狗的广告/6.jpg" alt="手机酷狗3.0" /></a>
							</li>
						</ul>
					</div>
			
				</div>
			
				<div class="focusR">
					<div class="kugoo">
						<a href="#">马上下载酷狗7</a>
					</div>
					<ul class="ulHot">
						<li>
							<a href="#">酷狗音乐2011</a>
						</li>
						<li>
							<a href="#">手机酷狗3.0版</a>
						</li>
						<li>
							<a href="#">酷狗网络收音机</a>
						</li>
						<li>
							<a href="#">酷狗叮咚</a>
						</li>
					</ul>
				</div>
			</div>
		</div>-->
		<!--用来显示成果的轮播图，借鉴了酷狗的广告===结束-->
	
		<div class="bankuai">
			<span id="ashfont">爱生活</span>
			<hr class="lx" />
			<img src="img/ash.png" width="100%" />
		</div>

		<div class="bankuai">
			<span id="ashfont">爱旅行</span>
			<hr class="lx" />
			<img src="img/alx.jpg" width="100%" />
		</div>

		<br /><br /><br />
		<!--
		<span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;我在马云家的阿里巴巴买了台Linux系统“云服务器”（我的钱...），调试了两天不成功，心灰意冷，突然之间就调试好了，迫不及待的简单做了个web前端网页放在服务器上面，这台服务器在深圳，还在腾讯买了个域名叫www.czssix.com，好吧我也觉得这个域名Low，把名字放上去是有意义的，为了让招聘会的人对我加深印象我才这么取，我觉得阿里云的域名好贵啊，然后我就买了腾讯的域名，当然还没有映射到这个ip地址上面，所以你只能通过120.79.70.46来访问我这个网站的。总而言之就是很高兴了啦，这对我来说真的意义非凡，这是我属于一个人服务器、我搭建的开放环境、我一个人切图、一个人写代码、一个人....我仿佛感受到了互联网创业的不易...从头到尾都是一个人。这个网站会不定时的进行更新（这就意味着要租服务器费用，域名也是......没想到还要花钱养这种东西...），这个网站以后就用来作为我的学习环境，和学校校招的企业来学校招聘时作为我的加分项吧，我想应该会比较抢手吧？（希望我没想多）。好像挺后悔加入it行业的，我也不知道我究竟花了多少时间才能够做到这样，虽然目前这样根本不值一提...it行业实在太累了，从早坐到晚，不能停，尤其是我这种英文不好，数学逻辑思维更不用说的人更是不能停止学习新知识，因为互联网发展速度太快了...太快了...或许这就是这个行业普遍高薪的原因吧！算了文笔太Low，不写了，我~有点小累。要下楼吃面了</span>
		-->
		<div style="text-align: right; padding-top: 30px; padding-bottom: 30px;">2018-01-20 21:18 End</div>
	</body>
	<script src="JS/PCorPhone.js"></script>

</html>