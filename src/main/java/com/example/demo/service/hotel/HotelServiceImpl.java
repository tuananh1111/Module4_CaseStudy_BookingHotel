package com.example.demo.service.hotel;

import com.example.demo.model.Hotel;
import com.example.demo.repository.hotel.IHotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.Holder;
import java.util.List;
import java.util.Optional;

@Service
public class HotelServiceImpl implements IHotelService {
    @Autowired
    private IHotelRepository hotelRepository;
    @Override
    public List<Hotel> findAll() {
        return hotelRepository.findAll();
    }

    @Override
    public void save(Hotel user) {
        hotelRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        Hotel hotel= hotelRepository.findHotelById(id);
        hotel.setStatus(false);
        hotelRepository.save(hotel);
    }
    @Override
    public void activeUser(Long id){
        Hotel hotel= hotelRepository.findHotelById(id);
        hotel.setStatus(true);
        hotelRepository.save(hotel);
    }

    @Override
    public Optional<Hotel> findById(Long id) {
        return hotelRepository.findById(id);
    }
    @Override
    public Optional<Hotel> findByName(String name){
        return hotelRepository.findHotelsByNameContaining(name);
    }

    @Override
    public Hotel findOne(Long id) {
        return hotelRepository.findHotelById(id);
    }

}
