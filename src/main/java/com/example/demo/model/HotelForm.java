package com.example.demo.model;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class HotelForm {
    private Long id;


    private String name;


    private String addressDetails;


    private String hotline;

    private String description;
    private boolean status;

    public HotelForm() {
    }

    private MultipartFile image;

    private Province province;

    private User user;

    public HotelForm(Long id, String name, String addressDetails, String hotline, String description, boolean status, MultipartFile image, Province province, User user) {
        this.id = id;
        this.name = name;
        this.addressDetails = addressDetails;
        this.hotline = hotline;
        this.description = description;
        this.status = status;
        this.image = image;
        this.province = province;
        this.user = user;
    }

    public HotelForm(String name, String addressDetails, String hotline, String description, boolean status, MultipartFile image, Province province, User user) {
        this.name = name;
        this.addressDetails = addressDetails;
        this.hotline = hotline;
        this.description = description;
        this.status = status;
        this.image = image;
        this.province = province;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddressDetails() {
        return addressDetails;
    }

    public void setAddressDetails(String addressDetails) {
        this.addressDetails = addressDetails;
    }

    public String getHotline() {
        return hotline;
    }

    public void setHotline(String hotline) {
        this.hotline = hotline;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
