package com.example.demo.controller;

import com.example.demo.model.Hotel;
import com.example.demo.model.Province;
import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.service.hotel.IHotelService;
import com.example.demo.service.province.IProvinceService;
import com.example.demo.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class HotelController {

    @Autowired
    private IHotelService hotelService;

    @Autowired
    private IProvinceService provinceService;

    @Autowired
    private IUserService userService;

    @ModelAttribute("users")
    public List<User> users(){
        return userService.findAll();
    }
    @ModelAttribute("provinces")
    public List<Province> provinces(){
        return provinceService.findAll();
    }

    @GetMapping("/hotel")
    public ModelAndView hotelList(){
        List<Hotel> list= hotelService.findAll();
        ModelAndView modelAndView= new ModelAndView("hotel/list");
        modelAndView.addObject("list", list);
        return modelAndView;
    }

    @GetMapping("/create-hotel")
    public ModelAndView showFormCreate(){
        ModelAndView modelAndView= new ModelAndView("hotel/create");
        modelAndView.addObject("hotel", new Hotel());
        return modelAndView;
    }
    @PostMapping("/create-hotel")
    public ModelAndView saveHotel(@ModelAttribute Hotel hotel){
        hotelService.save(hotel);
        ModelAndView modelAndView= new ModelAndView("hotel/create");
        modelAndView.addObject("hotel", new Hotel());
        modelAndView.addObject("message","Save Hotel Successful!!!");
        return modelAndView;
    }
    @GetMapping("/edit-hotel/{id}")
    public ModelAndView showFormEdit(@PathVariable Long id){
        Optional<Hotel> hotel=hotelService.findById(id);
        ModelAndView modelAndView= new ModelAndView("hotel/edit");
        modelAndView.addObject("hotel",hotel.get());
        return modelAndView;
    }
    @PostMapping("/edit-hotel")
    public ModelAndView updateHotel(@ModelAttribute Hotel hotel){
        hotelService.save(hotel);
        ModelAndView modelAndView= new ModelAndView("hotel/edit");
//        modelAndView.addObject("hotel",new Hotel());
        modelAndView.addObject("message","Update Hotel Successfully!!!");
        return modelAndView;
    }
    @GetMapping("/non-active-hotel/{id}")
    public ModelAndView nonActiveHotel(@PathVariable Long id){
        hotelService.delete(id);
        ModelAndView modelAndView= new ModelAndView("hotel/list");
        List<Hotel> list= hotelService.findAll();
        modelAndView.addObject("list", list);
        return modelAndView;
    }
    @GetMapping("/active-hotel/{id}")
    public ModelAndView activeHotel(@PathVariable Long id){
        hotelService.activeUser(id);
        ModelAndView modelAndView= new ModelAndView("hotel/list");
        List<Hotel> list= hotelService.findAll();
        modelAndView.addObject("list", list);
        return modelAndView;
    }
    @GetMapping("/search-hotel")
    public ModelAndView searchHotel(@RequestParam("search") String name){
        Optional<Hotel> hotels = hotelService.findByName(name);
        ModelAndView modelAndView= new ModelAndView("hotel/list");
        modelAndView.addObject("list", hotels.get());
        return modelAndView;
    }
}
