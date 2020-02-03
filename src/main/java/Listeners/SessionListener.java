package Listeners;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import org.apache.log4j.Logger;

@WebListener
public class SessionListener implements HttpSessionListener {

    private static final Logger logger = Logger.getLogger(SessionListener.class);

    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        //запись в лог файл
        HttpSession session=httpSessionEvent.getSession();
        logger.info("Session with id : " + session.getId() + " created.");
        session.setMaxInactiveInterval(1200);

    }

    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        //запись в лог файл
        HttpSession session=httpSessionEvent.getSession();
        logger.info("Session with id : " + session.getId() + " killed.");
    }
}
