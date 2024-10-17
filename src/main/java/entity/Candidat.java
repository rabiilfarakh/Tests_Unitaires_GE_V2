package entity;

import enums.Role;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Candidat extends User {

    private String cv;

    @OneToMany(mappedBy = "candidat", cascade = CascadeType.ALL)
    private List<CandidatJobApp> jobApplications;

    public Candidat(String name, String email, String address, String phoneNumber, Role role, String cv) {
        super(name, email, address, phoneNumber, role);
        this.cv = cv;
    }

    public Candidat() {}

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    public List<CandidatJobApp> getJobApplications() {
        return jobApplications;
    }

    public void setJobApplications(List<CandidatJobApp> jobApplications) {
        this.jobApplications = jobApplications;
    }
}
