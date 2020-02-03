package Functions;

import Managers.ConfigurationManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutFunction implements IFunction{

    public String execute(HttpServletRequest request, HttpServletResponse response){
        String page = ConfigurationManager.getProperty("path.page.index");
        // уничтожение сессии
        request.getSession().invalidate();
        return page;
    }
}
