package pl.coderslab.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "repairs")
public class Repair {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;

    @OneToOne
    private Computer computer;


    @ManyToOne
    @JoinColumn(name = "employee_id")
    private User employee;

    @Column(name = "date_of_order")
    private LocalDateTime dateOfOrder;
    private String descriptionOfTheProblem;
    @OneToOne
    private RepairDetails repairDetails;

    public Repair() {
    }

    public Repair(Long id, User client, Computer computer, User employee, LocalDateTime dateOfOrder, String descriptionOfTheProblem, RepairDetails repairDetails) {
        this.id = id;
        this.client = client;
        this.computer = computer;
        this.employee = employee;
        this.dateOfOrder = dateOfOrder;
        this.descriptionOfTheProblem = descriptionOfTheProblem;
        this.repairDetails = repairDetails;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    public User getEmployee() {
        return employee;
    }

    public void setEmployee(User employee) {
        this.employee = employee;
    }

    public LocalDateTime getDateOfOrder() {
        return dateOfOrder;
    }

    public void setDateOfOrder(LocalDateTime dateOfOrder) {
        this.dateOfOrder = dateOfOrder;
    }

    public String getDescriptionOfTheProblem() {
        return descriptionOfTheProblem;
    }

    public void setDescriptionOfTheProblem(String descriptionOfTheProblem) {
        this.descriptionOfTheProblem = descriptionOfTheProblem;
    }

    public RepairDetails getRepairDetails() {
        return repairDetails;
    }

    public void setRepairDetails(RepairDetails repairDetails) {
        this.repairDetails = repairDetails;
    }
}
