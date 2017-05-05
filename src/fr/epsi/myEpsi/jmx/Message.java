package fr.epsi.myEpsi.jmx;

import fr.epsi.myEpsi.dao.MessageDao;

public class Message implements MessageMBean {

	private static String nom = "MessageBean";

    public String getNumber() {
        return nom;
    }

    public void getMessages() {
        MessageDao.countMessages();
    }
}
