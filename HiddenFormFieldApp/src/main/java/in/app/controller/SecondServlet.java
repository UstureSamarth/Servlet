package in.app.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test2")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String sid = request.getParameter("sid");
		String sname = request.getParameter("sname");
		String saddress = request.getParameter("saddress");
		String sage = request.getParameter("sage");

		PrintWriter out = response.getWriter();
		out.println("<table>");
		out.println("<form action='./test3'>");
		out.println("<input type='hidden' name='sid' value='"+sid+"'/>");
		out.println("<input type='hidden' name='sname' value='"+sname+"'/>");
		out.println("<input type='hidden' name='saddress'value='"+saddress+"'/>");
		out.println("<input type='hidden' name='sage'value='"+sage+"'/>");
		out.println("<tr><th>School Address</th><td><input type='text' name='saddr'/></td></tr>");
		out.println("<tr><th></th><td><input type='submit' value='Next'/></td></tr>");
		out.println("</form>");
		out.println("</table>");

		out.close();

	}

}
