package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.domain.Computer;
import pl.coderslab.domain.RepairDetails;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class RepairDetailsDao {
    @PersistenceContext
    private EntityManager entityManager;
    public void saveRepairDetails(RepairDetails repairDetails) {
        entityManager.persist(repairDetails);
    }

    public void deleteRepairDetails(RepairDetails repairDetails) {
        entityManager.remove(entityManager.contains(repairDetails) ? repairDetails : entityManager.merge(repairDetails));
    }

    public void updateRepairDetails(RepairDetails repairDetails) {
        entityManager.merge(repairDetails);
    }

    public RepairDetails findById(long id) {
        return entityManager.find(RepairDetails.class, id);
    }

    public List<RepairDetails> findAll() {
        return entityManager.createQuery("SELECT rd FROM RepairDetails rd", RepairDetails.class).getResultList();
    }

    public List<RepairDetails> findRepairDetailsById(long id) {
        return entityManager.createQuery("SELECT rd FROM RepairDetails rd WHERE rd.id= ?1", RepairDetails.class)
                .setParameter(1, id)
                .getResultList();
    }

    public List<RepairDetails> findRepairsDetailsByRepairId(long id) {
        return entityManager.createQuery("SELECT rd FROM RepairDetails rd WHERE rd.repair.id= ?1", RepairDetails.class)
                .setParameter(1, id)
                .getResultList();
    }

    public RepairDetails findOneRepairDetailsById (long id) {
        return entityManager.createQuery("SELECT rd FROM RepairDetails rd WHERE rd.repair.id= ?1", RepairDetails.class)
                .setParameter(1, id)
                .getSingleResult();
    }

    public List<RepairDetails> findEmployeeRepairsByIdEmployee (long id) {
        return entityManager.createQuery("SELECT rd FROM RepairDetails rd WHERE rd.employee.id= ?1", RepairDetails.class)
                .setParameter(1, id)
                .getResultList();
    }
}
