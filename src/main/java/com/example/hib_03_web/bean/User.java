package com.example.hib_03_web.bean;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "USER")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "NAME", nullable = false)
    @Size(min = 3, max = 15)
    private String name;

    @Column(name = "PASSWORD", nullable = false)
    @Size(min = 8, message = "Please enter min 8 character")
    @Pattern(regexp = "^(?=.*[0-9](?=.*[a-z])(?=.*[A-Z]).*$)", message = "Please use at least a small and capital letter and a number")
    private String password;

    @Column(name = "EMAIL", nullable = false, length = 30)
    private String email;

    public User() {
    }

    public User(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
