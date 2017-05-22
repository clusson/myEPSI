package fr.epsi.myEpsi.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import fr.epsi.myEpsi.beans.User;
import fr.epsi.myEpsi.dao.UserDao;
import fr.epsi.myEpsi.service.UserService;

/**
 * Servlet implementation class SignServlet
 */
@WebServlet("/sign")
public class SignServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String LIST_USER = "/listUser.jsp";
    private static Logger logger = Logger.getLogger(LoginServlet.class);
    //TODO CREATE CONSTANTS
    private UserService userService;
    private UserDao dao;
    private User user;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        /* Affichage de la page d'inscription */
        this.getServletContext().getRequestDispatcher("/sign.jsp").forward( request, response );
    }

    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (user != null) {
			user.setId(request.getParameter("id"));
			user.setAdministrator(false);
			user.setPassword(request.getParameter("PASSWORD"));
            dao.addUser(user);
            response.sendRedirect("home");
		}
		else {
			logger.info("User is null");
			request.setAttribute("error", "Unknown user, please try again");
            request.getRequestDispatcher("/sign.jsp").forward(request, response);
		}
        


	}

}
