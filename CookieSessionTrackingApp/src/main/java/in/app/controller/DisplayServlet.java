package in.app.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test3")
public class DisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String mdate=request.getParameter("mdate");
		String edate= request.getParameter("edate");
		
		Cookie[] cookies=request.getCookies();
		String pid=cookies[0].getValue();
		String pname=cookies[1].getValue();
		String pcost=cookies[2].getValue();
		String pqunatity=cookies[3].getValue();
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<table border='1'>");
		out.println("<tr><th>Product Id</th><td>"+pid+"</td>");
		out.println("<tr><th>Product Name</th><td>"+pname+"</td>");
		out.println("<tr><th>Product Cost</th><td>"+pcost+"</td>");
		out.println("<tr><th>Product Quantity</th><td>"+pqunatity+"</td>");
		out.println("<tr><th>Product Manifacture Date</th><td>"+mdate+"</td>");
		out.println("<tr><th>Product Expiry Date</th><td>"+edate+"</td>");
		out.println("</table>");
		
		

	}

}
