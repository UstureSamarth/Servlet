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


@WebFilter("/test1")
public class DemoFilter extends HttpFilter implements Filter {

	private static final long serialVersionUID = 1L;

	static {
		System.out.println("DemoFilter Loading...");
	}
	public DemoFilter() {
		System.out.println("DemoFilter Instantiation...");
    }

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		PrintWriter out=response.getWriter();
		out.println("<h1>This line added by demo filter before processing the request</h1>");
		chain.doFilter(request, response);
		out.println("<h1>This line added by demo filter after processing the request</h1>");
	}

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("DemoFilter initialized...");
	}

}
