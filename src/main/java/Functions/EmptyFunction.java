package Functions;

import Managers.ConfigurationManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmptyFunction implements IFunction{

    public String execute(HttpServletRequest request, HttpServletResponse response){
        /* в случае ошибки или прямого обращения к контроллеру
         * переадресация на страницу ввода логина */
        String page = ConfigurationManager.getProperty("path.page.login");
        return page;
    }
}
