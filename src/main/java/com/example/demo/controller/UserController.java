package com.example.demo.controller;

import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.service.role.IRoleService;
import com.example.demo.service.user.IUserService;
import com.example.demo.service.user.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class UserController {
    @Autowired
    private IRoleService roleService;

    @ModelAttribute("roles")
    public List<Role> roles(){
        return roleService.findAll();
    }
    @Autowired
    private IUserService iUserService;
    @GetMapping("/home")
    public ModelAndView showList(){
        ModelAndView modelAndView= new ModelAndView("user/home");
        List<User> list= iUserService.findAll();
        modelAndView.addObject("list", list);
        return modelAndView;
    }

    @GetMapping("/edit-user/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        Optional<User> user= iUserService.findById(id);
        ModelAndView modelAndView= new ModelAndView("user/edit");
        modelAndView.addObject("user", user.get());
        return modelAndView;
    }
    @PostMapping("/edit-user")
    public ModelAndView updateUser(@ModelAttribute User user){
        iUserService.save(user);
        ModelAndView modelAndView= new ModelAndView("user/edit");
        modelAndView.addObject("user", new User());
        modelAndView.addObject("message", "Updated USER successful!!!");
        return modelAndView;
    }
    @GetMapping("/create-user")
    public ModelAndView showFormCreate(){
        ModelAndView modelAndView= new ModelAndView("user/create");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }
    @PostMapping("/create-user")
    public ModelAndView saveUser(@Validated @ModelAttribute User user, BindingResult bindingResult){
       if (bindingResult.hasFieldErrors()){
           ModelAndView modelAndView= new ModelAndView("user/create");
           return modelAndView;
       }
        iUserService.save(user);
        ModelAndView modelAndView= new ModelAndView("user/create");
        modelAndView.addObject("user", new User());
        modelAndView.addObject("message","Create USER successful!!!");

        return  modelAndView;
    }
    @GetMapping("/delete-user/{id}")
    public ModelAndView deleteUser(@PathVariable Long id){
        iUserService.delete(id);
        List<User> list= iUserService.findAll();
        ModelAndView modelAndView= new ModelAndView("user/home");
        modelAndView.addObject("list", list);
        return modelAndView;
    }
}
