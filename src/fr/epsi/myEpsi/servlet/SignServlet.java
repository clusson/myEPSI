package fr.epsi.myEpsi.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.epsi.myEpsi.beans.User;

/**
 * Servlet implementation class SignServlet
 */
@WebServlet("/sign")
public class SignServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  
		
		User user = null;
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		user.setId(id);
		user.setPassword(password);
		user.setAdministrator(false);
	}

}
