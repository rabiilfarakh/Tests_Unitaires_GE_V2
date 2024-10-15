package entity;

import java.util.Date;
import java.util.List;

import enums.Role;
import jakarta.persistence.*;

@Entity
@Table(name = "employees")
public class Employee extends User{
    @Column(name = "salary" ,nullable = false)
    private double salary;

    @Column(name = "numberOfChildren", nullable = false)
    private int numberOfChildren;

    @Column(name = "jobPosition" , nullable = false)
    private String jobPosition;

    @Column(name = "hireDate" , nullable = false)
    private Date hireDate;

    @Column(name = "cnss", nullable = false, unique = true)
    private String cnss;

    @Column(name = "department" , nullable = false)
    private String department;

    @Column(name = "leaveBalance" , nullable = false)
    private Integer leaveBalance;

    @OneToMany(mappedBy = "employee" , cascade = CascadeType.ALL)
    private List<Leave> Leave;

    @OneToMany(mappedBy = "employee" , cascade = CascadeType.ALL)
    private List<History> historyUpdates;


    public Employee() {}

    public Employee(String name, String email, String address, String phoneNumber, Role role, double salary, int numberOfChildren, String jobPosition, Date hireDate, String cnss, String department, Integer leaveBalance) {
        super(name, email, address, phoneNumber, role);
        this.salary = salary;
        this.numberOfChildren = numberOfChildren;
        this.jobPosition = jobPosition;
        this.hireDate = hireDate;
        this.cnss = cnss;
        this.department = department;
        this.leaveBalance = leaveBalance;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getNumberOfChildren() {
        return numberOfChildren;
    }

    public void setNumberOfChildren(int numberOfChildren) {
        this.numberOfChildren = numberOfChildren;
    }

    public String getJobPosition() {
        return jobPosition;
    }

    public void setJobPosition(String jobPosition) {
        this.jobPosition = jobPosition;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public String getCnss() {
        return cnss;
    }

    public void setCnss(String cnss) {
        this.cnss = cnss;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Integer getLeaveBalance() {
        return leaveBalance;
    }

    public void setLeaveBalance(Integer leaveBalance) {
        this.leaveBalance = leaveBalance;
    }

    public List<entity.Leave> getLeave() {
        return Leave;
    }

    public void setLeave(List<entity.Leave> leave) {
        Leave = leave;
    }

    public List<History> getHistoryUpdates() {
        return historyUpdates;
    }

    public void setHistoryUpdates(List<History> historyUpdates) {
        this.historyUpdates = historyUpdates;
    }

    public double calculateFamilyAllocations() {
        double allocation = 0;

        if (numberOfChildren > 6) {
            numberOfChildren = 6;
        }

        if (salary < 6000.0) {
            if (numberOfChildren <= 3) {
                allocation = numberOfChildren * 300;
            } else {
                allocation = (3 * 300) + ((numberOfChildren - 3) * 150);
            }
        } else if (salary > 8000) {
            if (numberOfChildren <= 3) {
                allocation = numberOfChildren * 200;
            } else {
                allocation = (3 * 200) + ((numberOfChildren - 3) * 110);
            }
        }

        return allocation;
    }
}
