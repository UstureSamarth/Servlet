package in.app.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

@WebFilter("/demo")
public class DemoFilter extends HttpFilter implements Filter {

	
	private static final long serialVersionUID = 1L;
	
	static {
		System.out.println("Filter object is loaded");
	}
	public DemoFilter() {
		System.out.println("Filter object is instantiated");
	}

	public void destroy() {
		System.out.println("Filter object is destroyed");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// filter pre-processing
		PrintWriter out=response.getWriter();
		out.println("<h1>Demo servlet before processing the request</h1>");
		chain.doFilter(request, response);
//		filter post-processing
		out.println("<h1>Demo servlet after processing the request</h1>");
	}

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("Filter object is initialized");
	}

}
