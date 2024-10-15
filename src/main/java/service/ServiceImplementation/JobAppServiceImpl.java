package service.ServiceImplementation;

import entity.JobApp;
import enums.JobAppStatus;
import service.ServiceInterface.JobAppService;

import java.util.List;
import java.util.UUID;

public class JobAppServiceImpl implements JobAppService {


    @Override
    public void createJobApp(JobApp application) {

    }

    @Override
    public List<JobApp> findAllJobApp() {
        return List.of();
    }

    @Override
    public JobApp findJobAppById(UUID id) {
        return null;
    }

    @Override
    public void updateJobAppStatus(UUID id, JobAppStatus status) {

    }

    @Override
    public List<JobApp> filterJobAppBySkills(String skills) {
        return List.of();
    }
}
