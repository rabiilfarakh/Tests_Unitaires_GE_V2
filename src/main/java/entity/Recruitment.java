package entity;

import jakarta.persistence.*;
import java.util.UUID;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "recruitments")
public class Recruitment {
    @Id
    @GeneratedValue
    private UUID id;
    private String title;
    private String description;
    private String requiredSkills;
    private LocalDateTime datePublish;
    private LocalDateTime dateEnd;
    private boolean isActive;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @OneToMany(mappedBy = "recruitment" , cascade = CascadeType.ALL)
    private List<JobApp> JobApp = new ArrayList<>();

    public Recruitment(String title, String description, String requiredSkills, LocalDateTime datePublish, LocalDateTime dateEnd, boolean isActive, Employee employee, List<JobApp> JobApp) {
        this.title = title;
        this.description = description;
        this.requiredSkills = requiredSkills;
        this.datePublish = datePublish;
        this.dateEnd = dateEnd;
        this.isActive = isActive;
        this.employee = employee;
        this.JobApp = JobApp;
    }
    public Recruitment() {}

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRequiredSkills() {
        return requiredSkills;
    }

    public void setRequiredSkills(String requiredSkills) {
        this.requiredSkills = requiredSkills;
    }

    public LocalDateTime getDatePublish() {
        return datePublish;
    }

    public void setDatePublish(LocalDateTime datePublish) {
        this.datePublish = datePublish;
    }

    public LocalDateTime getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(LocalDateTime dateEnd) {
        this.dateEnd = dateEnd;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public List<JobApp> getJobApps() {
        return JobApp;
    }

    public void setJobApps(List<JobApp> JobApp) {
        this.JobApp = JobApp;
    }
}
