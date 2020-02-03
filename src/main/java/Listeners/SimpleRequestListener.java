package Listeners;

import org.apache.log4j.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

@WebListener
public class SimpleRequestListener implements ServletRequestListener {

    private static final Logger logger = Logger.getLogger(SessionListener.class);

    public void requestInitialized(ServletRequestEvent sre) {
        // будет использован для получения информации о запросе
        HttpServletRequest req = (HttpServletRequest) sre.getServletRequest();
        String uri = "Request Initialized for " + req.getRequestURI();
        String id = "Request Initialized with ID="+ req.getRequestedSessionId();
        System. out.println(uri + "\n" + id);
        ServletContext context = sre.getServletContext();
        // счетчик числа созданных запросов
        Integer reqCount = (Integer)req.getSession().getAttribute("counter");
        if(reqCount == null) {
            reqCount = 0;
        }
        context.log(uri + "\n" +id + ", Request Counter =" + reqCount);
        logger.info(uri + "\n" +id + ", Request Counter =" + reqCount);
    }

    public void requestDestroyed(ServletRequestEvent sre) {
        //запись в лог файл
        logger.info("Request Destroyed: " + sre.getServletRequest().getAttribute("lifecycle"));
    }
}