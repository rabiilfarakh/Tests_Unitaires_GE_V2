package repository;

import dao.GenericDaoImpl;
import entity.User;
import jakarta.persistence.EntityManager;

import java.util.UUID;

public class UserRepository extends GenericDaoImpl<User,UUID> {
    public UserRepository(Class<User> entityClass, EntityManager entityManager) {
        super(entityClass, entityManager);
    }
}
