<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.min.css"> 
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/print.css" >
<script src="${pageContext.request.contextPath }/js/jquery-1.12.2.min.js"></script>
<script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
<title>login</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-6">
			<h1>login</h1>
			  <form action="${pageContext.request.contextPath }/task?method=login" method="post" name="login" style="">
			      <p>
			          login name:<br><input class="form-control" name="loginName" value="${user.loginName}"> <br>
			          password:<br><input class="form-control"name="password" value="${user.password}"> <br>
			          <label>${user.msg }</label><br>
			
			      </p>
			      <p><input type="submit" value="login" style="width:80px"/></p>
			      <p><a href="${pageContext.request.contextPath }/task?method=register"><input type="button" value="register" style="color: black;width:80px"/></a></p>
			  </form>
			</div>
			<div class="col-md-3"></div>
		</div>
	</div>
</body>

