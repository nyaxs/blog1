<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>WelcomeUser</title>
</head>
<body>
	<div>
		<h2>登录信息</h2>
		<table>
			<tr>
				<td>名称：</td>
				<td>${user.user_login}</td>
			</tr>
			<tr>
				<td>密码：</td>
				<td>${user.user_pass}</td>
			</tr>
			<tr>
				<td>id：</td>
				<td>${user.id}</td>
			</tr>
		</table>
	</div>
	<div></div>
	<div>
		<h2>发布文章</h2>
		<form action="postIssue" method="post">

			<table align="center">
				<tr>
					<td>post_title：</td>
					<td><input type="text" name="post_title" value=""></td>
				</tr>
				<tr>
					<td>post_content：</td>
					<td><textarea rows="30" cols="100" wrap="hard"
							name="post_content"></textarea></td>
				</tr>
				<tr>
					<td>post_type：</td>
					<td><input type="text" name="post_type" value=""></td>
				</tr>
				<tr>
					<td><input type="hidden" name="post_author" value="${user.id}"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="postIssue" /></td>
				</tr>
			</table>
		</form>
	</div>

	<div>
		<h2>Your Posts</h2>
		<form action="listPostsByUser" method="post">
			<table>
				<tr>
					<td><input type="hidden" name="user_login" value="${user.id}"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="查看你的Posts" /></td>
				</tr>
			</table>
		</form>
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
</body>
</html>