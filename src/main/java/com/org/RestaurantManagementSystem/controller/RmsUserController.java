package com.org.RestaurantManagementSystem.controller;

import com.org.RestaurantManagementSystem.model.User;
import com.org.RestaurantManagementSystem.model.menu.RmsMenu;
import com.org.RestaurantManagementSystem.service.RmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/vi/")
public class RmsUserController {
    @Autowired
    private RmsService rmsService;

    private RmsMenu rmsMenu;

    @GetMapping("/menu/1")
    public RmsMenu getSingleMenu(@PathVariable Long id){
        return rmsService.getSingleItem(id);
    }

    @GetMapping("/menu/2")
    public List<RmsMenu> getMultipleMenu(@PathVariable Long id){

        return rmsService.getMultipleItem(id);
    }

    public List<RmsMenu> viewAllMenu(@PathVariable Long id){
        return rmsService.showAllItem();
    }


}
