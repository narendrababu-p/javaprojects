package com.hello.servlet;

//Import required java libraries
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.employee.Employee;

//Extend HttpServlet class
public class HelloWorldServlet extends HttpServlet {
	
	private static final String USER_NAME = "Naren";
	private static final String PASSWORD = "Naren123";

	private static final long serialVersionUID = 1L;
	private String message;

	public void init() throws ServletException {
		// Do required initialization
		message = "Hello World 123";
		System.out.println("HelloWorldServlet initialized");
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Set response content type
		response.setContentType("text/html");
		
		HttpSession httpSession = request.getSession(true);
		
		httpSession.setAttribute("Name1", "WeGrow"); //3:58 to 4:08
		
		//We have to avoid setting values in session
		
		System.out.println("Name1 : "+httpSession.getAttribute("Name1"));
		request.setAttribute("Name", "Naren");
		
		System.out.println("Key : "+getServletContext().getInitParameter("Key"));
		System.out.println("number1 : "+request.getParameter("number1"));
		System.out.println("number2 : "+request.getAttribute("number2"));
		
		List<Employee> empList = new ArrayList<>();

		RequestDispatcher rd = request.getRequestDispatcher("/hello.html");
		
		rd.include(request, response);
	}

	public void destroy() {
		// do nothing.
	}
}
