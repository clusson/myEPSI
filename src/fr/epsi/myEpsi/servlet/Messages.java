package fr.epsi.myEpsi.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.epsi.myEpsi.beans.Message;
import fr.epsi.myEpsi.beans.User;
import fr.epsi.myEpsi.service.UserService;

/**
 * Servlet implementation class MessageServlet
 */
@WebServlet("/MessageServlet")
public class Messages extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public UserService userService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Messages() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw=response.getWriter();
		response.setContentType("text/html");
		
		String userID = request.getParameter("user");
		String content = request.getParameter("content");
		String title = request.getParameter("title");
		User user = userService.getUserById(request.getSession().getAttribute("id").toString());
		Date date = new Date();
		
		
		if (user != null && content != null){
			Message message = new Message();
			message.setAuthor(user);
			message.setContent(content);
			message.setCreationDate(new Timestamp(date.getTime()));
			message.setTitle(title);
			//message.setStatus();

			
		}
	}

}
