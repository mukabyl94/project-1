package company.service.impl;

import company.dao.UserDao;
import company.model.User;
import company.service.UserService;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserServiceImpl() {
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
    public void getAllUser(List<User> users) {
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Override
    public User findById(int userId) {
        ArrayList<Integer> integers = new ArrayList<>();
        for (User gost: userDao.getUsers()) {
            integers.add(gost.getId());
        }
        for (User gost: userDao.getUsers()) {
            if (gost.getId() == userId){
                System.out.println(gost);
            }else if(!integers.contains(userId)){
                throw new RuntimeException("Myndai Id jok");
            }
        }
    }

    @Override
    public void deleteId(int userId) {
        ArrayList<Integer> integers = new ArrayList<>();
        for (User gost: userDao.getUsers()) {
            integers.add(gost.getId());
        }
        for (User gost: userDao.getUsers()) {
            if (gost.getId() == userId){
                userDao.getUsers().remove(gost);
            }else if(!integers.contains(userId)){
                throw new RuntimeException("Myndai Id jok");
            }
        }
    }

    @Override
    public String toString() {
        return "UserServiceImpl{" +
                "userDao=" + userDao +
                '}';
    }
}
