package service;

import model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    void getAllUser(List<User> users);
    void findId(int userId);
    void deleteId(int userId);
}
