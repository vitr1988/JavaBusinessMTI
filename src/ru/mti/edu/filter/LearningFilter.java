package ru.mti.edu.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * Servlet Filter implementation class LearningFilter
 */
@WebFilter("/*")
public class LearningFilter implements Filter {

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		ServletRequest newRequest = null;
		if (request instanceof HttpServletRequest){
			HttpServletRequest req = (HttpServletRequest) request;
			String uri = req.getRequestURI();
			final String[] uriParts =  uri.split("/");
			if (uriParts.length > 3){
				String firstPart = uriParts[2];
				if ("hello".equalsIgnoreCase(firstPart)){
					newRequest = new HttpServletRequestWrapper(req){
						@Override
						public String getParameter(String name) {
							if ("p".equalsIgnoreCase(name)){
								return uriParts[3];
							}
							return super.getParameter(name);
						}
						
					};
				}
			}
		}
		chain.doFilter(newRequest != null ? newRequest : request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
