package repository.inter;

import entity.Candidat;
import entity.JobApp;

import java.util.List;

public interface JobAppRepositoryInter{

    List<JobApp> filterJobAppBySkills(String skills);
    void jobApply(Candidat candidat);
}
