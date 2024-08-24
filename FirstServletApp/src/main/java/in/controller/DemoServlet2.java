package in.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class DemoServlet2 implements Servlet {
	static {
		System.out.println("DemoServlet2 is loading...");
	}
	public DemoServlet2() {
		System.out.println("DemoServlet2 is instantiated...");
	}

	public void init(ServletConfig config) throws ServletException {
		System.out.println("DemoServlet2 is initailized...");
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
		System.out.println("DemoServlet2 is providing service...");
		res.setContentType("text/html");
	    PrintWriter pw=res.getWriter();
	    pw.println("<html><head><title>Output</title></head><body><marquee>***Welcome to DemoServlet2 coding***</marquee></body></html>");
	    pw.close();
		
	}
	
	public void destroy() {
		System.out.println("DemoServlet2 is destroyed...");
	}

}
