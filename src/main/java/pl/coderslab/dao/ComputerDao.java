package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.domain.Computer;
import pl.coderslab.domain.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class ComputerDao {
    @PersistenceContext
    private EntityManager entityManager;
    public void saveComputer(Computer computer) {
        entityManager.persist(computer);
    }

    public void deleteComputer(Computer computer) {
        entityManager.remove(entityManager.contains(computer) ? computer : entityManager.merge(computer));
    }

    public void updateComputer(Computer computer) {
        entityManager.merge(computer);
    }

    public Computer findById(long id) {
        return entityManager.find(Computer.class, id);
    }

    public List<Computer> findAll() {
        return entityManager.createQuery("SELECT c FROM Computer c", Computer.class).getResultList();
    }

    public List<Computer> findUserComputers(long id) {
        return entityManager.createQuery("SELECT c FROM Computer c WHERE c.client.id= ?1", Computer.class)
                .setParameter(1, id)
                .getResultList();
    }

}
