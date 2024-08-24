package in.app.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/demo")
public class TargetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static {
		System.out.println("TargetServlet Loading");
	}

	public TargetServlet() {
		System.out.println("TargetServlet Instantiation");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("TargetServlet Initialization");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("TargetServlet processing phase...");
		PrintWriter out = response.getWriter();
		out.println("<h1>Request from target servlet...</h1>");
	}

}
