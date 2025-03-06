package example.dao;

import example.model.User;
import java.util.List;

public interface UserDao {
    List<User> getAllUsers();
    void createUser(User user);
    void updateUser(User user);
    User getUser(long id);
    void deleteUser(long id);
}