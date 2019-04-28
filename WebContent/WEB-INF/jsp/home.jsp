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
<title>Home</title>
<style>
body{
  background-color:#f5f7f9;
}
a { 
  text-decoration: none;
  color: #515a6e;
}

li{
  list-style-type: none;
}
.all-in-container{
		display:grid;
		grid-template-columns:repeat(12,1fr);
		grid-template-rows:50px auto;
	}
	.header{
	    display:grid;
	    grid-area:1/2/2/12;
	     width:1200px;
        grid-template-columns:repeat(12,1fr);
		background-color: #ffffff;
        align-items:center;
        justify-self:center;
	}
	.header-list{
		display:grid;
      grid-area:1/4/2/10;
		grid-template-columns:repeat(4,1fr);
		grid-template-rows:auto;
        justify-items:center;
	}
.header-list a{
  color:#515a6e;
}
.logo{
  grid-area:1/1/2/3;
  justify-self:center;
  background-color:#f5f7f9;
  padding:3px;
  color:#2d8cf0;
}
.user-login-info{
  grid-area:1/11/2/13;
  justify-self:center;
  background-color:#f5f7f9;
   padding:5px;
  color:#2d8cf0;
}


.content{
  display:grid;
  grid-area:2/4/3/10;
  justify-content:center;
  grid-template-rows:80px auto;
}
.tab-bar{
  margin-top:5px;
  display:grid;
  grid-area:1/1/2/13;
  grid-template-columns: repeat(4,1fr);
  grid-template-rows:100%;
  place-items:center;
  background-color:#f1bbba;
}
.tab-bar a:hover{
  padding:2px;
  color:#2d8cf0;
}
.card{
  display:grid;
  background-color:#fff;
  padding:4px;
  grid-template-columns: 1fr 6fr;
  grid-template-rows:100%;
}
.user-head{
  justify-self:center;
  height:48px;
  width:48px;
}
.card-content{
  display:grid;
  grid-template-columns: repeat(12,1fr);
  grid-template-rows:22px 15px auto 44px;
  
}
.user-login{
  grid-area:1/1/2/10;
  font-size:16px;
  color:#222;
}
.user-login:hover{
  color:#00a1d6;
}
.publish-time{
  font-size:12px;
  grid-area:2/1/3/10;
}
.card-detail{
  display:grid;
  grid-area:3/1/4/10;
   font-size:14px;
  letter-spacing: 1px;
}
.text-box{
	overflow:hidden;
}
.card-post-content{
	max-height: 100px;
	
}
.img-box{
  max-height:214px;
}
.img-detail{
	max-height: 100px;
	max-width: 100px;
}
.card-action{
  grid-area:4/1/5/10;
  align-self:center;
}
.card-action a{
  padding:2px;
}
.card-action a:hover{
  background-color:#f5f7f9;
  letter-spacing: 2px;
  color:#2888f5;
}
.card-action-more{
  grid-area:1/12/2/13;
}
textarea::-webkit-input-placeholder {
       color: #aab2bd;
       font-size: 20px;
    }
    textarea{
    	font-size:20px;
    }
</style>
</head>

<body class="all-in-container">
	<div class="header">
		<a href="home" class="logo">Nya☆喵克斯制药</a>
		<div class="header-list">
			<a href="home">Home</a> <a href="talk">Talk</a> <a href="blog">Blog</a>
			<a href="#">Luck</a>
		</div>
		<a href="userInfo" class="user-login-info">${user.user_nicename}</a>
	</div>

	<div class="content">

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
								<h4>
									<a href="blogDetail?postId=${ltb.postId}">${ltb.title }</a>
								</h4>
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

</body>
</html>