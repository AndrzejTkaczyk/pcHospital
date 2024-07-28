package pl.coderslab.domain;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
@Table(name = "repair_details")
public class RepairDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private User employee;
    @NotBlank
    private String descriptionOfRepair;
    private int status;
    private double price;
    @ManyToOne
    private Repair repair;

    public RepairDetails() {
    }

    public RepairDetails(Long id, User employee, String descriptionOfRepair, int status, double price, Repair repair) {
        this.id = id;
        this.employee = employee;
        this.descriptionOfRepair = descriptionOfRepair;
        this.status = status;
        this.price = price;
        this.repair = repair;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getEmployee() {
        return employee;
    }

    public void setEmployee(User employee) {
        this.employee = employee;
    }

    public String getDescriptionOfRepair() {
        return descriptionOfRepair;
    }

    public void setDescriptionOfRepair(String descriptionOfRepair) {
        this.descriptionOfRepair = descriptionOfRepair;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Repair getRepair() {
        return repair;
    }

    public void setRepair(Repair repair) {
        this.repair = repair;
    }
}
