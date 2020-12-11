package com.example.demo.model;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Set;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;

    @Pattern(regexp="(^$|[0-9]{10})")
    private String phoneNumber;

    private String address;

    @NotEmpty
    @Email
    private String email;

    @Min(18)
    private Integer age;

    private Integer status;

    @NotBlank
    @NotEmpty
    private String username;

    @NotBlank
    @NotEmpty
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;
}
