package fr.epsi.myEpsi.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import fr.epsi.myEpsi.beans.Message;
import fr.epsi.myEpsi.beans.User;

public class MessageDao implements IMessageDao {
	
	DAOManager connection;
	private static Logger logger = Logger.getLogger(MessageDao.class);
	
	public MessageDao() {
		connection.getConnection();
	}

	
	@Override
	public List<Message> getListOfMessages(User user) {
		List<Message> messages = new ArrayList<>();

		if(connection != null){
			try{
				Statement stmt = connection.createStatement();
				ResultSet result = stmt.executeQuery("SELECT * FROM MESSAGES WHERE USER_ID = '" + user.getId());
				while (result.next()){
					Message message = new Message ();
					message.setId(Long.valueOf(result.getInt(1)));;
					message.setTitle(result.getString(2));
					//...
					messages.add(message);
				}
			}catch (SQLException e){
				return null;
			}
			return messages;
		}
		return null;
	}
	
	public int countMessages() {
		
		int messages = 0;
		if(connection != null){
			try{
				Statement stmt = connection.createStatement();
				ResultSet result = stmt.executeQuery("SELECT count(*) FROM MESSAGES");
				while (result.next()){
					messages = result.getInt(1);
				}

			}catch (SQLException e){
				return 0;
			}
			return 0;
		}
		return messages;
	}

	@Override
	public Message getMessage(Long id) {
		Message message = null;
		if(connection != null){
			try{
				Statement stmt = connection.createStatement();
				ResultSet result = stmt.executeQuery("SELECT * FROM MESSAGES where id =:id");
				while (result.next()){
					message = (Message) result;
				}

			}catch (SQLException e){
				logger.error(e);;
			}
		}
		return message;
	}

	@Override
	public void addMessage(Message message) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateMessageStatus(Message message, int status) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteMessage(Message message) {
		// TODO Auto-generated method stub

	}

}
