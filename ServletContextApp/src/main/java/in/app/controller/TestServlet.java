package in.app.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
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
		ServletContext context=getServletContext();
		response.setContentType("text/html");
		
		context.setAttribute("Name", "Samarth");
		context.setAttribute("Last Name", "Usture");
		
		PrintWriter out=response.getWriter();
		out.println("<html><head><title>Output Page</title>"
				+ "</head><body><table border='1'><tr><th>Parameter Name</th><th>Parameter Value</th></tr>");
		
		Enumeration<String> paramNames=context.getInitParameterNames();
		while(paramNames.hasMoreElements()) {
			String paramName=(String)paramNames.nextElement();
			String paramValue=context.getInitParameter(paramName);
			out.println("<tr>");
			out.println("<td>"+paramName+"</td><td>"+paramValue+"</td>");
			out.println("</td>");
			out.println("</tr>");
		}
		out.println("<tr><th>Attribute Name</th><th>Attribute Value</th></tr>");
		Enumeration<String> attributeNames=context.getAttributeNames();
		while(attributeNames.hasMoreElements()) {
			String attributeName=(String)attributeNames.nextElement();
			Object attributeValue=context.getAttribute(attributeName);
			out.println("<tr>");
			out.println("<td>"+attributeName+"</td><td>"+attributeValue+"</td>");
			out.println("</td>");
			out.println("</tr>");
		}
		out.print("</table>");
		
		out.print("</body></html>");
		
	}

}
