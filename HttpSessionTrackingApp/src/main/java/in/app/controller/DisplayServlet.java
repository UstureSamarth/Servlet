package in.app.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/test3")
public class DisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");

		HttpSession session = request.getSession();
		session.setAttribute("email", email);
		session.setAttribute("mobile", mobile);
		
//		Enumeration<String> attributeNames = session.getAttributeNames();

		PrintWriter out = response.getWriter();
		out.println("<table border='1'>");
		/*
		 * while (attributeNames.hasMoreElements()) { String name =
		 * attributeNames.nextElement(); String value = (String)
		 * session.getAttribute(name); out.println("<tr>"); out.println("<th>" + name);
		 * out.println("</th>"); out.println("<td>" + value); out.println("</td>");
		 * out.println("</tr>"); }
		 */
		Object name=session.getAttribute("name");
		Object age=session.getAttribute("age");
		Object qual=session.getAttribute("qual");
		Object design=session.getAttribute("design");
		Object uemail=session.getAttribute("email");
		Object umobile=session.getAttribute("mobile");
		
		out.println("<tr><th>Name</th><td>"+name+"</td></tr>");
		out.println("<tr><th>Age</th><td>"+age+"</td></tr>");
		out.println("<tr><th>Qualification</th><td>"+qual+"</td></tr>");
		out.println("<tr><th>Designation</th><td>"+design+"</td></tr>");
		out.println("<tr><th>Email</th><td>"+uemail+"</td></tr>");
		out.println("<tr><th>Mobile</th><td>"+umobile+"</td></tr>");

		out.println("</table>");
		
		out.close();

	}

}
