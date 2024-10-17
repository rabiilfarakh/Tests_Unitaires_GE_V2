package service.impl;

import entity.JobApp;
import jakarta.enterprise.context.RequestScoped;
import repository.impl.JobAppRepositoryImpl;
import service.inter.JobAppService;

import javax.inject.Inject;
import java.util.List;
import java.util.UUID;

@RequestScoped
public class JobAppServiceImpl implements JobAppService {

    @Inject
    private JobAppRepositoryImpl jobAppRepository;

    @Override
    public void create(JobApp jobApp) {
       jobAppRepository.save(jobApp);
    }

    @Override
    public void update(JobApp jobApp) {
        jobAppRepository.update(jobApp);
    }

    @Override
    public List<JobApp> findAll() {
        return jobAppRepository.findAll();
    }

    @Override
    public JobApp findById(UUID id) {
        return jobAppRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(UUID id) {
        JobApp jobApp = jobAppRepository.findById(id).orElse(null);
        if (jobApp != null) {
            jobAppRepository.delete(jobApp);
        }
    }

    @Override
    public List<JobApp> filterJobAppBySkills(String skills) {
        return jobAppRepository.filterJobAppBySkills(skills);
    }

}
