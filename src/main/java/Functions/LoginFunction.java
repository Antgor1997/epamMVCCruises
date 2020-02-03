package Functions;

import Managers.*;
import Models.User;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFunction implements IFunction{
    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "password";

    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = null;
        User user = null;
        HttpSession session = request.getSession();

        // извлечение из запроса логина и пароля
        String login = request.getParameter(PARAM_NAME_LOGIN);
        String pass = request.getParameter(PARAM_NAME_PASSWORD);


        if (login == null) {
            request.setAttribute("emailValue", login);
            request.setAttribute("emailError", true);
            return ResourceManager.getInstance().getProperty(ResourceManager.INDEX);
        } else if (pass == null) {
            request.setAttribute("emailValue", login);
            request.setAttribute("loginError", true);
            return ResourceManager.getInstance().getProperty(ResourceManager.INDEX);
        }


        user = UserService.getInstance().loginUser(login, pass);
        if (user != null) {
            session.setAttribute("currentUser", user);
            String role = UserService.getInstance().checkRole(user);
            if (role.equals("main_admin")) {
//                request.setAttribute("showDrivers", true);
//                request.setAttribute("drivers", DriverService.getInstance().findAll());
                page = ResourceManager.getInstance().getProperty(ResourceManager.MAIN_ADMIN);
            } else if (role.equals("ship_admin")) {
                page = ResourceManager.getInstance().getProperty(ResourceManager.SHIP_ADMIN);
            }
            else if (role.equals("passenger")) {
                page = ResourceManager.getInstance().getProperty(ResourceManager.MAIN);
            }
        } else {
            request.setAttribute("emailValue", login);
            request.setAttribute("loginError", true);
            page = ResourceManager.getInstance().getProperty(ResourceManager.INDEX);
        }
        return page;
    }
}
