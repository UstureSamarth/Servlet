package in.app.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/test2")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		Enumeration<String> attribiteNames=request.getAttributeNames();
		out.println("<table border='1'>");
		out.println("<tr><th>Name</th><th>Value</th></tr>");
        while(attribiteNames.hasMoreElements()) {
        	String name=(String)attribiteNames.nextElement();
        	Object value=request.getAttribute(name);
        	out.println("<tr><td>"+name+"</td><td>"+value+"</td></tr>");
        }
        out.println("</table>");
	}

}
