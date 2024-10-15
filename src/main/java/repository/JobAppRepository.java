package repository;

import dao.GenericDaoImpl;
import entity.JobApp;
import jakarta.persistence.EntityManager;

import java.util.UUID;

public class JobAppRepository extends GenericDaoImpl<JobApp, UUID> {
    public JobAppRepository(Class<JobApp> entityClass, EntityManager entityManager) {
        super(entityClass, entityManager);
    }
}
