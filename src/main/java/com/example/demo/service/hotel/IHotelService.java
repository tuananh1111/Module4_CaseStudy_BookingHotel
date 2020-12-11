package com.example.demo.service.hotel;

import com.example.demo.model.Hotel;
import com.example.demo.service.IGenerateService;

import java.util.Optional;

public interface IHotelService extends IGenerateService<Hotel> {
    Optional<Hotel> findByName(String name);
    Hotel findOne(Long id);
    void activeUser(Long id);
}
