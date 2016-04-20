package ru.mti.edu.servlet;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LearningServlet
 */
//@WebServlet("/")
public class LearningServlet extends HttpServlet {

	private ServletConfig config;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		this.config = config;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("Windows-1251");
		response.setContentType("text/html; charset=Windows-1251"); 
		String value = this.config.getInitParameter("key");
		if (request.getParameter("p") != null){
			value = request.getParameter("p"); 
		}
		response.getWriter().append(value); //initContextParam
		response.getWriter().append(getServletContext().getInitParameter("initContextParam")); //initContextParam
//		response.getWriter().append("Learning Servlet:" + value);
		Object obj = request.getSession().getAttribute("attr");
		if (obj != null){
			response.getWriter().append(obj.toString());
		}
		else {
			response.getWriter().append("Запроса не было!");
		}
		request.getSession().getId();
		request.getSession().setMaxInactiveInterval(10);
		
		Cookie cokie = new Cookie("cookieName", "cookieValue");
		cokie.setPath("/");
		response.addCookie(cokie);
//		ServletOutputStream out = response.getOutputStream();
		
		
		response.getWriter().close();
	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}
	
	
	@Override
	public void destroy(){
		
	}

//	@Override
//	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
//		if (arg0 instanceof HttpServletRequest)
//		switch(((HttpServletRequest) arg0).getMethod()){
//			case "get" : doGet((HttpServletRequest) arg0, (HttpServletResponse) arg0); break;
//			case "post" : doPost((HttpServletRequest) arg0, (HttpServletResponse) arg0); break;
//			case "put" : doPut((HttpServletRequest) arg0, (HttpServletResponse) arg0); break;
//		}
//	}

}
