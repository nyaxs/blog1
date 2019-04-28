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
<title>Blog</title>
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
		grid-template-columns:10% 80% 10%;
		grid-template-rows:50px auto;
		grid-template-areas:'. header .'
							'. content .';
        grid-row-gap: 10px;
        justify-content:center;
	}
	.header{
	    display:grid;
	    grid-area:header;
        grid-template-columns:repeat(12,1fr);
		background-color: #ffffff;
        align-items:center;
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
  grid-area:content;
  justify-content:center;
  width:1200px;
  height:600px;
  grid-template-columns:repeat(12,1fr);
  
}
.blog-list{
  grid-area:1/1/2/5;
  overflow:hidden;
}
.blog-list li{
	padding:4px;
}
.blog-editor{
  display:grid;
  grid-area:1/5/2/13;
  grid-template-columns:50%;
  grid-template-rows:30px 40px auto;
  min-width:560px;
  padding:12px;
  padding-top:14px;
}
.editor-form{
   display:grid;
    width:560px;
}
.blog-editor textarea{
  width:560px;
  height:600px;
}
.editor-title{
  justify-self:center;
  height:30px;
		width: 560px;
		border: 0;
		border-bottom: 1.5px solid #fec8c9;
		background-image: none;
		background:transparent;
		outline: none;
		text-align:center;
}
.editor-title:focus{
  border-bottom: 3px solid #354385;
}
.editor-toolbar{
    display:grid;
  grid-template-columns:20% 80%;
  grid-template-rows:100%;
    width:560px;
  height:40px;
    padding-bottom:4px;
  justify-items:end;
  align-items:center;
}
.editor-publish{
   justify-self:start;
}
.editor-publish:hover{
  padding:4px;
  background-color:#3fb9ff;
}

.insert-options{
   display:grid;
   grid-template-columns:repeat(3,1fr);
}
.insert-options a:hover{
   background-color:#3fb9ff;
  padding:3px;
}
.insert-options a{
  padding:3px;
}
.editor-textarea{
  background: gradient(linear, 0% 20%, 0% 1000%, from(#fff), to(#fff), color-stop(.1,#f3f3f3));
  border-top: 2px solid #fec8c9;
  border-left:0px;
  border-right:0px;
  box-shadow: 0px 3px 30px rgba(0, 0, 0, 0.1) inset;
  border-bottom-right-radius: 6px 50px; 
}
.editor-textarea:focus{
  border-top: 2px solid #3db4ff;
  border-bottom: 2px solid #3db4ff;
  border-left:0px;
  border-right:0px;
  outline:none;
}
   textarea{
    	font-size:20px;
    }
textarea::-webkit-input-placeholder {
       color: #aab2bd;
       font-size: 20px;
    }
hr{
  border: 0;
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
      <div class="blog-list">
        <ul class="">
			<c:forEach items="${listPostByUser}" var="c" varStatus="st">
			
					<li><a href="blogDetail?postId=${c.id}"><i class="fa fa-moon-o"></i>&nbsp;${c.post_title}-${c.post_date}</a><hr/></li>
			</c:forEach>
        </ul>
      </div>
      <div class="blog-editor">
        <form action="postPublish" class="editor-form" method="post" id="postPublishForm">
        	<input type="text" class="editor-title" name="post_title" placeholder="输入标题" value="">
       		<input type="hidden" name="post_author" value="${user.id}">
        </form>
             
          <div class="editor-toolbar">
          	<a href="javascript:document:postPublishForm.submit();" class="editor-publish "><i class="fa fa-send-o"></i>&nbsp;nya~</a>
            <div class="insert-options">
			<a href="#">图片</a> 
            <a href="#">标签</a> 
            <a href="#">emoij</a> 
            </div>
		  </div>
        <textarea class="editor-textarea" id="editor-area" name="post_content" placeholder="Blog some ξ( ✿＞◡❛)" form="postPublishForm"></textarea>
      </div>
	</div>



	<div class="footer"></div>
</body>
</html>