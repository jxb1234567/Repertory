package com.todo.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sqlite.util.StringUtils;

import com.todo.db.OpSqliteDB;
import com.todo.entity.Task;
import com.todo.entity.User;
import com.todo.service.TaskService;
import com.todo.service.UserService;

/**
 * Servlet implementation class TaskServlet
 */
public class TaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private TaskService taskService;
	private UserService userService;
	
	@Override
	public void init() throws ServletException {
		super.init();
		if(null == taskService){
			taskService = new TaskService();
		}
		if(null == userService){
			userService = new UserService();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = request.getParameter("method");
		try {
			request.setCharacterEncoding("UTF-8");
			if("taskList".equals(method)){
				List<Task> taskList = taskService.taskList();
				request.setAttribute("taskList", taskList);
				request.setAttribute("include", "todo/task_list.jsp");
				this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
			}else if("editTask".equals(method)){
				String taskId = request.getParameter("taskId");
				Task task = taskService.editTask(taskId);
				request.setAttribute("form", task);
				request.setAttribute("include", "todo/edit_task.jsp");
				this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
			}else if("createTask".equals(method)){
				Task task = new Task();
				request.setAttribute("form", task);
				request.setAttribute("include", "todo/create_task.jsp");
				this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
			}else if("unfinishedTasks".equals(method)){
				List<Task> taskList = taskService.unfinishedTasks();
				request.setAttribute("tasks", taskList);
				request.setAttribute("include", "todo/task_unfinished_list.jsp");
				this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
			}else if("finishedTask".equals(method)){
				List<Task> taskList = taskService.finishedTask();
				request.setAttribute("tasks", taskList);
				request.setAttribute("include", "todo/task_finished_list.jsp");
				this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
			}else if("saveAddTask".equals(method)){
				String title = request.getParameter("title");
				String time = request.getParameter("time");
				String detail = request.getParameter("detail");
				taskService.saveAddTask(title, time, detail);
				List<Task> taskList = taskService.taskList();
				request.setAttribute("taskList", taskList);
				request.setAttribute("include", "todo/task_list.jsp");
				this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
			}else if("saveEditTask".equals(method)){
				String taskId = request.getParameter("taskId");
				String title = request.getParameter("title");
				String time = request.getParameter("time");
				String detail = request.getParameter("detail");
				taskService.saveEditTask(taskId, title, time, detail);
				List<Task> taskList = taskService.taskList();
				request.setAttribute("taskList", taskList);
				request.setAttribute("include", "todo/task_list.jsp");
				this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
			}else if("deleteTask".equals(method)){
				String taskId = request.getParameter("taskId");
				taskService.deleteTask(taskId);
				List<Task> taskList = taskService.taskList();
				request.setAttribute("taskList", taskList);
				request.setAttribute("include", "todo/task_list.jsp");
				this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
			}else if("doneTask".equals(method)){
				String taskId = request.getParameter("taskId");
				taskService.doneTask(taskId);
				List<Task> taskList = taskService.taskList();
				request.setAttribute("taskList", taskList);
				request.setAttribute("include", "todo/task_list.jsp");
				this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
			}else if("logout".equals(method)){
				request.getSession().invalidate();
				this.getServletContext().getRequestDispatcher("/todo/login.jsp").forward(request, response);
			}else if("register".equals(method)){
				this.getServletContext().getRequestDispatcher("/todo/register.jsp").forward(request, response);
			}else if("registerSave".equals(method)){
				User user = new User();
				user.setUserName(request.getParameter("userName"));
				user.setLoginName(request.getParameter("loginName"));
				user.setPassword(request.getParameter("password"));
				userService.registerSave(user);
				request.getSession().invalidate();
				this.getServletContext().getRequestDispatcher("/todo/login.jsp").forward(request, response);
			}else if("login".equals(method)){
				String loginName = request.getParameter("loginName");
				String password = request.getParameter("password");
				// 执行查询语句
		        ResultSet rs = OpSqliteDB.execQuerySql("select * from user where loginName ='"+loginName+"' and password='"+ password +"'");
		        if(rs.next()){
		        	request.getSession().setAttribute("login",loginName);
		        	List<Task> taskList = taskService.taskList();
					request.setAttribute("taskList", taskList);
					request.setAttribute("include", "todo/task_list.jsp");
					this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		        }else{
		        	this.getServletContext().getRequestDispatcher("/todo/login.jsp").forward(request, response);
		        }
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	

}
