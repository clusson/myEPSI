package test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import fr.epsi.myEpsi.beans.User;
import fr.epsi.myEpsi.dao.MessageDao;

public class UnitTest {

	   String hello = "Hello World";	
	   MessageDao message = new MessageDao();
	   User user = new User("Toto", "titi", true);

	   @Test
	   public void testPrintMessage() {	  
	      assertEquals();
	   }
}
