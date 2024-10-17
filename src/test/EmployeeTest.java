
import entity.Employee;
import enums.Role;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import repository.impl.EmployeeRepositoryImpl;
import service.impl.EmployeeServiceImpl;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
        import static org.mockito.Mockito.*;

class EmployeeTest {

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @Mock
    private EmployeeRepositoryImpl employeeRepository;

    private Employee employee;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        employee = new Employee();
        employee.setId(UUID.randomUUID());
        employee.setName("John Doe");
        employee.setEmail("john@example.com");
        employee.setAddress("123 Main St");
        employee.setPhoneNumber("1234567890");
        employee.setRole(Role.employee);
        employee.setSalary(5500.0);
        employee.setNumberOfChildren(2);
        employee.setJobPosition("Developer");
        employee.setHireDate(new Date());
        employee.setCnss("CNSS123");
        employee.setDepartment("IT");
        employee.setLeaveBalance(10);
    }

    @Test
    void createEmployee() {
        employeeService.create(employee);
        verify(employeeRepository, times(1)).save(employee);
    }

    @Test
    void updateEmployee() {
        employeeService.update(employee);
        verify(employeeRepository, times(1)).update(employee);
    }

    @Test
    void getAllEmployees() {
        List<Employee> employees = Arrays.asList(employee);
        when(employeeRepository.findAll()).thenReturn(employees);

        List<Employee> result = employeeService.findAll();
        assertEquals(1, result.size());
        assertEquals(employee, result.get(0));
    }

    @Test
    void getEmployee() {
        UUID employeeId = employee.getId();
        when(employeeRepository.findById(employeeId)).thenReturn(Optional.of(employee));

        Employee result = employeeService.findById(employeeId);
        assertNotNull(result);
        assertEquals(employee, result);
    }


    @Test
    void deleteEmployee() {
        UUID employeeId = employee.getId();
        when(employeeRepository.findById(employeeId)).thenReturn(Optional.of(employee));

        employeeService.delete(employeeId);
        verify(employeeRepository, times(1)).delete(employee);
    }

}
