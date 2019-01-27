<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Welcome to Nyaxs</title>
</head>
<body>
<div>
	<h2>All the Posts</h2>
	<table align="center" border="1" cellspacing="0">
    <tr>
        <td>post_title</td>
        <td>post_content</td>
        <td>post_date</td>
        <td>post_type</td>
        <td>post_author</td>
    </tr>
    <c:forEach items="${listPostAll}" var="c" varStatus="st">
        <tr>
            <td>${c.post_title}</td>
            <td>${c.post_content}</td>
             <td>${c.post_date}</td>
             <td>${c.post_type}</td>
             <td>${c.post_author}</td>
        </tr>
    </c:forEach>
</table>
</div>

<div>
<h2>UserLogin</h2>
<form action="userLogin" method="post">
 <table>
    <tr>
        <td>user_login ：</td>
        <td><input type="text" name="user_login" value=""></td>
    </tr>
    <tr>
        <td>user_pass：</td>
        <td><input type="password" name="user_pass" value=""></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="Login"/>
        </td>
    </tr>
</table>  
</form>
</div>
<div>
<h2>UserRegister</h2>
 <form action="userRegister" method="post">
 <table>
    <tr>
        <td>user_login：</td>
        <td><input type="text" name="user_login" value=""></td>
    </tr>
    <tr>
        <td>user_pass：</td>
        <td><input type="password" name="user_pass" value=""></td>
    </tr>
    <tr>
        <td>user_nicename：</td>
        <td><input type="text" name="user_nicename" value=""></td>
    </tr>
    <tr>
        <td>user_email：</td>
        <td><input type="text" name="user_email" value=""></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="Register"/>
        </td>
    </tr>
   
</table>  
</form>
</div>
</body>
</html> 