package com.example.demo.controller;

import com.example.demo.model.Image;
import com.example.demo.model.ImageForm;
import com.example.demo.model.Room;
import com.example.demo.model.User;
import com.example.demo.service.image.ImageService;
import com.example.demo.service.room.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class ImageController {

    @Autowired
    private ImageService imageService;
    @Autowired
    private RoomService roomService;

    @ModelAttribute("rooms")
    public List<Room> rooms(){
        return roomService.findAll();
    }
    @Value("${upload.path}")
    private String fileUpload;

    @GetMapping("/image")
    public ModelAndView listImage(){
        List<Image> list= imageService.findAll();
        ModelAndView modelAndView= new ModelAndView("image/list");
        modelAndView.addObject("list", list);
        return modelAndView;
    }

    @GetMapping("/create-image")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView= new ModelAndView("image/create");
        modelAndView.addObject("imageForm", new ImageForm());
        return modelAndView;
    }
    @PostMapping("/create-image")
    public RedirectView saveImage(@ModelAttribute ImageForm imageForm){
        Image image= new Image(imageForm.getRoom());
        MultipartFile multipartFile= imageForm.getUrl();
        String fileName= multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(imageForm.getUrl().getBytes(),new File(this.fileUpload+fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        image.setUrl(fileName);
        imageService.save(image);
        return new RedirectView("/image");
    }
    @GetMapping("/delete-image/{id}")
    public ModelAndView deleteImage(@PathVariable Long id){
        imageService.delete(id);
        List<Image> list= imageService.findAll();
        ModelAndView modelAndView= new ModelAndView("image/list");
        modelAndView.addObject("list", list);
        return modelAndView;
    }

}
