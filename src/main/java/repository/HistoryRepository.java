package repository;

import dao.GenericDaoImpl;
import entity.History;
import jakarta.persistence.EntityManager;

import java.util.UUID;

public class HistoryRepository extends GenericDaoImpl<History, UUID> {
    public HistoryRepository(Class<History> entityClass, EntityManager entityManager) {
        super(entityClass, entityManager);
    }
}
