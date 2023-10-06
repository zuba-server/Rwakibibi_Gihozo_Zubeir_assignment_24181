package com.auca.service;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/studentUploadServlet")
@MultipartConfig
public class AdmissionServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String UPLOAD_DIRECTORY = "E:\\"; // Update this path

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get the file parts from the request
        Collection<Part> parts = request.getParts();

        for (Part part : parts) {
            // Process each part
            if (part.getContentType() != null) {
                // This is a file part
                String fileName = getFileName(part);

                // Check file type and save to the server
                if (isValidFileType(fileName)) {
                    // Create the directory if it doesn't exist
                    File uploadDir = new File(UPLOAD_DIRECTORY);
                    if (!uploadDir.exists()) {
                        uploadDir.mkdirs();
                    }

                    // Save the file to the server
                    part.write(uploadDir + File.separator + fileName);

                    // Handle successful upload here (e.g., display a success message)
                    PrintWriter out = response.getWriter();
                    out.println("Uploaded Successfully");
                } else {
                    // Handle invalid file type
                    PrintWriter out = response.getWriter();
                    out.println("Invalid file type. Allowed types: .jpg, .png, .pdf");
                }
            }
        }
    }

    private String getFileName(Part part) {
        String contentDisposition = part.getHeader("content-disposition");
        String[] tokens = contentDisposition.split(";");
        for (String token : tokens) {
            if (token.trim().startsWith("filename")) {
                return token.substring(token.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }

    private boolean isValidFileType(String fileName) {
        return fileName != null && (fileName.endsWith(".jpg") || fileName.endsWith(".png") || fileName.endsWith(".pdf"));
    }
}