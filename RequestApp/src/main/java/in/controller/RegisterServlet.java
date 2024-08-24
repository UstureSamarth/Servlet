package in.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/reg", loadOnStartup = 1)
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static {
		System.out.println("Servlet loading");
	}

	public RegisterServlet() {
		System.out.println("Servlet instantiation");
	}

	public void init() throws ServletException {
		System.out.println("Servlet initialization");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Post type method");
		PrintWriter out = response.getWriter();
		System.out.println(request.getClass().getName());
		System.out.println(response.getClass().getName());
		System.out.println(request.hashCode());
		System.out.println(response.hashCode());
		System.out.println(Thread.currentThread().hashCode());
		

		String userName = request.getParameter("username");
		String email = request.getParameter("email");
		String[] courses = request.getParameterValues("course");
		
		response.setContentType("text/html");
		out.println("<html><head><title>Output Page</title></head><body><table border='1'><tr><th>Name</th><td> "
				+ userName + " </td></tr><tr><th>Email</th><td> " + email + " </td></tr>");
		out.println("<tr>");
		out.println("<th>Course selected</th>");
		out.println("<td>");
		for (String course : courses) {
			out.println(course + "<br/>");
		}
		out.println("</td>");
		out.println("</tr>");
		out.println("<tr><th>Request Object ::</th><td>"+request.hashCode()+"</td></tr>");
		out.println("<tr><th>Response Object ::</th><td>"+response.hashCode()+"</td></tr>");
		out.println("<tr><th>Thread request Object ::</th><td>"+Thread.currentThread().hashCode()+"</td></tr>");
		out.print("</table></body></html>");
		

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		out.close();

	}

}
