package in.app.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;


@WebFilter("/test1")
public class LogFilter extends HttpFilter implements Filter {

	private FilterConfig config;
	private static final long serialVersionUID = 1L;

	static {
		System.out.println("Logfilter Loading...");
	}
	public LogFilter() {
		System.out.println("Logfilter Instantiation...");
    }

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		PrintWriter out=response.getWriter();
		out.println("<h1>This line added by log filter before processing the request</h1>");
		
		ServletContext context=config.getServletContext();
		HttpServletRequest req1=(HttpServletRequest)request;
		context.log("Request is coming from "+req1.getRemoteHost()+" at date "+new Date());
		chain.doFilter(request, response);
		out.println("<h1>This line added by log filter after processing the request</h1>");
	}

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("Logfilter initialized...");
		this.config=fConfig;
	}

}
