package repository.impl;

import dao.GenericDaoImpl;
import entity.Employee;

import jakarta.enterprise.context.RequestScoped;

import java.util.UUID;

@RequestScoped
public class EmployeeRepositoryImpl extends GenericDaoImpl<Employee, UUID> {

    public EmployeeRepositoryImpl() {
        super(Employee.class);
    }
}
