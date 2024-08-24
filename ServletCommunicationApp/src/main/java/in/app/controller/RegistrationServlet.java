package in.app.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = request.getParameter("username");
		Integer age = Integer.parseInt(request.getParameter("age"));
		String city = request.getParameter("city");
		String country = request.getParameter("country");

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		if (age < 19 || age > 30) {
			response.sendError(504,"User age is not sufficient");
		} else {
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Output");
			out.println("</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<font color='red'>");
			out.println("<h2>User Registration Details");
			out.println("</h2>");
			out.println("</font>");
			out.println("<table border='1'>");
			out.println("<tr><td>User Name</td><td>" + userName + "</td></tr>");
			out.println("<tr><td>User Age</td><td>" + age + "</td></tr>");
			out.println("<tr><td>User City</td><td>" + city + "</td></tr>");
			out.println("<tr><td>User Country</td><td>" + country + "</td></tr>");
			out.println("<tr><td>Registration status</td><td>Registered Succesfully</td></tr>");
			out.println("</table>");
			out.println("</body>");
			out.println("</html>");
		}
	}

}
