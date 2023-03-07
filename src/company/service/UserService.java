package company.service;

import company.model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    User findById(int userId);
    void deleteId(int userId);
    void getAllUser();
}
