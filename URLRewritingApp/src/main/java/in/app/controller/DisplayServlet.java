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

		String dName = request.getParameter("dName");
		String amount = request.getParameter("amount");  
		HttpSession session = request.getSession();
		Object accNo = session.getAttribute("accNo");
		Object accName = session.getAttribute("accName");
		Object accType = session.getAttribute("accType");
		Object accBranch = session.getAttribute("accBranch");

		PrintWriter out = response.getWriter();
		out.println("<table border='1'>");
		out.println("<tr><th>Account Number</th><td>" + accNo + "</td></tr>");
		out.println("<tr><th>Account Name</th><td>" + accName + "</td></tr>");
		out.println("<tr><th>Account Type</th><td>" + accType + "</td></tr>");
		out.println("<tr><th>Account Brach</th><td>" + accBranch + "</td></tr>");
		out.println("<tr><th>Depositor Name</th><td>" + dName + "</td></tr>");
		out.println("<tr><th>Deposit Amount</th><td>" + amount + "</td></tr>");
		out.println("</table>");

		out.close();

	}

}
