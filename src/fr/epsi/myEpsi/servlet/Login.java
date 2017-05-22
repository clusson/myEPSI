package fr.epsi.myEpsi.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import fr.epsi.myEpsi.beans.User;
import fr.epsi.myEpsi.service.UserService;
import utils.UserDuplicateException;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(Login.class);
	private UserService userService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User connected = (User) request.getSession().getAttribute("user");
		
		if(connected != null && request.getParameter("action") != null && request.getParameter("action").equals("DELETE")) {
			this.doDelete(request, response);
		} else if(connected != null &&request.getParameter("action") != null && request.getParameter("action").equals("PUT")) {
			this.doPut(request, response);
		} else if(request.getParameter("password").equals(request.getParameter("repassword"))){   
			User user = new User();
			user.setId(request.getParameter("login"));
			user.setPassword(request.getParameter("password"));
			user.setAdministrator(Boolean.parseBoolean(request.getParameter("admin")));
			try {
				userService.addUser(user);
			} catch (UserDuplicateException e) {
				logger.error("You can't create two users with same ID");
			}
			response.sendRedirect("Users");
		} else {
			response.sendRedirect("Users");
		}
	}
}
