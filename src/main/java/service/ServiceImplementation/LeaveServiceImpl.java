package service.ServiceImplementation;

import entity.Leave;
import enums.StatusLeave;
import service.ServiceInterface.LeaveService;

import java.util.List;
import java.util.UUID;

public class LeaveServiceImpl implements LeaveService {


    @Override
    public void createLeave(Leave Leave) {

    }

    @Override
    public void updateLeave(Leave Leave) {

    }

    @Override
    public List<Leave> getAllLeaves() {
        return List.of();
    }

    @Override
    public Leave getLeave(UUID LeaveId) {
        return null;
    }

    @Override
    public void deleteLeave(UUID LeaveId) {

    }

    @Override
    public void updateStatus(UUID leaveId, StatusLeave newStatus) {

    }
}
