package service;

import dao.UserDao;
import model.User;

public class UserService {
    UserDao userDao = new UserDao();
    public void save(User user) {
        userDao.save(user);
    }
}
