package repository;

import entity.CandidatJobApp;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceException;
import repository.inter.CandidatJobAppRepositoryInter;

import java.util.List;
import java.util.UUID;

public class CandidatJobAppRepository implements CandidatJobAppRepositoryInter {

    @PersistenceContext
    private EntityManager entityManager;

    public void applyForJob(CandidatJobApp candidatJobApp) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(candidatJobApp);
            transaction.commit();
        } catch (PersistenceException e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw new RuntimeException("Error applying for job: " + e.getMessage(), e);
        } finally {
            if (entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    public List<CandidatJobApp> findByCandidatId(UUID candidatId) {
        String jpql = "SELECT c FROM CandidatJobApp c WHERE c.candidat.id = :candidatId";
        return entityManager.createQuery(jpql, CandidatJobApp.class)
                .setParameter("candidatId", candidatId)
                .getResultList();
    }

    public List<CandidatJobApp> findByJobAppId(UUID jobAppId) {
        String jpql = "SELECT c FROM CandidatJobApp c WHERE c.jobApp.id = :jobAppId";
        return entityManager.createQuery(jpql, CandidatJobApp.class)
                .setParameter("jobAppId", jobAppId)
                .getResultList();
    }
}
