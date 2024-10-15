package repository;

import dao.GenericDaoImpl;
import entity.Recruitment;
import jakarta.persistence.EntityManager;

import java.util.UUID;

public class RecruitmentRepository extends GenericDaoImpl<Recruitment,UUID> {
    public RecruitmentRepository(Class<Recruitment> entityClass, EntityManager entityManager) {
        super(entityClass, entityManager);
    }
}
