package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity
@Data
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String addressDetails;

    @Pattern(regexp="(^$|[0-9]{10})")
    private String hotline;

    private String description;
    private boolean status;
    private String image;

    @ManyToOne
    private Province province;

    @ManyToOne
    private User user;

    public Hotel() {
    }

    public Hotel(Long id, @NotBlank String name, @NotBlank String addressDetails, @Pattern(regexp = "(^$|[0-9]{10})") String hotline, String description, boolean status, Province province, User user) {
        this.id = id;
        this.name = name;
        this.addressDetails = addressDetails;
        this.hotline = hotline;
        this.description = description;
        this.status = status;
        this.province = province;
        this.user = user;
    }

    public Hotel(@NotBlank String name, @NotBlank String addressDetails, @Pattern(regexp = "(^$|[0-9]{10})") String hotline, String description, boolean status, Province province, User user) {
        this.name = name;
        this.addressDetails = addressDetails;
        this.hotline = hotline;
        this.description = description;
        this.status = status;
        this.province = province;
        this.user = user;
    }
}
