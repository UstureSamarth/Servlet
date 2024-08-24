package in.app.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test3")
public class DisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String sid = request.getParameter("sid");
		String sname = request.getParameter("sname");
		String saddress = request.getParameter("saddress");
		String sage = request.getParameter("sage");
		String saddr = request.getParameter("saddr");

		PrintWriter out = response.getWriter();
		out.println("<table border='2'>");
		out.println("<tr><th>Student Id</th><td>"+sid+"</td></tr>");
		out.println("<tr><th>Student Name</th><td>"+sname+"</td></tr>");
		out.println("<tr><th>Student Address</th><td>"+saddress+"</td></tr>");
		out.println("<tr><th>Student Age</th><td>"+sage+"</td></tr>");
		out.println("<tr><th>School Address</th><td>"+saddr+"</td></tr>");
		out.println("</table>");

		out.close();

	}

}
