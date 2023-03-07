package company.service.impl;

import company.dao.UserDao;
import company.model.User;
import company.service.UserService;

public class ServiceImpl implements UserService {
    private UserDao userDao = new UserDao();

    public ServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public ServiceImpl() {
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void addUser(User user) {
        userDao.getUsers().add(user);
    }

    @Override
    public void getAllUser() {
        for (User user : userDao.getUsers()) {
            System.out.println(user);
        }
    }

    @Override
    public User findById(int userId) {
        for (User user : userDao.getUsers()) {
            if (user.getId() == userId) {
                return user;
            }
        }
        throw new MyException("Kechiresiz bizde " + userId + " Id jok");
    }

    @Override
    public void deleteId(int userId) {
        boolean n = true;
        for (int i = 0; i < userDao.getUsers().size(); i++) {
            if (userDao.getUsers().get(i).getId() == userId) {
                n = false;
                userDao.getUsers().remove(userDao.getUsers().get(i));
                System.out.println("Siz bergen Id degi maalymat ochuruldu");
            }
        }
        if (n) {
            throw new MyException("Kechiresiz bizde " + userId + " Id jok");
        }
    }


    @Override
    public String toString() {
        return "UserServiceImpl{" +
                "userDao=" + userDao +
                '}';
    }
}
