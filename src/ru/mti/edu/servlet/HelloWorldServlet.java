package ru.mti.edu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class HelloWorldServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().println("Path Info:" + req.getPathInfo().split("/")[1] + "<br>");
		resp.getWriter().println("Request URL:" + req.getRequestURL().toString() + "<br>");
		resp.getWriter().println("Request URI:" + req.getRequestURI() + "<br>");
		resp.getWriter().append(getServletContext().getInitParameter("initContextParam") + "<br>"); //initContextParam
		resp.getWriter().println("HelloWorld Servlet:" + req.getContextPath());
		
		HttpSession session = req.getSession();
		session.setAttribute("attr", "Hello World was visited");
	}
}
