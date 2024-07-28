package pl.coderslab.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

//    @ManyToOne
//    @JoinColumn(name = "employee_id")
//    private User employee;

    @Column(name = "date_of_order")
    private LocalDateTime dateOfOrder;

    private String descriptionOfTheProblem;
    private int status;

    @Column(name = "date_of_end")
    private LocalDateTime dateOfEnd;

    @OneToMany(mappedBy = "repair")
    private Set<RepairDetails> repairDetails = new HashSet<>();

    public Repair() {
    }

    public Repair(Long id, User client, Computer computer, LocalDateTime dateOfOrder, String descriptionOfTheProblem, int status, LocalDateTime dateOfEnd, Set<RepairDetails> repairDetails) {
        this.id = id;
        this.client = client;
        this.computer = computer;
        this.dateOfOrder = dateOfOrder;
        this.descriptionOfTheProblem = descriptionOfTheProblem;
        this.status = status;
        this.dateOfEnd = dateOfEnd;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public LocalDateTime getDateOfEnd() {
        return dateOfEnd;
    }

    public void setDateOfEnd(LocalDateTime dateOfEnd) {
        this.dateOfEnd = dateOfEnd;
    }

    public Set<RepairDetails> getRepairDetails() {
        return repairDetails;
    }

    public void setRepairDetails(Set<RepairDetails> repairDetails) {
        this.repairDetails = repairDetails;
    }
}