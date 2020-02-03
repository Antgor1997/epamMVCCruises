package service;

import Models.User;
import dao.UserDao;
import factory.ActionFactory;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class UserService {

    private static final Logger LOGGER = LogManager.getLogger(UserService.class);

    private static final String MAIN_ADMIN = "main_admin";
    private static final String SHIP_ADMIN = "ship_admin";
    private static final String PASSENGER = "passenger";
    private static final String ALL = "all";
    private UserDao userDao = ActionFactory.createUserDao();


    private UserService() {
    }

    /**
     * Singleton instance
     */
    private static UserService instance = null;

    public static synchronized UserService getInstance() {
        if (instance == null)
            instance = new UserService();
        return instance;
    }



    public String checkRole(User user) {
        String role = null;
        if (user == null)
            role = ALL;
        else if (user.getRole().equals("main_admin"))
            role = MAIN_ADMIN;
        else if (user.getRole().equals("ship_admin"))
            role = SHIP_ADMIN;
        else if (user.getRole().equals("passenger"))
            role = PASSENGER;
        return role;
    }


    public User loginUser(String login, String password) {
        User user = null;
        user = userDao.findByLoginAndPassword(login, password);
        return user;
    }

//    public void addNewUser(String password, String name) {
//        User user = null;
//
//        if (user != null) {
//            LOGGER.info("User with such email is already registered!");
//        } else {
//            user = new User();
//
//            user.setPassword(password);
//
//            user.setName(name);
//
//            Role role = new Role();
//            role.setRoleName(Role.ROLE_CLIENT);
//            role.setId(2);
//            user.setRole(role);
//            userDao.create(user);
//        }
//    }

    public void addSpentMoney(Integer spent, Integer userId) {
        userDao.resetSpent(spent, userId);
    }
}
