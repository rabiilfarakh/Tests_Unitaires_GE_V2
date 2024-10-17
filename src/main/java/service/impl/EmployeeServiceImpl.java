package service.impl;

import entity.Employee;
import repository.impl.EmployeeRepositoryImpl;
import service.inter.EmployeeService;


import jakarta.enterprise.context.RequestScoped;

import javax.inject.Inject;
import java.util.List;
import java.util.UUID;

@RequestScoped
public class EmployeeServiceImpl implements EmployeeService {

    @Inject
    private EmployeeRepositoryImpl employeeRepository;

    @Override
    public void create(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void update(Employee employee) {
        employeeRepository.update(employee);
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(UUID id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(UUID id) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        if (employee != null) {
            employeeRepository.delete(employee);
        }
    }
}
