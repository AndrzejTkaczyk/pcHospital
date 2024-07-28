package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.domain.RepairDetails;
import pl.coderslab.domain.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class UserDao {
    @PersistenceContext
    private EntityManager entityManager;


    public void saveUser(User user) {
        entityManager.persist(user);
    }

    public void deleteUser(User user) {
        entityManager.remove(entityManager.contains(user) ? user : entityManager.merge(user));
    }

    public void updateUser(User user) {
        entityManager.merge(user);
    }

    public User findById(long id) {
        return entityManager.find(User.class, id);
    }

    public User findUserByEmail(String email) {
        return entityManager.createQuery("SELECT u FROM User u WHERE u.email = ?1", User.class)
                .setParameter(1, email)
                .getResultList().stream().findFirst().orElse(null);
    }
}
