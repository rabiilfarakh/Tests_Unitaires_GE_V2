package repository;

import dao.GenericDaoImpl;
import entity.Employee;

import jakarta.enterprise.context.RequestScoped;

import java.util.UUID;

@RequestScoped
public class EmployeeRepository extends GenericDaoImpl<Employee, UUID> {

    public EmployeeRepository() {
        super(Employee.class);
    }
}
