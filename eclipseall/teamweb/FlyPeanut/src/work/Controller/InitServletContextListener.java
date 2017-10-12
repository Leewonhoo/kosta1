package work.Controller;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Application Lifecycle Listener implementation class InitServletContextListener
 *
 */
public class InitServletContextListener implements ServletContextListener {

	public ServletContext application;
	public String CONTEXT_PATH;
	
    /**
     * Default constructor. 
     */
    public InitServletContextListener() {
    	System.out.println("어플리케이션 자원 할당");
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent event)  { 
    	System.out.println("어플리케이션 자원 해제");
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent event)  { 
    	application = event.getServletContext();
    	CONTEXT_PATH = application.getContextPath();  
    	application.setAttribute("PATH", CONTEXT_PATH);
    }
	
}
