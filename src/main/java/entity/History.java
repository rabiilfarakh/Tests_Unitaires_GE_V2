package entity;


import java.time.LocalDateTime;
import java.util.UUID;
import jakarta.persistence.*;

@Entity
@Table(name = "history")
public class History{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)

    private UUID id;

    private LocalDateTime updatedAt;
    private String updatedColumn;
    private String oldValue;
    private String newValue;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;


    public History(LocalDateTime updatedAt, String updatedColumn, String oldValue, String newValue, Employee employee) {
        this.updatedAt = updatedAt;
        this.updatedColumn = updatedColumn;
        this.oldValue = oldValue;
        this.newValue = newValue;
        this.employee = employee;
    }
    public History() {}

}
