package com.auca.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/logins")
public class LoginServlet extends HttpServlet {
	
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String username = req.getParameter("name");
        String password = req.getParameter("password");

        
        if ("Rwakibibi Gihozo Zubeir".equals(username) && "12345".equals(password)) {
           
            try {
            	res.sendRedirect("Admission.html");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
           
            res.sendRedirect("ForgetPassword.html"); 
        }
    }
}
