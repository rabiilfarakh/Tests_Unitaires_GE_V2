package repository.inter;

import entity.JobApp;

import java.util.List;

public interface JobAppRepositoryInf{

    public List<JobApp> filterJobAppBySkills(String skills);
}
