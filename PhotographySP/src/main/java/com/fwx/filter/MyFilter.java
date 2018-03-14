package com.fwx.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MyFilter implements Filter {
	protected static String patterns = ".do";
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)throws IOException, ServletException {
			HttpServletRequest request = (HttpServletRequest) servletRequest;
	        HttpServletResponse response = (HttpServletResponse) servletResponse;
	        
	        String url = request.getRequestURI().substring(request.getContextPath().length());
	        if (url.startsWith("/") && url.length() > 1) {
	            url = url.substring(1);
	        }
	        if (isInclude(url)){
	            chain.doFilter(request, response);
	            return;
	        } else {
	            HttpSession session = request.getSession();
	            if (session.getAttribute("") != null){
	                // session存在
	                chain.doFilter(request, response);
	                return;
	            } else {
	                // session不存在 准备跳转失败
	                /* RequestDispatcher dispatcher = request.getRequestDispatcher(path);
	                    dispatcher.forward(request, response);*/
	                chain.doFilter(request, response);
	                return;
	            }
	        }

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}
	
	 /**
     * 是否需要过滤
     * @param url
     * @return
     */
    private boolean isInclude(String url) {
      if(".do".equals(url)){    
                return true;
           
      }
        return false;
    }
}
