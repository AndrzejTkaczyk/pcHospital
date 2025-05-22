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
    @Column(name = "date_of_order")
    private LocalDateTime dateOfOrder;
    private String descriptionOfTheProblem;
    private int status;
    @Column(name = "date_of_end")
    private LocalDateTime dateOfEnd;
    @ManyToOne
    private Computer computer;
    @OneToMany(mappedBy = "repair")
    private List<RepairDetails> repairDetails = new ArrayList<>();

    public Repair() {
    }

    public Repair(Long id, LocalDateTime dateOfOrder, String descriptionOfTheProblem, int status, LocalDateTime dateOfEnd, Computer computer, List<RepairDetails> repairDetails) {
        this.id = id;
        this.dateOfOrder = dateOfOrder;
        this.descriptionOfTheProblem = descriptionOfTheProblem;
        this.status = status;
        this.dateOfEnd = dateOfEnd;
        this.computer = computer;
        this.repairDetails = repairDetails;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    public List<RepairDetails> getRepairDetails() {
        return repairDetails;
    }

    public void setRepairDetails(List<RepairDetails> repairDetails) {
        this.repairDetails = repairDetails;
    }

    public String getDateOfOrderFormat() {
        return dateOfOrder.getDayOfMonth() + "." + dateOfOrder.getMonthValue() + "." +dateOfOrder.getYear() + "r. godz. " + dateOfOrder.getHour() + ":" + dateOfOrder.getMinute();
    }

    public String getDateOfEndFormat() {
        if (dateOfEnd == null) {
            return "Nie ustalono";
        }
        return dateOfEnd.getDayOfMonth() + "." + dateOfEnd.getMonthValue() + "." +dateOfEnd.getYear() + "r. godz. " + dateOfEnd.getHour() + ":" + dateOfEnd.getMinute();
    }
}