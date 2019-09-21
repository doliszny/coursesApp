package pl.project.courses.model;

import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "{pl.project.courses.model.firstName.NotEmpty}")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Błędne imie")
    private String firstName;
    @NotEmpty(message = "{pl.project.courses.model.lastName.NotEmpty}")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Nazwisko sklada sie z literek")

    private String lastName;

    @NotEmpty(message = "{pl.project.courses.model.mail.NotEmpty}")
    @Email(message = "Bledny e-mail")
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "zly format maila")
    private String mail;
    private String phone;
    private String course;
    private String mode;

    @Column(unique = true)
    private String username;
    private String password;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }
}
