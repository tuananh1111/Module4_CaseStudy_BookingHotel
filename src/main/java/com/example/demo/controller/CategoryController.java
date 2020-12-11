package com.example.demo.controller;

import com.example.demo.model.Category;
import com.example.demo.model.Hotel;
import com.example.demo.model.HotelForm;
import com.example.demo.service.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/category")
    public ModelAndView listCategory(){
        ModelAndView modelAndView= new ModelAndView("category/list");
        List<Category> list= categoryService.findAll();
        modelAndView.addObject("list", list);
        return modelAndView;
    }
    @GetMapping("/create-category")
    public ModelAndView showFormCreate(){
        ModelAndView modelAndView= new ModelAndView("category/create");
        modelAndView.addObject("category", new Category());
        return modelAndView;
    }


    @PostMapping("/create-category")
    public ModelAndView saveCategory(@ModelAttribute Category category){
        categoryService.save(category);
        ModelAndView modelAndView= new ModelAndView("category/create");
        modelAndView.addObject("category", new Category());
        modelAndView.addObject("message", "Create Category successfully!!!");
        return modelAndView;
    }
    @GetMapping("/edit-category/{id}")
    public ModelAndView showFormEdit(@PathVariable Long id){
        Optional<Category> category=categoryService.findById(id);
        ModelAndView modelAndView= new ModelAndView("category/edit");
        modelAndView.addObject("category",category.get() );
        return modelAndView;
    }
    @PostMapping("/edit-category")
    public ModelAndView updateCategory(@ModelAttribute Category category){
        categoryService.save(category);
        ModelAndView modelAndView= new ModelAndView("category/edit");
        modelAndView.addObject("message", "Update Category Successfully!!!");
        modelAndView.addObject("category", new Category());
        return modelAndView;
    }
    @GetMapping("/delete-category")
    public ModelAndView deleteCategory(@PathVariable Long id){
        categoryService.delete(id);
        List<Category> list= categoryService.findAll();
        ModelAndView modelAndView= new ModelAndView("category/list");
        modelAndView.addObject("list", list);
        return modelAndView;
    }
}
