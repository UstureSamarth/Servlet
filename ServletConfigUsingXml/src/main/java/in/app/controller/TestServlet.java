package in.app.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static {
		System.out.println("Servlet Loading");
	}

	public TestServlet() {
		System.out.println("Servlet Instantiation");
	}

	public void init() throws ServletException {
		System.out.println("Servlet Initialization");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletConfig config=getServletConfig();
		response.setContentType("text/html");
		
		PrintWriter out=response.getWriter();
		out.println("<html><head><title>Output Page</title>"
				+ "</head><body><table border='1'><tr><th>Parameter Name</th><th>Parameter Value</th></tr>");
		
		Enumeration<String> paramNames=config.getInitParameterNames();
		while(paramNames.hasMoreElements()) {
			String paramName=(String)paramNames.nextElement();
			String paramValue=config.getInitParameter(paramName);
			out.println("<tr>");
			out.println("<td>"+paramName+"</td><td>"+paramValue+"</td>");
			out.println("</td>");
			out.println("</tr>");
		}
		
		out.print("</table>");
		
		out.print("</body></html>");
		
	}

}