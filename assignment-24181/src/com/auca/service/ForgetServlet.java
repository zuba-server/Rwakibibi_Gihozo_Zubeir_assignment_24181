package com.auca.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/forgetPassword")
public class ForgetServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        
        
        try {
        	if(!email.isEmpty()) {
        		response.sendRedirect("HomePage.html");
        	}else {
        		System.out.println("Please enter you email");
        	}
        }catch(IOException e) {
        	e.printStackTrace();
        }
    }
}
