package service;

import entity.Employee;
import entity.Leave;
import enums.StatusLeave;
import repository.impl.LeaveRepositoryImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import javax.inject.Inject;
import java.time.LocalDateTime;
import java.util.UUID;

public class LeaveServiceImpl implements service.inter.LeaveService {

    @Inject
    private LeaveRepositoryImpl leaveRepository;

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public String requestLeave(Employee employee, LocalDateTime startDate, Integer duration, String reason) {
        if (duration > employee.getLeaveBalance()) {
            return "Not enough leave days available.";
        }

        Leave leave = new Leave();
        leave.setStartDate(startDate);
        leave.setDuration(duration);
        leave.setStatus(StatusLeave.PENDING);
        leave.setReason(reason);
        leave.setEmployee(employee);

        leaveRepository.save(leave);

        employee.setLeaveBalance(employee.getLeaveBalance() - duration);
        entityManager.merge(employee);

        return "Leave request submitted successfully.";
    }

    @Override
    public void acceptLeave(UUID requestId) {
        Leave leave = leaveRepository.findById(requestId).orElseThrow(() -> new RuntimeException("Leave not found"));
        leave.setStatus(StatusLeave.ACCEPTED);
        leaveRepository.update(leave);
    }

    @Override
    public void rejectLeave(UUID requestId) {
        Leave leave = leaveRepository.findById(requestId).orElseThrow(() -> new RuntimeException("Leave not found"));
        leave.setStatus(StatusLeave.REJECTED);
        leaveRepository.update(leave);
    }

    @Override
    public Leave getLeaveById(UUID requestId) {
        return leaveRepository.findById(requestId).orElseThrow(() -> new RuntimeException("Leave not found"));
    }
}
