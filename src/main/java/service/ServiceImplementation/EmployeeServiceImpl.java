package service.ServiceImplementation;

import entity.Employee;
import service.ServiceInterface.EmployeeService;

import java.util.List;
import java.util.UUID;

public class EmployeeServiceImpl implements EmployeeService {


    @Override
    public void createEmployee(Employee Employee) {

    }

    @Override
    public void updateEmployee(Employee Employee) {

    }

    @Override
    public List<Employee> getAllEmployees() {
        return List.of();
    }

    @Override
    public Employee getEmployee(UUID EmployeeId) {
        return null;
    }

    @Override
    public void deleteEmployee(UUID EmployeeId) {

    }
}
