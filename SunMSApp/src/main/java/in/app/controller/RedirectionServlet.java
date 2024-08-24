package in.app.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/redirect")
public class RedirectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/*
		 * PrintWriter out = response.getWriter(); response.setContentType("text/html");
		 * out.println("<html>"); out.println("<head>"); out.println("<title>Output");
		 * out.println("</title>"); out.println("</head>"); out.println("<body>");
		 * out.println("<font color='red'>");
		 * out.println("<h1>To get services of Java click on below link...");
		 * out.println("</h1>"); out.println("</font>"); out.
		 * println("<a href='http://localhost:1990/OracleApp/index.html'>CC@WWW.oracleproducts</a>"
		 * ); out.println("</body>"); out.println("</html>"); out.close();
		 */
		String location="http://localhost:1990/OracleApp/index.html";
		response.sendRedirect(location);
		
	}

}
