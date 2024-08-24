package in.app.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/image" }, loadOnStartup = 1)
public class ImageResponseApp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static {
		System.out.println("Image Servlet Loading");
	}

	public ImageResponseApp() {
		System.out.println("Image Servlet Instantiation");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("Image Servlet initialization");
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Get request from image servlet");

		response.setContentType("image/jpg");
		ServletOutputStream sos = response.getOutputStream();
		String path = getServletContext().getRealPath("pp.jpg");
		File file = new File(path);
		FileInputStream fis = new FileInputStream(file);
		byte[] b = new byte[(int) file.length()];
		fis.read(b);// reading and placing data into byte array.
		sos.write(b);
		sos.flush();
		fis.close();
		sos.close();
	}

}
