package in.app.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/register" }, initParams = {
		@WebInitParam(name = "JdbcUrl", value = "jdbc:mysql:///servletdb"),
		@WebInitParam(name = "user", value = "root"), @WebInitParam(name = "password", value = "Samarth@123") })
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection;

	static {
		System.out.println("Register Servlet Loading");
	}

	public RegisterServlet() {
		System.out.println("Register Servlet Instantiation");
	}

	public void init() throws ServletException {
		System.out.println("Register Servlet Initialization");

		ServletConfig config = getServletConfig();
		String url = config.getInitParameter("JdbcUrl");
		String user = config.getInitParameter("user");
		String password = config.getInitParameter("password");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = request.getParameter("username");
		String email = request.getParameter("email");
		String city = request.getParameter("city");
		String country = request.getParameter("country");
		System.out.println(userName + " " + email + " " + city + " " + country);
		int rowCount = 0;
		if (connection != null) {
			PreparedStatement pstmt = null;
			String sqlInsertQuery = "insert into students(`name`,`email`,`city`,`country`)values(?,?,?,?)";
			try {
				pstmt = connection.prepareCall(sqlInsertQuery);
				pstmt.setString(1, userName);
				pstmt.setString(2, email);
				pstmt.setString(3, city);
				pstmt.setString(4, country);

				rowCount = pstmt.executeUpdate();

			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Output");
		out.println("</title>");
		out.println("</head>");
		out.println("<body>");
		if(rowCount==1) {
			out.println("<h1 style='color: green;text-align: center;'>Registration Successful</h1>");
		}else {
			out.println("<h1 style='color: red;text-align: center;'>Registration Failed</h1>");
			out.println("<a style='text-align: center;' href='./register.html'>Register Again</a>");
		}
			
		out.println("</body>");
		out.println("</html>");

	}

}
