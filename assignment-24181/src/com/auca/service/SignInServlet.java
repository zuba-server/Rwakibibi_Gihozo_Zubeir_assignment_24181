package com.auca.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/signin")
public class SignInServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String email, password;

    public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
        email = req.getParameter("Email");
        password = req.getParameter("password");

        // Determine the user's locale from the request
        //Locale userLocale = req.getLocale();
        
        // Load the appropriate resource bundle based on the user's locale
       // ResourceBundle messages = ResourceBundle.getBundle("", userLocale);

        if (email != null && password != null) {
            res.sendRedirect("HomePage.html");
        } else {
            // Get the message from the resource bundle
            //String errorMessage = messages.getString("signInErrorMessage");
            
            PrintWriter out = res.getWriter();
          // out.println(errorMessage);
        }
    }

}