package dao;

import Models.User;

public interface UserDao {

    User findByLoginAndPassword(String login, String password);

    void create(User entity);

    void resetSpent(Integer price, Integer userId);
}
