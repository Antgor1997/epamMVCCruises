package factory;

import dao.DaoRealization.UserDaoRealization;
import dao.UserDao;

public class ActionFactory {
    public static UserDao createUserDao () {
        return UserDaoRealization.getInstance();
    }
}
