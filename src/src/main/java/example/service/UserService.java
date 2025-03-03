package example.service;

import example.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User getUser(long id);

    void deleteUser(long id);

    void createUser(User user);

    void updateUser(User user);
}