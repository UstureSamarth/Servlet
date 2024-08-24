package in.app.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/test2")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String accType = request.getParameter("accType");
		String accBranch = request.getParameter("accBranch");

		HttpSession session = request.getSession();
		session.setAttribute("accBranch", accBranch);
		session.setAttribute("accType", accType);

		PrintWriter out = response.getWriter();
		out.println("<table>");
		out.println("<form action='"+response.encodeURL("./test3")+"'>");
		out.println("<tr><th>Depositor Name</th><td><input type='text' name='dName'/></td></tr>");
		out.println("<tr><th>Deposit Amount</th><td><input type='number' name='amount'/></td></tr>");
		out.println("<tr><th></th><td><input type='submit' value='Next'/></td></tr>");
		out.println("</form>");
		out.println("</table>");

		out.close();

	}

}
