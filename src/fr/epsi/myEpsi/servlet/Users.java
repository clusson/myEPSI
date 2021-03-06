package fr.epsi.myEpsi.servlet;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import fr.epsi.myEpsi.beans.User;
import fr.epsi.myEpsi.dao.UserDao;
import fr.epsi.myEpsi.service.IUserService;
import fr.epsi.myEpsi.service.UserService;
import utils.UserDuplicateException;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/users")
public class Users extends HttpServlet {
    
    IUserService userService;
	Logger logger =  Logger.getLogger(Users.class);
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Users() {
        super();
        userService = new UserService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("GET /users");
	    logger.debug(request);
		User connected = (User) request.getSession().getAttribute("user");
		if(connected == null){
			  response.sendRedirect("sign");
		} else if(!connected.getAdministrator()){
			  response.sendRedirect("message");
		} else {
			List<User> users = userService.getListOfUsers();
			request.setAttribute("user", users);
			request.getRequestDispatcher("users.jsp").forward(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("login");
		User connected = (User) request.getSession().getAttribute("user");
		if(connected == null){
			  response.sendRedirect("Signin");
		} else if(request.getParameter("password").equals(request.getParameter("repassword"))) {
			User user = new User();
			user.setId(id);
			user.setPassword(request.getParameter("password"));
			user.setAdministrator(Boolean.parseBoolean(request.getParameter("admin")));
			userService.updateUser(user);
			response.sendRedirect("Users");
		} else {
			response.sendRedirect("Users");
		}

	}
}
