<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>Edit task </title>
<h1>Edit task</h1>
  <form action="${pageContext.request.contextPath }/task?method=saveEditTask&taskId=${form.taskId}" method="post" name="create">
      <p>
           task title:<br><input class="form-control" name="title" value="${form.title}"><br>
          task time:<br><input class="form-control" name="time" value="${form.time}"> <br>
           task detail:<br><input class="form-control" name="detail" value="${form.detail}"><br>
      </p>
      <p><input type="submit" class="btn btn-default" value="Save"></p>
  </form>