package in.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns ={"/demo"},loadOnStartup = 1)
public class DemoServletApp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static {
		System.out.println("Demo Servlet Loading");
	}

	public DemoServletApp() {
		System.out.println("Demo Servlet Instantiation");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("Demo Servlet initialization");
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Get Request from demo");
		System.out.println("Client IpAddress is "+request.getRemoteAddr());
		System.out.println("Client Host is "+request.getRemoteHost());
		System.out.println("Client port is "+request.getRemotePort());
		System.out.println("Server name is "+request.getServerName());
		System.out.println("Server port is "+request.getServerPort());
	}

}
