<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.min.css">
<script src="${pageContext.request.contextPath }/js/jquery-1.12.2.min.js"></script>
<script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/print.css">
<title>Insert title here</title>
</head>

<body>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header"></div>
			<ul class="nav navbar-nav">
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Task <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="${pageContext.request.contextPath }/task?method=taskList">view tasks</a></li>
						<li><a href="${pageContext.request.contextPath }/task?method=createTask">create a task</a></li>
					</ul></li>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Performance <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="${pageContext.request.contextPath }/task?method=unfinishedTasks">unfinished tasks</a></li>
						<li><a href="${pageContext.request.contextPath }/task?method=finishedTask">finished tasks</a></li>
					</ul></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				welcome to ${userName}
				<a href="task?method=logout"><button type="button" class="btn btn-primary">logout</button></a>
			</ul>
		</div>
	</nav>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-6">
				<c:if test="${not empty include}">
					<c:catch var="e">
						<jsp:include page="${include}"></jsp:include>
					</c:catch>
					<c:if test="${not empty e}">
					</c:if>
				</c:if>
			</div>
			<div class="col-md-3"></div>
		</div>
	</div>
</body>
</html>