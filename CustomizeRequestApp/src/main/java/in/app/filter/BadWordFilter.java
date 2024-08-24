package in.app.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.app.customization.CustomizedRequest;
import in.app.customization.CustomizedResponse;


@WebFilter("/test")
public class BadWordFilter extends HttpFilter implements Filter {
       

	private static final long serialVersionUID = 1L;


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		CustomizedRequest req1=new CustomizedRequest((HttpServletRequest)request);
		CustomizedResponse res1 = new CustomizedResponse((HttpServletResponse) response);
		chain.doFilter(req1, res1);
		res1.flushBuffer();
	}


	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
