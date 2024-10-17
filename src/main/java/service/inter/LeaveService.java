package service.inter;

import entity.Employee;
import entity.Leave;
import enums.StatusLeave;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface LeaveService {

    String requestLeave(Employee employee, LocalDateTime startDate, Integer duration, String reason);

    void acceptLeave(UUID requestId);

    void rejectLeave(UUID requestId);

    Leave getLeaveById(UUID requestId);

}
