package service.inter;

import entity.Employee;

import java.util.List;
import java.util.UUID;

public interface EmployeeService {

    void create(Employee Employee);

    void update(Employee Employee);

    List<Employee> findAll();

    Employee findById(UUID id);

    void delete(UUID id);

}
