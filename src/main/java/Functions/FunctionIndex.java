package Functions;

import Managers.ResourceManager;
import Models.User;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FunctionIndex implements IFunction{
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = null;

        HttpSession session = request.getSession(false);
        if (session != null) {

            User user = (User) session.getAttribute("currentUser");
            if (user == null) {
                page = ResourceManager.getInstance().getProperty(ResourceManager.INDEX);
            }
            String role = UserService.getInstance().checkRole(user);

            if (role.equals("MAIN_ADMIN")) {
                page = ResourceManager.getInstance().getProperty(ResourceManager.MAIN_ADMIN);
            } else if (role.equals("SHIP_ADMIN")){
                page = ResourceManager.getInstance().getProperty(ResourceManager.SHIP_ADMIN);}
            else if (role.equals("PASSENGER")){
                page = ResourceManager.getInstance().getProperty(ResourceManager.MAIN);}
        } else
            page = ResourceManager.getInstance().getProperty(ResourceManager.INDEX);
        return page;
    }
}
