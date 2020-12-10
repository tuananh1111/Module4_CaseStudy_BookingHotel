package com.example.demo.service;

import com.example.demo.model.User;

import java.util.List;
import java.util.Optional;

public interface IGenerateService<T> {
    List<T> findAll();

    void save(T user);

    void delete(Long id);

    Optional<T> findById(Long id);
}
