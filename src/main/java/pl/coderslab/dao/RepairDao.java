package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.domain.Computer;
import pl.coderslab.domain.Repair;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class RepairDao {
    @PersistenceContext
    private EntityManager entityManager;

    public void saveRepair(Repair repair) {
        entityManager.persist(repair);
    }

    public void deleteRepair(Repair repair) {
        entityManager.remove(entityManager.contains(repair) ? repair : entityManager.merge(repair));
    }

    public void updateRepair(Repair repair) {
        entityManager.merge(repair);
    }

    public Repair findById(long id) {
        return entityManager.find(Repair.class, id);
    }

    public List<Repair> findAll() {
        return entityManager.createQuery("SELECT r FROM Repair r", Repair.class).getResultList();
    }

    public List<Repair> findUserRepairs(long id) {
        return entityManager.createQuery("SELECT r FROM Repair r WHERE r.client.id= ?1", Repair.class)
                .setParameter(1, id)
                .getResultList();
    }

    public int findRepairStatusByComputerId(long id) {
        return entityManager.createQuery("SELECT r.status FROM Repair r WHERE r.computer.id= ?1 AND r.status==2", Repair.class)
                .setParameter(1, id)
                .getFirstResult();
    }
}