package service.inter;

import entity.Leave;
import enums.StatusLeave;

import java.util.List;
import java.util.UUID;

public interface LeaveService {

    void createLeave(Leave Leave);

    void updateLeave(Leave Leave);

    List<Leave> getAllLeaves();

    Leave getLeave(UUID LeaveId);

    void deleteLeave(UUID LeaveId);

    void updateStatus(UUID leaveId, StatusLeave newStatus);

}
