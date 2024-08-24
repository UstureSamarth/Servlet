package in.app.listner;

import java.util.Date;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class RequestDemoListner implements ServletRequestListener {

	public static int count = 0;

	public RequestDemoListner() {

	}

	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("Request object destroyed " + new Date());
		
	}

	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("Request object created " + new Date());
		count++;
		System.out.println("No of hit for this app " + count);
	}

}
