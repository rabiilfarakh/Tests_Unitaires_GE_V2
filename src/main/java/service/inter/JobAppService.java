package service.inter;

import entity.JobApp;
import enums.JobAppStatus;
import java.util.List;
import java.util.UUID;

public interface JobAppService {

    void create(JobApp jobApp);

    void update(JobApp jobApp);

    List<JobApp> findAll();

    JobApp findById(UUID id);

    void delete(UUID id);

    List<JobApp> filterJobAppBySkills(String skills);
}
