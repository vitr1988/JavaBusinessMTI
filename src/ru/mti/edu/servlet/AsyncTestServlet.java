package ru.mti.edu.servlet;

import java.io.IOException;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AsyncTestServlet
 */
//@WebServlet(asyncSupported = true, urlPatterns = { "/AsyncTestServlet" })
public class AsyncTestServlet extends HttpServlet { 
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final AsyncContext context = request.startAsync(request, response);
		context.start(
			new Runnable() {
				@Override
				public void run() {
					try {
						Thread.sleep(5 * 1000);
						context.getResponse().getWriter().append("Served at: ").append("Hello World");
					} catch (InterruptedException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
					finally {
						context.complete();
					}
				}
			});
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
