package fr.epsi.myEpsi.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import fr.epsi.myEpsi.beans.User;
import fr.epsi.myEpsi.dao.MessageDao;
import fr.epsi.myEpsi.service.UserService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(LoginServlet.class);
	private UserService userService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		// TODO Auto-generated method stub
			User user = userService.getUserById(request.getParameter("id"));
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String errorMsg = null;
			
			if (email == null || email.equals(""))
			{
				errorMsg ="L'email ne peut pas être null ou vide";
			}
			if(password == null || password.equals(""))
			{
				errorMsg ="Le mot de passe ne peut pas être nul ou vide";
			}
			
			if (errorMsg != null){
				RequestDispatcher rd = getServletContext().getNamedDispatcher("/sign.jsp");
				PrintWriter out= response.getWriter();
				out.print("<font color = red>"+errorMsg+"</font>");
				rd.include(request, response);
			}else if (user != null){
				request.getSession().setAttribute("user", user);
				logger.info("New session for user :"+user.getId());
				response.sendRedirect("home");
		}		
	}

}
