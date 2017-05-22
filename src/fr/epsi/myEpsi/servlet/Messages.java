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

import org.apache.log4j.Logger;

import fr.epsi.myEpsi.beans.Message;
import fr.epsi.myEpsi.beans.Status;
import fr.epsi.myEpsi.beans.User;
import fr.epsi.myEpsi.service.UserService;
import fr.epsi.myEpsi.service.MessageService;
import fr.epsi.myEpsi.beans.Message;

/**
 * Servlet implementation class MessageServlet
 */
@WebServlet("/Messages")
public class Messages extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public UserService userService;
    public MessageService messageService;
    private static Logger logger = Logger.getLogger(Login.class);
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
		
		User connected = (User) request.getSession().getAttribute("user");
		if(connected == null){
			logger.error("User not connectd",request);
			response.sendRedirect("Signin");
		} else if(request.getParameter("action") != null && request.getParameter("action").equals("DELETE")) {
			this.doDelete(request, response);
		} else if(request.getParameter("action") != null && request.getParameter("action").equals("PUT")) {
			this.doPut(request, response);
		}else {   
			Message message = new fr.epsi.myEpsi.beans.Message();
			message.setTitle(request.getParameter("title"));
		    message.setContent(request.getParameter("content"));
		    message.setCreationDate(new Timestamp(new Date().getTime()));
		    message.setUpdateDate(new Timestamp(new Date().getTime()));
		    message.setAuthor(connected); 
		    message.setStatus(Status.valueOf(request.getParameter("status")));
		    messageService.addMessage(message);
		    response.sendRedirect("Messages");
		}
	 }
	
	/** 
	 * @see HttpServlet#doDelete(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User connected = (User) request.getSession().getAttribute("user");
		String id = request.getParameter("id");
		if(id != null && connected != null){
			Message message = messageService.getMessage(Long.parseLong(request.getParameter("id"))); 
			try {
				messageService.deleteMessage(message, connected);
			} catch (CannotDeleteMessageException e) {
				logger.error("You are not authorized to delete this post");
			}
			response.sendRedirect("Messages");
		} else {
			 response.sendRedirect("Signin");
		}
	}
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		User connected = (User) request.getSession().getAttribute("user");
		if(connected == null){
			  response.sendRedirect("Signin");
		} else {
			Message message = messageService.getMessage(Long.parseLong(request.getParameter("id")));
		    messageService.updateMessageStatus(message, Status.valueOf(request.getParameter("status")).ordinal());
		    response.sendRedirect("Messages");
		}
	}
		/*
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
	}*/

}