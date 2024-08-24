package in.app.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test1")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		out.println("<h1>This is First Servlet...</h1>");
		System.out.println("Request Object :- " + request.hashCode());
		System.out.println("Response Object :- " + response.hashCode());
		System.out.println("PrintWriter Object :- " + out.hashCode());
		request.setAttribute("sachin", "cricketer");
		request.setAttribute("samarth", "usture");
		RequestDispatcher rd = request.getRequestDispatcher("/test2");
		rd.include(request, response);

	}

}
