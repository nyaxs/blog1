<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Login</title>
    <style scoped>
    body{
    	background-image: url("image/bg-login.jpg");
		background-repeat: no-repeat;
		background-size:cover;
    }
		li{
			border:1px solid transparent;
			margin-top: 30px;
			list-style: none;
			text-align: center;
			font-size:20px;
		}
	input{
		height: 3em;
		width: 20em;
		border: 0;
		border-bottom: 3px solid #fec8c9;
		background-image: none;
		background:transparent;
		outline: none;
		text-align:center;
	}
	label{
		color: #515a6e;
		font-size:20px;
	}
	.btn{
		outline: none;
		border: 1px solid transparent;
		border-radius: 4px;
		background-color: transparent;
		color: #515a6e;
		transition: color .2s linear,background-color .2s linear;
		width: 4em;
		height: 2em;
		font-size: 1.5em;
	}
	.btn:hover{
		color: #fec8c9;
		background-color: #847467;
	}
	.container {
		display: flex;
		justify-content: center;
		align-items: center;
		height: 100%;
		font-size: 1.5em;
		
	}

</style>

<script type="text/javascript">
	window.onload=function(){
		alert("输入用户名、密码即可直接注册并登录");
	}
</script>

</head>
<body>

<div class="container"><Row>
        
			<form action="userLogin" method="post">
				<ul>
					<li><input placeholder="UserName" type="text" name="user_login" value=""/></li>
					<li><input placeholder="PassWord"  type="password" name="user_pass" value=""/></li> 
					<br>
					<li><button  type="submit" class="btn">Log In</Button></li>
				</ul>
			</form>

	</div>
</body>
</html> 