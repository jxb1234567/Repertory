<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>finished task's List </title>
<h2>finished task's List </h2>
<table class="table">
    <thead>
      <tr>
        <th>title</th>
        <th>time</th>
        <th>detail</th>
      </tr>
    </thead>
    <tbody>


    <c:forEach var="task" items="${tasks}">
	    <tr>
	      <td>${task.title}</td>
	      <td>${task.time}</td>
	      <td>${task.detail}</td>
	    </tr>
    </c:forEach>
  </tbody>
</table>