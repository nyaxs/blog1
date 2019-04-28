<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<title>HomeTest</title>
<link href="css/home.css" rel="stylesheet" type="text/css" />
</head>

<body class="all-in-container">
	<div class="header">
		<a href="home" class="logo">Nya☆喵克斯制药</a>
		<div class="header-list">
			<a href="home">Home</a> <a href="home">Talk</a> <a href="blog">Blog</a> <a
				href="#">Luck</a>
		</div>
		<a href="userInfo" class="user-login-info">${user.user_nicename}</a>
	</div>

	<div class="content">
		<div class="editor">
			<form id="talkPublishForm" action="talkPublish" >
				<input type="hidden" name="talk_author" value="${user.id}">
			</form>
			<textarea placeholder="Talk some ξ( ✿＞◡❛)" name="talk_content" form="talkPublishForm"></textarea>
			<div class="editor-toolbar">
				<a href="#">图片</a> 
				<a href="#">标签</a> 
				<a href="#">emoij</a> 
				<a href="javascript:document:talkPublishForm.submit();" class="editor-publish">Nya</a>
			</div>

		</div>

		<div class="tab-bar">
			<a href="#">时间线上</a> <a href="#">火炎焱燚</a> <a href="#">特别关注</a> <a
				href="#">收藏喜欢</a>
		</div>

		<div class="card-flow">
			<br>
			<c:forEach items="${listTimeLine}" var="ltb" varStatus="st">
				<div class="card">
					<a href="" target="_blank" class="user-head"
						style="background-image: url('image/userheadExample.png'); border-radius: 50%;"></a>

					<div class="card-content">
						<a href="#" class="user-login">${ltb.niceName}@${ltb.userLogin}</a>
						<a href="#" class="publish-time">${ltb.date}</a>
						<div class="card-detail">
							<div class="text-box">
								<a href="#">tag1</a> <a href="#">tag2</a> <a href="#">tag3</a> <br>
								<h4><a href="blogDetail?postId=${ltb.postId}">${ltb.title }</a></h4>
								<p class="card-post-content">${ltb.content}</p>
								<p>${ltb.talkDetail }</p>
							</div>
							<div class="img-box">
								<div class="img-detail"
											style="background-image: url('image/contentExampleImg.jpg')"></div>
							</div>

						</div>
						<div class="card-action">
							<a href="#">点赞</a> <a href="#">评论</a> <a href="#">喜欢</a> <a
								href="#">分享</a>

						</div>
						<button class="card-action-more">more</button>
					</div>
				</div>
				<HR align=center width=300 color=#47effe SIZE=1>
				</c:forEach>
			<br>
		</div>

	</div>



	<div class="footer"></div>
</body>
</html>