package pl.coderslab.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "repairs")
public class Repairs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Clients clients;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "employees_repairs",
            joinColumns = {@JoinColumn(name = "computers_id")},
            inverseJoinColumns = {@JoinColumn(name = "employees_id")})
    private Set<Employees> employees = new HashSet<>();
    private LocalDateTime dateOfOrder;
    private String descriptionOfTheProblem;
    @OneToOne
    private RepairDetails repairDetails;

    public Repairs() {
    }

    public Repairs(Long id, Clients clients, Set<Employees> employees, LocalDateTime dateOfOrder, String descriptionOfTheProblem, RepairDetails repairDetails) {
        this.id = id;
        this.clients = clients;
        this.employees = employees;
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

    public Clients getClients() {
        return clients;
    }

    public void setClients(Clients clients) {
        this.clients = clients;
    }

    public Set<Employees> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employees> employees) {
        this.employees = employees;
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
