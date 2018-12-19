<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.min.css">
<script src="${pageContext.request.contextPath }/js/jquery-1.12.2.min.js"></script>
<script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/print.css">
<title>register</title>
</head>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-6">
			<h1>register</h1>
			  <form action="${pageContext.request.contextPath }/task?method=registerSave" method="post" name="register" style="">
			      <p>
			          user name:<br><input class="form-control" name="userName" id="userName" value="${user.userName}"> <br>
			          login name:<br><input class="form-control" name="loginName"" id="loginName" value="${user.loginName}"> <br>
			          password:<br><input type="password" class="form-control" name="password" id="password" value="${user.password}"> <br>
			
			      </p>
			      <p><input type="submit" value="register" style="width:80px"/></p>
			      <p><a href="task?method=logout"><input type="button" value="login" style="color: black;width:80px"/></a></p>
			  </form>
			</div>
			<div class="col-md-3"></div>
		</div>
	</div>
