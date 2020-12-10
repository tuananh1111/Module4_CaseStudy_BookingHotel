package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Data
public class OrderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne(fetch = FetchType.EAGER)
    private Orders orders;


    @ManyToOne(fetch = FetchType.EAGER)
    private Room room;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateBegin;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateFinish;

    private Double discount;
}
