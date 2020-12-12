package com.example.demo.service.room;

import com.example.demo.model.ImageForm;
import com.example.demo.model.Room;
import com.example.demo.repository.room.IRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Service
public class RoomServiceImpl implements RoomService{
    @Autowired
    private IRoomRepository roomRepository;


    @Override
    public List<Room> findAll() {
        return roomRepository.findAll();
    }

    @Override
    public void save(Room user) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Optional<Room> findById(Long id) {
        return Optional.empty();
    }
}
