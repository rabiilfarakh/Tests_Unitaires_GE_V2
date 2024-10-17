package repository.impl;

import dao.GenericDaoImpl;
import entity.JobApp;
import jakarta.enterprise.context.RequestScoped;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import repository.inter.JobAppRepositoryInf;

import javax.inject.Inject;
import java.util.List;
import java.util.UUID;

@RequestScoped
public class JobAppRepositoryImpl extends GenericDaoImpl<JobApp, UUID> implements JobAppRepositoryInf {

    @Inject
    private EntityManager entityManager;

    public JobAppRepositoryImpl() {
        super(JobApp.class);
    }

    @Override
    public List<JobApp> filterJobAppBySkills(String skills) {
        try {
            String jpql = "SELECT j FROM JobApp j WHERE j.contrat = :skills";
            TypedQuery<JobApp> query = entityManager.createQuery(jpql, JobApp.class);
            query.setParameter("contrat", skills);
            return query.getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Error filtering job applications: " + e.getMessage(), e);
        }
    }
}
