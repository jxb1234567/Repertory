package com.todo.service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.todo.db.OpSqliteDB;
import com.todo.entity.Task;


public class TaskService {
	
	public List<Task> taskList() throws Exception{
		List<Task> taskList = new ArrayList<Task>();
        // 执行查询语句
        ResultSet rs = OpSqliteDB.execQuerySql("select * from task");
        while (rs.next()) {
        	Task task = new Task();
			task.setTitle(rs.getString("title"));
			task.setTime(rs.getString("time"));
			task.setDetail(rs.getString("detail"));
			task.setState(rs.getString("isDone"));
			task.setTaskId(rs.getString("taskId"));
			taskList.add(task);
        }
        rs.close();
		return taskList;
	}
	public Task editTask(String taskId) throws Exception{
		ResultSet rs = OpSqliteDB.execQuerySql("select * from task where taskId='" + taskId + "'");
		Task task = new Task();
		task.setTitle(rs.getString("title"));
		task.setTime(rs.getString("time"));
		task.setDetail(rs.getString("detail"));
		task.setState(rs.getString("isDone"));
		task.setTaskId(rs.getString("taskId"));
		rs.close();
		return task;
	}
	public List<Task> unfinishedTasks() throws Exception{
		List<Task> taskList = new ArrayList<Task>();
		// 执行查询语句
        ResultSet rs = OpSqliteDB.execQuerySql("select * from task where isDone = 'unfinished'");
        while (rs.next()) {
        	Task task = new Task();
			task.setTitle(rs.getString("title"));
			task.setTime(rs.getString("time"));
			task.setDetail(rs.getString("detail"));
			task.setState(rs.getString("isDone"));
			task.setTaskId(rs.getString("taskId"));
			taskList.add(task);
        }
        rs.close();
        return taskList;
	}
	public List<Task> finishedTask() throws Exception{
		List<Task> taskList = new ArrayList<Task>();
		// 执行查询语句
        ResultSet rs = OpSqliteDB.execQuerySql("select * from task where isDone = 'finished'");
        while (rs.next()) {
        	Task task = new Task();
			task.setTitle(rs.getString("title"));
			task.setTime(rs.getString("time"));
			task.setDetail(rs.getString("detail"));
			task.setState(rs.getString("isDone"));
			task.setTaskId(rs.getString("taskId"));
			taskList.add(task);
        }
        rs.close();
        return taskList;
	}
	public boolean saveAddTask(String title,String time,String detail) throws Exception{
		OpSqliteDB.execUpdateSql("insert into task(title,detail,time,isDone) values('"+ title +"','"+ detail +"','"+ time +"','unfinished')");
		return true;
	}
	
	public boolean saveEditTask(String taskId,String title,String time,String detail) throws Exception{
		OpSqliteDB.execUpdateSql("update task set title = '"+title+"', time = '"+time+"', detail = '"+detail+"' where taskId = '"+taskId+"'");
		return true;
	}
	public boolean deleteTask(String taskId) throws Exception{
		OpSqliteDB.execUpdateSql("delete from task where taskId = '"+taskId+"'");
		return true;
	}
	public boolean doneTask(String taskId) throws Exception{
		OpSqliteDB.execUpdateSql("update task set isDone = 'finished' where taskId = '"+taskId+"'");
		return true;
	}
}
