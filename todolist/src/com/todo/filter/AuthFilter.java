package com.todo.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class AuthFilter implements Filter {

	/**
	 * 静态资源根目录
	 */
	private static final String RESOURCES_ROOT_JS = "/js/";
	private static final String RESOURCES_ROOT_CSS = "/css/";
	
	private List<String> noCheckList;
	
	public void destroy() {

	}

	public void doFilter(ServletRequest servletRequest,
			ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;

		String currentURL = request.getRequestURI();
		HttpSession session = request.getSession(false);
		String method = request.getParameter("method");
		if (!currentURL.startsWith(request.getContextPath() + RESOURCES_ROOT_JS) && 
				!noCheckList.contains(currentURL.replaceFirst(request.getContextPath(), ""))
				&& !currentURL.startsWith(request.getContextPath() + RESOURCES_ROOT_CSS)
				&& !"login".equals(method)&& !"register".equals(method) && !"registerSave".equals(method)) {
			if (session == null || session.getAttribute("login") == null) {
				/**
				 * 未登录时，跳转到登录界面
				 */
				response.sendRedirect(request.getContextPath() + "/todo/login.jsp");
				return;
			}
		}
		filterChain.doFilter(request, response);
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		// 不需要授权的url list
		noCheckList = new ArrayList<String>();
		noCheckList.add("/todo/login.jsp");
		noCheckList.add("/todo/register.jsp");
	}
}
