package service.impl;

import entity.Employee;
import repository.EmployeeRepository;
import service.inter.EmployeeService;


import jakarta.enterprise.context.RequestScoped;

import javax.inject.Inject;
import java.util.List;
import java.util.UUID;

@RequestScoped
public class EmployeeServiceImpl implements EmployeeService {

    @Inject
    private EmployeeRepository employeeRepository;

    @Override
    public Employee createEmployee(Employee employee) {
        employeeRepository.save(employee);
        return employee;
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeRepository.update(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployee(UUID employeeId) {
        return employeeRepository.findById(employeeId).orElse(null);
    }

    @Override
    public void deleteEmployee(UUID employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElse(null);
        if (employee != null) {
            employeeRepository.delete(employee);
        }
    }
}
