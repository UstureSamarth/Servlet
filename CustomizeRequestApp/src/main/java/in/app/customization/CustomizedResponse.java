package in.app.customization;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class CustomizedResponse extends HttpServletResponseWrapper {

	private StringWriter stringWriter;
	private PrintWriter writer;

	public CustomizedResponse(HttpServletResponse response) {
		super(response);
		stringWriter = new StringWriter();
		writer = new PrintWriter(stringWriter);
	}

	@Override
	public PrintWriter getWriter() throws IOException {
		// TODO Auto-generated method stub
		return writer;
	}

	@Override
	public void flushBuffer() throws IOException {
		writer.flush();
		String responseContent = stringWriter.toString();

		// Here you can modify the response content as needed
		String modifiedContent = responseContent.replace("original", "modified");

		// Write the modified content to the actual response
		getResponse().getWriter().write(modifiedContent);
		getResponse().flushBuffer();
	}

}
