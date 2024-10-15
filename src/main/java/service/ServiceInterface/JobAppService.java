package service.ServiceInterface;

import entity.JobApp;
import enums.JobAppStatus;
import java.util.List;
import java.util.UUID;

public interface JobAppService {

    void createJobApp(JobApp application);

    List<JobApp> findAllJobApp();

    JobApp findJobAppById(UUID id);

    void updateJobAppStatus(UUID id, JobAppStatus status);

    List<JobApp> filterJobAppBySkills(String skills);
}
