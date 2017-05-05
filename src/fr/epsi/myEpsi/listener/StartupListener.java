package fr.epsi.myEpsi.listener;

import java.lang.management.ManagementFactory;

import javax.management.*;
import javax.servlet.*;
import javax.servlet.annotation.WebListener;

import fr.epsi.myEpsi.jmx.Premier;

/**
 * Application Lifecycle Listener implementation class StartupListener
 *
 */
@WebListener
public class StartupListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public StartupListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
    	MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
    	ObjectName name = null;

    	try {
    	    name = new ObjectName("fr.epsi.myEpsi.jmx:type=PremierMBean");
    	    Premier mbean = new Premier();

    	    mbs.registerMBean(mbean, name);

    	} catch (MalformedObjectNameException e) {
    	    e.printStackTrace();
    	} catch (NullPointerException e) {
    	    e.printStackTrace();
    	} catch (InstanceAlreadyExistsException e) {
    	    e.printStackTrace();
    	} catch (MBeanRegistrationException e) {
    	    e.printStackTrace();
    	} catch (NotCompliantMBeanException e) {
    	    e.printStackTrace();
    	}

    }
	
}
