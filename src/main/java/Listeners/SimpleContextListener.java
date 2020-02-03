package Listeners;

import org.apache.log4j.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class SimpleContextListener implements ServletContextListener {

    private static final Logger logger = Logger.getLogger(SessionListener.class);

    public void contextInitialized(ServletContextEvent sce) {
        //запись в лог файл
        ServletContext context = sce.getServletContext();
        String mailFeedback = context.getInitParameter("feedback");
        context.log("Context Initialized with parameter: " + mailFeedback);
        logger.info("Context Initialized with parameter: " + mailFeedback);
    }

    public void contextDestroyed(ServletContextEvent sce) {
        //запись в лог файл
        ServletContext context = sce.getServletContext();
        String mailFeedback = context.getInitParameter("feedback");
        logger.info("Context Destroyed with parameter: " + mailFeedback);
    }
}
