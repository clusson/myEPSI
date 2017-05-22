package fr.epsi.myEpsi.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.epsi.myEpsi.beans.User;
import fr.epsi.myEpsi.dao.UserDao;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/user.jsp";
    private static String LIST_USER = "/listUser.jsp";
    
    private UserDao dao;
    private User user;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
       // dao = new UserDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String forward="";
	        String action = request.getParameter("action");

	        if (action.equalsIgnoreCase("delete")){
	            String userId = request.getParameter("ID");
	            user.setId(userId);
	            dao.deleteUser(user);
	            forward = LIST_USER;
	            request.setAttribute("users", dao.getListOfUsers());    
	        } else if (action.equalsIgnoreCase("edit")){
	            forward = INSERT_OR_EDIT;
	            String userId = request.getParameter("ID");
	            User user = dao.getUserById(userId);
	            request.setAttribute("user", user);
	        } else if (action.equalsIgnoreCase("listUser")){
	            forward = LIST_USER;
	            request.setAttribute("users", dao.getListOfUsers());
	        } else {
	            forward = INSERT_OR_EDIT;
	        }

	        request.getRequestDispatcher("listUser.jsp").forward(request, response);
	}

}
