package pl.coderslab.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "repair_details")
public class RepairDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dateStartRepair;
    private LocalDateTime dateEndRepair;
    private String descriptionOfRepair;
    private int status;
    private double price;

    public RepairDetails() {
    }

    public RepairDetails(Long id, LocalDateTime dateStartRepair, LocalDateTime dateEndRepair, String descriptionOfRepair, int status, double price) {
        this.id = id;
        this.dateStartRepair = dateStartRepair;
        this.dateEndRepair = dateEndRepair;
        this.descriptionOfRepair = descriptionOfRepair;
        this.status = status;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDateStartRepair() {
        return dateStartRepair;
    }

    public void setDateStartRepair(LocalDateTime dateStartRepair) {
        this.dateStartRepair = dateStartRepair;
    }

    public LocalDateTime getDateEndRepair() {
        return dateEndRepair;
    }

    public void setDateEndRepair(LocalDateTime dateEndRepair) {
        this.dateEndRepair = dateEndRepair;
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
}
