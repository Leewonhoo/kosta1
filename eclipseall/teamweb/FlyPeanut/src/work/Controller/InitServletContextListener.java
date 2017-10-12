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
    	System.out.println("���ø����̼� �ڿ� �Ҵ�");
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent event)  { 
    	System.out.println("���ø����̼� �ڿ� ����");
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
