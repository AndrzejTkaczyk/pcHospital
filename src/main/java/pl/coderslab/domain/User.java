package pl.coderslab.domain;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Size(min = 2, max = 100)
    private String firstName;
    @NotBlank
    @Size(min = 2, max = 100)
    private String lastName;
    @NotBlank
//    @Email
    private String email;
    @NotBlank
    private String password;
    @NotBlank
    private String address;
    private int phone;
    @Column(name = "created_on")
    private LocalDateTime createdOn;
    private byte access;
    @OneToOne
    private Role role;

    public User() {
    }

    public User(Long id, String firstName, String lastName, String email, String password, String address, int phone, LocalDateTime createdOn, byte access, Role role) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.address = address;
        this.phone = phone;
        this.createdOn = createdOn;
        this.access = access;
        this.role = role;
    }

    public String getFirstNameAndLastName () {
        if (firstName.isEmpty() || lastName.isEmpty()) {
            return "Nie ustalono";
        }
        return firstName + " " + lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public byte getAccess() {
        return access;
    }

    public void setAccess(byte access) {
        this.access = access;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", phone=" + phone +
                ", createdOn=" + createdOn +
                ", access=" + access +
                ", role=" + role +
                '}';
    }
}



