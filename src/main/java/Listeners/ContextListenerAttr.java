package Listeners;

import org.apache.log4j.Logger;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

public class ContextListenerAttr implements ServletContextAttributeListener {

    private static final Logger logger = Logger.getLogger(SessionListener.class);

    public void attributeRemoved(ServletContextAttributeEvent event) {
        //запись в лог файл
        logger.info("Context attribute " + event.getClass().getSimpleName() + " with name = " + event.getName() + " and value = " + event.getValue() + " was removed!");
    }

    public void attributeAdded(ServletContextAttributeEvent event) {
        //запись в лог файл
        logger.info("Context attribute with name = " + event.getName() + " and value = " + event.getValue() + " was added!");
    }

    public void attributeReplaced(ServletContextAttributeEvent event) {
        //запись в лог файл
        logger.info("Context attribute with name = " + event.getName() + " and value = " + event.getValue() + " was replaced!");
    }
}
