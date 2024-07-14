package pl.coderslab.domain;

import javax.persistence.*;

@Entity
@Table(name = "computers")
public class Computers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Clients clients;
    private String type;
    private String brand;
    private String model;
    private int serial_number;

    public Computers() {
    }

    public Computers(Long id, Clients clients, String type, String brand, String model, int serial_number) {
        this.id = id;
        this.clients = clients;
        this.type = type;
        this.brand = brand;
        this.model = model;
        this.serial_number = serial_number;
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
}
