package fr.epsi.myEpsi.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import fr.epsi.myEpsi.beans.User;
import fr.epsi.myEpsi.service.UserService;

/**
 * Servlet implementation class SignServlet
 */
@WebServlet("/Sign")
public class Sign extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String LIST_USER = "/listUser.jsp";
    private static Logger logger = Logger.getLogger(Sign.class);
    //TODO CREATE CONSTANTS
    private UserService userService;
    
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sign() {
        super();
        userService = new UserService();
    }

    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
    	logger.info("GET /Sign");
	    logger.debug(request);
		request.getRequestDispatcher("Sign.jsp").forward(request, response);
    }

    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		logger.info("POST /Sign");
		logger.debug(request);
		
		String username=request.getParameter("id");
		String pass=request.getParameter("password");
		
		User user = new User(username, pass, false);
		
		if (user.getPassword() != null && user.getId() != null) {
            request.getSession().setAttribute("user", userService.getUserById(username));
            response.sendRedirect("Message");
        } 
        else { 
        	logger.error("Sign in error");
        	request.getRequestDispatcher("Sign.jsp").forward(request, response);
        }
        
	}

}
