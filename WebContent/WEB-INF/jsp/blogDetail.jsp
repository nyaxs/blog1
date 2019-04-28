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
<title>UserInfo</title>
<script type="text/javascript" >
window.onload=function(){
	//原始字符串
	var string = document.getElementById("detail-content");
	var p = string.innerHTML.toString();
	//去掉所有的换行符
	p = p.replace(/\r\n/g,"<br>&nbsp;&nbsp;&nbsp;&nbsp;");
	p = p.replace(/\n/g,"<br>&nbsp;&nbsp;&nbsp;&nbsp;");
	//去掉所有的空格（中文空格、英文空格都会被替换）
	p = p.replace(/\s/g,"&nbsp;");
	//输出转换后的字符串
	string.innerHTML = p.toString();
}
</script>
<style>

body{
  background-color:#f5f7f9;
}
a { 
  text-decoration: none;
  color:#14171a;
}
a:hover{
  color:#ff691f;
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
  grid-area:2/2/3/12;
   justify-self:center;
  width:1200px;
  grid-template-columns:repeat(12,1fr);
  grid-template-rows:160px auto;
}
.blog-info{
  grid-area:1/1/2/13;
  display:grid;
  grid-template-columns:repeat(12,1fr);
  grid-template-rows:50px 28px 80px;
  place-items:center;
  background-color:#f1bbba;
}
.blog-title{
  grid-area:1/4/2/10;
}
.blog-attr{
  grid-area:2/4/3/10;
  color: #515a6e;
}
.user-attr{
  grid-area:3/4/4/8;
   display:grid;
  grid-template-columns:repeat(12,1fr);
  grid-template-rows:60% 40%;
  place-items:center;
}
.user-avatar{
   width:48px;
  height:48px;
  border-radius: 50%;
  background-color:#3db4ff;
  grid-area:1/1/3/3;
}
.author-name{
  grid-area:1/3/2/13;
  justify-self:start;
  font-size:16px;
}
.author-attr{
   grid-area:2/3/3/13;
  justify-self:start;
  font-size:14px;
   color: #515a6e;
  
}

.blog-write{
  grid-area:3/8/4/10;
  background-color:#3db4ff;
  padding:6px;
  color:#000;
}

.detail{
  grid-area:2/1/3/13;
   display:grid;
  grid-template-columns:repeat(12,1fr);
  grid-template-rows:100%;
  background-color:#fff;
  min-height:300px;
}
.detail-content{
 grid-area:1/4/2/10;
}

.tool-bar{
  grid-area:3/4/4/10;
  display:grid;
  grid-template-columns:repeat(12,1fr);
  background-color:#f1bbba;
}
.action{
  grid-area:1/1/2/13;
  display:grid;
  grid-template-columns:repeat(12,1fr);
  place-items:center;
}
.action-1{
   grid-area:1/1/2/4;
}
.action-2{
   grid-area:1/4/2/7;
}
.action-3{
   grid-area:1/7/2/10;
}
.action-4{
   grid-area:1/10/2/13;
}

</style>
<link href="//netdna.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
</head>
<body class="all-in-container">
	<div class="header">
		<a href="home" class="logo">Nya☆喵克斯制药</a>
		<div class="header-list">
			<a href="home">Home</a> <a href="talk">Talk</a> <a href="blog">Blog</a> <a
				href="#">Luck</a>
		</div>
		<a href="userInfo" class="user-login-info">${user.user_nicename}</a>
	</div>
  
	<div class="content">
        <div class="blog-info">
          <h3 class="blog-title">${post.post_title}</h3>
          <p class="blog-attr">
            <span>${post.post_type}</span>
            <span>${post.post_date}</span>
            <span>${read_count}</span>
            <span>${post.upvote_count}</span>
            <span>${post.comment_count}</span>
          </p>
          <div class="user-attr">
            <div class="user-avatar"></div>
            <a class="author-name">${user.user_nicename}@${user.user_login}</a>
            <p class="author-attr">
              <span>{followers233}</span><span>{readcount233}</span>
            </p>
         </div>
          <a href="blog" class="blog-write">Write</a>
        </div>
      
        <div class="detail">
          <p class="detail-content" id="detail-content">${post.post_content}
          </p>
      </div>
      </div>
      <div class="tool-bar">
        <p class="action">
        <a class="action-1" href="#">Upvote</a>
        <a class="action-2" href="#">Like</a>
        <a class="action-3" href="#">Share</a>
        <a class="action-4" href="#">Comment</a>
        </p>
      </div>
    </div>
</body>
</html>