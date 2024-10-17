package entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "candidat_job_app")
public class CandidatJobApp {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "candidat_id", nullable = false)
    private Candidat candidat;

    @ManyToOne
    @JoinColumn(name = "job_app_id", nullable = false)
    private JobApp jobApp;

    private LocalDateTime appliedAt;

    public CandidatJobApp() {}

    public CandidatJobApp(Candidat candidat, JobApp jobApp, LocalDateTime appliedAt) {
        this.candidat = candidat;
        this.jobApp = jobApp;
        this.appliedAt = appliedAt;
    }

    public CandidatJobApp(Candidat candidat, JobApp jobApp) {
        this.candidat = candidat;
        this.jobApp = jobApp;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Candidat getCandidat() {
        return candidat;
    }

    public void setCandidat(Candidat candidat) {
        this.candidat = candidat;
    }

    public JobApp getJobApp() {
        return jobApp;
    }

    public void setJobApp(JobApp jobApp) {
        this.jobApp = jobApp;
    }

    public LocalDateTime getAppliedAt() {
        return appliedAt;
    }

    public void setAppliedAt(LocalDateTime appliedAt) {
        this.appliedAt = appliedAt;
    }
}
