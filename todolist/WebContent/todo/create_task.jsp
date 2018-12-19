<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>create a task </title>
<h1>Create a Task</h1>
  <form action="${pageContext.request.contextPath }/task?method=saveAddTask" method="post" name="create">
      <p>
          task title:<br><input class="form-control" name="title" value="${form.title}"> <br>
          task time:<br><input id="date" class="form-control" name="time" value="${form.time}"> <br>
          task detail:<br><input class="form-control" name="detail" value="${form.detail}"> <br>

      </p>
      <p><input type="submit" value="Create task"></p>
  </form>
  
  <script type="text/javascript">
  window.onload=function(){
	  $('#date').datepicker({
	        weekStart: 1,
	        autoclose: true,
	        daysOfWeekHighlighted: "0,6",
	        format: "yyyy/mm/dd",
	        language: "zh-CN"
	    });
  }
   
    </script>