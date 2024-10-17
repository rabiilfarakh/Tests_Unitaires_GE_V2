package service;

import entity.Employee;
import entity.Leave;
import enums.StatusLeave;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import repository.impl.LeaveRepositoryImpl;

import jakarta.persistence.EntityManager;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LeaveTest {

    @Mock
    private LeaveRepositoryImpl leaveRepository;

    @Mock
    private EntityManager entityManager;

    @InjectMocks
    private service.LeaveServiceImpl leaveService;

    private Employee employee;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        employee = new Employee();
        employee.setLeaveBalance(20);
    }

    @Test
    void testRequestLeave_Success() {
        LocalDateTime startDate = LocalDateTime.now();
        String reason = "Medical";
        Integer duration = 5;

        String result = leaveService.requestLeave(employee, startDate, duration, reason);

        assertEquals("Leave request submitted successfully.", result);
        assertEquals(15, employee.getLeaveBalance()); // Leave balance should be reduced
        verify(leaveRepository, times(1)).save(any(Leave.class));
        verify(entityManager, times(1)).merge(employee);
    }

    @Test
    void testRequestLeave_NotEnoughLeaveDays() {
        LocalDateTime startDate = LocalDateTime.now();
        String reason = "Vacation";
        Integer duration = 25; // Exceeds available leave balance

        String result = leaveService.requestLeave(employee, startDate, duration, reason);

        assertEquals("Not enough leave days available.", result);
        verify(leaveRepository, never()).save(any(Leave.class)); // No save should occur
    }

    @Test
    void testAcceptLeave_Success() {
        UUID requestId = UUID.randomUUID();
        Leave leave = new Leave();
        leave.setRequestId(requestId);
        leave.setStatus(StatusLeave.PENDING);

        when(leaveRepository.findById(requestId)).thenReturn(Optional.of(leave));

        leaveService.acceptLeave(requestId);

        assertEquals(StatusLeave.ACCEPTED, leave.getStatus());
        verify(leaveRepository, times(1)).update(leave);
    }

}
