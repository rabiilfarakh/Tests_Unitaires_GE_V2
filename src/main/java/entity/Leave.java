package entity;


import enums.StatusLeave;
import jakarta.persistence.*;
import java.util.UUID;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "leave")
public class Leave {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID requestId;

    @Column(name = "start_date")
    private LocalDateTime startDate;


    @Column(name = "duration")
    private Integer duration;

    @Column(name = "certificate")
    private String certificate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StatusLeave status;

    @Column(name = "reason")
    private String reason;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;


    public Leave(LocalDateTime startDate, Integer duration, String certificate, StatusLeave status, String reason, Employee employee) {
        this.startDate = startDate;
        this.duration = duration;
        this.certificate = certificate;
        this.status = status;
        this.reason = reason;
        this.employee = employee;
    }

    public Leave() {
    }

    public UUID getRequestId() {
        return requestId;
    }

    public void setRequestId(UUID requestId) {
        this.requestId = requestId;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public StatusLeave getStatus() {
        return status;
    }

    public void setStatus(StatusLeave status) {
        this.status = status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}