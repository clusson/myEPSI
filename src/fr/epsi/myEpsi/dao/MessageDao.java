package fr.epsi.myEpsi.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import fr.epsi.myEpsi.beans.Message;
import fr.epsi.myEpsi.beans.User;

public class MessageDao implements IMessageDao {
	

	@Override
	public List<Message> getListOfMessages(User user) {
List<Message> messages = new ArrayList<>();
		
		Connection con = ConnectionTool.getConnection();
		if(con != null){
			try{
				Statement stmt = con.createStatement();
				ResultSet result = stmt.executeQuery("SELECT * FROM MESSAGES WHERE USER_ID = '" + user.getId());
				while (result.next()){
					Message message = new Message ();
					message.setId(Long.valueOf(result.getInt(1)));;
					message.setTitle(result.getString(2));
					//...
					messages.add(message);
				}
				con.close();
			}catch (SQLException e){
				return null;
			}
			return messages;
		}
		return null;
	}
	
	public static int countMessages() {
		int messages = 0;
		Connection con = ConnectionTool.getConnection();
		if(con != null){
			try{
				Statement stmt = con.createStatement();
				ResultSet result = stmt.executeQuery("SELECT count(*) FROM MESSAGES");
				while (result.next()){
					messages = result.getInt(1);
				}
				con.close();
			}catch (SQLException e){
				return 0;
			}
			return 0;
		}
		return messages;
	}

	@Override
	public Message getMessage(Long id) {
		// TODO Auto-generated method stub
		return null;
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
