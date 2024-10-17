package service.impl;

import entity.Candidat;
import entity.JobApp;
import entity.CandidatJobApp;

import jakarta.enterprise.context.RequestScoped;
import repository.CandidatJobAppRepository;

import javax.inject.Inject;

@RequestScoped
public class CandidatServiceImpl {

    @Inject
    private CandidatJobAppRepository candidatJobAppRepository;

    public void applyForJob(Candidat candidat, JobApp jobApp) {
        CandidatJobApp candidatJobApp = new CandidatJobApp(candidat, jobApp);
        candidatJobAppRepository.applyForJob(candidatJobApp);
    }
}
