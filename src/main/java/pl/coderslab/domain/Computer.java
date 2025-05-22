package pl.coderslab.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "computers")
public class Computer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private String brand;
    private String model;
    private int serial_number;
    private int status;
    @ManyToOne
    private User client;
    @OneToMany(mappedBy = "computer")
    private List<Repair> repairs = new ArrayList<>();

    public Computer() {
    }

    public Computer(Long id, String type, String brand, String model, int serial_number, int status, User client, List<Repair> repairs) {
        this.id = id;
        this.type = type;
        this.brand = brand;
        this.model = model;
        this.serial_number = serial_number;
        this.status = status;
        this.client = client;
        this.repairs = repairs;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSerial_number() {
        return serial_number;
    }

    public void setSerial_number(int serial_number) {
        this.serial_number = serial_number;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public List<Repair> getRepairs() {
        return repairs;
    }

    public void setRepairs(List<Repair> repairs) {
        this.repairs = repairs;
    }

    public String getDetailComputer() {
        return brand + " - " + model + " - " + type;
    }
}