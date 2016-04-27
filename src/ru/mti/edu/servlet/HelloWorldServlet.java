package ru.mti.edu.servlet;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.SingleThreadModel;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class HelloWorldServlet extends HttpServlet {

	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (Integer.toString(1).equals(req.getParameter("redirect"))){
			resp.sendRedirect("index.htm");
			return;
		}
		else if (Integer.toString(2).equals(req.getParameter("redirect"))){
			RequestDispatcher dispatcher = req.getRequestDispatcher("/Learning");
			req.setAttribute("testParam", "testParam");
			dispatcher.forward(req, resp);
			return;
		}
		else if (Integer.toString(3).equals(req.getParameter("redirect"))){
			try {
				Thread.sleep(5 * 1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		String pathInfo = req.getPathInfo();
		if (pathInfo != null)
		resp.getWriter().println("Path Info:" + pathInfo.split("/")[1] + "<br>");
		resp.getWriter().println("Request URL:" + req.getRequestURL().toString() + "<br>");
		resp.getWriter().println("Request URI:" + req.getRequestURI() + "<br>");
		resp.getWriter().append(getServletContext().getInitParameter("initContextParam") + "<br>"); //initContextParam
		resp.getWriter().println("HelloWorld Servlet:" + req.getContextPath());
		
		HttpSession session = req.getSession();
		session.setAttribute("attr", "Hello World was visited");
		session.setAttribute("attr", "Hello World was visited");
		session.removeAttribute("attr");
	}
	
	public void print(Writer out, String str){
		try {
		 	out.append(str);
		}
		catch(IOException e){
		}
	}
}
