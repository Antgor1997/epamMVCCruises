package Listeners;

import org.apache.log4j.Logger;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener
public class SessionListenerAttr implements HttpSessionAttributeListener {

    private static final Logger logger = Logger.getLogger(SessionListener.class);

    public void attributeRemoved(HttpSessionBindingEvent event) {
        //запись в лог файл
        logger.info("removed Session " + event.getSession().getId() + " attribute: " + event.getClass().getSimpleName() + " : " + event.getName() + " : " + event.getValue());
    }

    public void attributeAdded(HttpSessionBindingEvent event) {
        //запись в лог файл
        logger.info("added Session " + event.getSession().getId() + " attribute: " + event.getClass().getSimpleName() + " : "+ event.getName() + " : " + event.getValue());
    }

    public void attributeReplaced(HttpSessionBindingEvent event) {
        //запись в лог файл
        logger.info("replaced Session " + event.getSession().getId() + " attribute: " + event.getClass().getSimpleName() + " : "+ event.getName() + " : " + event.getValue());
    }
}
