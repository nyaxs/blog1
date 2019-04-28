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
  grid-area:2/2/3/12;
   justify-self:center;
  width:1200px;
  grid-template-columns:repeat(12,1fr);
  grid-template-rows:170px auto;
}
.profile-canopy-nav{
    grid-area:1/1/2/13;
   display:grid;
  grid-template-columns:repeat(12,1fr);
   grid-template-rows:60px 50px 50px;
}
.profile-canopy{
   background-color:#f1bbba;
    grid-area:1/1/3/13;
}
.user-avatar{
  width:100px;
  height:100px;
  
  grid-area:2/3/4/5;
  border-radius: 50%;
  background-color:#3db4ff;
}
.user-nav{
  z-index:-1;
  grid-area:3/1/4/13;
  background-color:#fff;
  display:grid;
  grid-template-columns:repeat(12,1fr);
  align-items:center;
}
.user-search{
  grid-area:1/4/2/6;
  height:30px;
  width:180px;
  margin-left:6px;
}
.nav-following{
   grid-area:1/7/2/9;
  justify-self:center;
}
.nav-follower{
   grid-area:1/9/2/11;
  justify-self:center;
}
.user-info{
  grid-area:2/3/3/5;
  background-color:#f1bbba;
  padding:10px;
}
.user-info a span{
  font-size:12px;
}
.user-info p{
  color:#14171a;
  font-size:14px;
}
.user-date{
  font-size:14px;
  color:#657786;
}

.user-count{
  grid-area:2/5/3/7;
  background-color:#fff;
  margin-left:10px;
  display:grid;
  grid-template-rows:74px 74px 74px 74px ;
}
.user-count a{
  font-size:16px;
  display:grid;
  place-items:center;
}
.user-count span{
  color:#14171a;
  font-size:18px;
  font-weight: 600;
}
.user-following{
   grid-area:2/7/3/9;
  background-color:#f1bbba;
  margin-left:10px;
  display:grid;
  grid-template-columns:100%;
  grid-template-rows:100%;
}
.user-follower{
   grid-area:2/9/3/11;
  background-color:#fff;
  margin-left:10px;
  display:grid;
  grid-template-columns:100%;
  grid-template-rows:100%;
}
.profile-card{
  height:210px;
  width:180px;
  display:grid;
  grid-template-columns:50% 50%;
  grid-template-rows:70px 25px 25px 80px;
  padding:5px;
}
 .profile-card-avatar{
   grid-area:1/1/2/2;
  width:46px;
  height:46px;
   border-radius: 50%;
  background-color:#3db4ff;
   display:inline;
   place-self:center;
}
.relation{
  padding:6px;
  grid-area:1/2/2/3;
   place-self:center;
  background-color:#4ab3f4;
}
.relation:hover{
  background-color:#e85a71;
}
.profile-card-user-nicename{
  grid-area:2/1/3/2;
  place-self:center;
}
.profile-card-user-login{
  grid-area:3/1/4/2;
  font-size:12px;
  place-self:center;
}
.sign{
  grid-area:4/1/5/3;
   color:#14171a;
  font-size:14px;
}
hr{
  border: 0px;
    height: 1px;
    background-image: linear-gradient(to right, rgba(0, 0, 0, 0), rgba(0, 0, 0, 0.75), rgba(0, 0, 0, 0));
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
      <div class="profile-canopy-nav">
        <div class="profile-canopy"></div>
        <div class="user-avatar"></div>
        <div class="user-nav">
         <input class="user-search" placeholder="查找用户..." type="text" name="user_login" value=""/>
         <a href="#" class="nav-following">Following</a>
         <a href="#" class="nav-follower">Followers</a>
        </div>
       </div>
      
      <div class="user-info">
        <a>${user.user_nicename}</a>
        <a><span>@${user.user_login}</span></a>
        <p>Never give up the pursuit of learning</p>
        <p><span class="user-date">Joined&nbsp;since ${user.user_registered}</span></p>
      </div>
      
      <div class="user-count">
        <p><a>TalkCount<br><span>{user.user_tcount}</span></a></p>
        <p><a>BlogCount<span>{user.user_tcount}</span></a></p>
        <p><a>VoteCount<span>{user.user_tcount}</span></a></p>
        <p><a>LikeCount<span>{user.user_tcount}</span></a></p>
      
      </div>
      <div class="user-following">
        <div class="profile-card">
          <div class="profile-card-avatar"></div>
          <a class="relation">relation</a>
          <a class="profile-card-user-nicename">${user.user_nicename}</a>
          <a class="profile-card-user-login"><span>@${user.user_login}</span></a>
          <p class="sign">Never give up the pursuit of learning </p>
        </div>
        
     </div>
     <div class="user-follower">
        <div class="profile-card">
          <div class="profile-card-avatar"></div>
          <a class="relation">relation</a>
          <a class="profile-card-user-nicename">${user.user_nicename}</a>
          <a class="profile-card-user-login"><span>@${user.user_login}</span></a>
          <p class="sign">Never give up the pursuit of learning </p>
        </div>
     </div>
    </div>
</body>
</html>