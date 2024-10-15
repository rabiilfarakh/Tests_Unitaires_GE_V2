package repository;

import dao.GenericDaoImpl;
import entity.Leave;
import jakarta.persistence.EntityManager;

import java.util.UUID;

public class LeaveRepository extends GenericDaoImpl<Leave,UUID> {
    public LeaveRepository(Class<Leave> entityClass, EntityManager entityManager) {
        super(entityClass, entityManager);
    }
}
