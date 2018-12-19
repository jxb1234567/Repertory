<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>task list </title>
<table class="table">
	<thead>
		<tr>
			<th>title</th>
			<th>time</th>
			<th>detail</th>
			<th>state</th>
			<th></th>
			<th></th>
			<th></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="task" items="${taskList}">
			<tr>
				<td>${task.title}</td>
				<td>${task.time}</td>
				<td>${task.detail}</td>
				<td>${task.state}</td>
				<td><a href="${pageContext.request.contextPath }/task?method=doneTask&taskId=${task.taskId}"><button
							type="button" class="btn btn-primary">finished</button></a></td>
				<td><a href="${pageContext.request.contextPath }/task?method=editTask&taskId=${task.taskId}"><button
							type="button" class="btn btn-primary">Edit</button></a></td>
				<td><a href="${pageContext.request.contextPath }/task?method=deleteTask&taskId=${task.taskId}"><button
							type="button" class="btn btn-primary">Delete</button></a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>