package entity;

import enums.JobAppStatus;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "applications")
public class JobApp {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String email;
    private String skills;

    @Enumerated(EnumType.STRING)
    private enums.JobAppStatus jobAppStatus;

    private LocalDateTime submissionDate;

    @ManyToOne
    @JoinColumn(name = "recruitment_id")
    private Recruitment recruitment;

    @OneToMany(mappedBy = "jobApp", cascade = CascadeType.ALL)
    private List<CandidatJobApp> jobCandidates;

    public JobApp() {}

    public JobApp(String name, String email, String skills, enums.JobAppStatus jobAppStatus,
                  LocalDateTime submissionDate, Recruitment recruitment) {
        this.name = name;
        this.email = email;
        this.skills = skills;
        this.jobAppStatus = jobAppStatus;
        this.submissionDate = submissionDate;
        this.recruitment = recruitment;
    }


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public JobAppStatus getJobAppStatus() {
        return jobAppStatus;
    }

    public void setJobAppStatus(JobAppStatus jobAppStatus) {
        this.jobAppStatus = jobAppStatus;
    }

    public LocalDateTime getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(LocalDateTime submissionDate) {
        this.submissionDate = submissionDate;
    }

    public Recruitment getRecruitment() {
        return recruitment;
    }

    public void setRecruitment(Recruitment recruitment) {
        this.recruitment = recruitment;
    }

    public List<CandidatJobApp> getJobCandidates() {
        return jobCandidates;
    }

    public void setJobCandidates(List<CandidatJobApp> jobCandidates) {
        this.jobCandidates = jobCandidates;
    }
}
