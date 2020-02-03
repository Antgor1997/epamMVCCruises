package Listeners;

import org.apache.log4j.Logger;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class RequestListenerAttr implements ServletRequestAttributeListener {

    private static final Logger logger = Logger.getLogger(SessionListener.class);

    public void attributeRemoved(ServletRequestAttributeEvent srae) {
        //запись в лог файл
        logger.info("Request attribute " + srae.getClass().getSimpleName() + " with name = " + srae.getName() + " and value = " + srae.getValue() + " was removed!");
    }

    public void attributeAdded(ServletRequestAttributeEvent srae) {
        //запись в лог файл
        logger.info("Request attribute " + srae.getClass().getSimpleName() + " with name = " + srae.getName() + " and value = " + srae.getValue() + " was added!");
    }

    public void attributeReplaced(ServletRequestAttributeEvent srae) {
        //запись в лог файл
        logger.info("Request attribute " + srae.getClass().getSimpleName() + " with name = " + srae.getName() + " and value = " + srae.getValue() + " was replaced!");
    }
}
