package in.app.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/test2")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String qualification=request.getParameter("quali");
		String designstion=request.getParameter("design");
		
		HttpSession session=request.getSession();
		//false in get session if not exist session it will return null
		session.setAttribute("quali",qualification);
		session.setAttribute("design",designstion);
		
		RequestDispatcher rd=request.getRequestDispatcher("/form3.html");
		rd.forward(request, response);

	}

}
