package com.example.grievancetrack.citizen.entit;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "citizens")
public class Citizen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long citizenId;

    @NotBlank(message = "Name is required")
    private String name;

    @Email(message = "Enter a valid email")
    @NotBlank(message = "Email is required")
    private String email;

    private String phone;

    public Citizen() {
    }

    public Citizen(Long citizenId, String name, String email, String phone) {
        this.citizenId = citizenId;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public Long getCitizenId() {
        return citizenId;
    }

    public void setCitizenId(Long citizenId) {
        this.citizenId = citizenId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}