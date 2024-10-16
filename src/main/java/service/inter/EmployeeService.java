package service.inter;

import entity.Employee;

import java.util.List;
import java.util.UUID;

public interface EmployeeService {

    Employee createEmployee(Employee Employee);

    void updateEmployee(Employee Employee);

    List<Employee> getAllEmployees();

    Employee getEmployee(UUID EmployeeId);

    void deleteEmployee(UUID EmployeeId);

}
