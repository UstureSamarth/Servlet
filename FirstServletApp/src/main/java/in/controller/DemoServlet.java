package in.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class DemoServlet implements Servlet {
	static {
		System.out.println("DemoServlet is loading...");
	}
	public DemoServlet() {
		System.out.println("DemoServlet is instantiated...");
	}

	public void init(ServletConfig config) throws ServletException {
		System.out.println("DemoServlet is initailized...");
	}


	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("DemoServlet is providing service...");
		res.setContentType("text/html");
	    PrintWriter pw=res.getWriter();
	    pw.println("<html><head><title>Output</title></head><body><marquee>***Welcome to DemoServlet coding***</marquee></body></html>");
	    pw.close();
		
	}
	
	public void destroy() {
		System.out.println("DemoServlet is destroyed...");
	}

}
