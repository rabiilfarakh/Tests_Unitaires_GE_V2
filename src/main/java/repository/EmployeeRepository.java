package repository;

import dao.GenericDaoImpl;
import entity.Employee;
import jakarta.persistence.EntityManager;

import java.util.UUID;

public class EmployeeRepository extends GenericDaoImpl<Employee, UUID> {
    public EmployeeRepository(Class<Employee> entityClass, EntityManager entityManager) {
        super(entityClass, entityManager);
    }
}
