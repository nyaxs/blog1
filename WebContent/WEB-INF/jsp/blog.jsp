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
  width:800px;
  grid-template-columns:repeat(12,1fr);
}
.blog-list{
  grid-area:1/1/2/5;
}
.blog-editor{
  display:grid;
  grid-area:1/4/2/13;
  grid-template-columns:repeat(12,1fr);
  grid-template-rows:50px auto;
}
.blog-editor textarea{
  width:600px;
  height:600px;
}


</style>
</head>

<body class="all-in-container">
	<div class="header">
      <a href="#" class="logo">Nya☆</a>
	    <div class="header-list">
			<a href="#">Home</a>
			<a href="#">Talk</a>
			<a href="#">Blog</a>
			<a href="#">Luck</a>
      </div>
      <a href="#" class="user-login-info">Login</a>
	</div>

	<div class="content">
      <div class="blog-list">
        <table align="center" border="1" cellspacing="0">
			<tr>
				<td>post_title</td>
				<td>post_content</td>
				<td>post_date</td>
				<td>post_type</td>
			</tr>
			<c:forEach items="${listPostByUser}" var="c" varStatus="st">
				<tr>
					<td>${c.post_title}</td>
					<td>${c.post_content}</td>
					<td>${c.post_date}</td>
					<td>${c.post_type}</td>
				</tr>
			</c:forEach>
		</table>
      </div>
      <div class="blog-editor">
        <form action="publishBlog" method="post">
        	标题<input type="text" name="post_title" value="">
          <div class="editor-toolbar">
			<a href="#">图片</a> 
            <a href="#">标签</a> 
            <a href="#">emoij</a> 
            <input id="publish-btn" type="submit" value="Publish" />
		  </div>
          <textarea id="editor-area"></textarea>
       		<input type="hidden" name="post_author" value="${user.id}">
        </form>
       </div>
	</div>



	<div class="footer"></div>
</body>
</html>