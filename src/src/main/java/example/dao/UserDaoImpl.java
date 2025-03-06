package example.dao;

import example.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository //добавила проверку на существование id
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public void createUser(User user) {
        entityManager.persist(user);
        entityManager.flush();
    }

    @Override
    public void updateUser(User user) {
        User existingUser = getUser(user.getId());
        if (existingUser == null) {
            throw new EntityNotFoundException("User with id " + user.getId() + " not found");
        }
        entityManager.merge(user);
        entityManager.flush();
    }

    @Override
    public User getUser(long id) {
        User user = entityManager.find(User.class, id);
        if (user == null) {
            throw new EntityNotFoundException("User with id " + id + " not found");
        }
        return user;
    }

    @Override
    public void deleteUser(long id) {
        User user = getUser(id);
        if (user == null) {
            throw new EntityNotFoundException("User with id " + id + " not found");
        }
        entityManager.remove(user);
    }
}