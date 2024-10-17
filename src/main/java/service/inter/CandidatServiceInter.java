package service.inter;

import entity.Candidat;
import entity.JobApp;

public interface CandidatServiceInter {
    public void applyForJob(Candidat candidat, JobApp jobApp);
}
