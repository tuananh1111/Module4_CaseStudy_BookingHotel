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

    @ManyToOne
    private Province province;

    @ManyToOne
    private User user;

}
