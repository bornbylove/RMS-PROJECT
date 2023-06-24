package com.org.RestaurantManagementSystem.service;

import com.org.RestaurantManagementSystem.model.User;
import com.org.RestaurantManagementSystem.model.menu.RmsMenu;
import com.org.RestaurantManagementSystem.repository.RmsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class RmsService {
    RmsRepository rmsRepository;
    User user;
    RmsMenu rmsMenu;
    public RmsMenu getSingleItem(Long id) {
        Optional<RmsMenu> singleMenuOptional = rmsRepository.findById(id);
        return rmsMenu;
    }

    public List<RmsMenu> getMultipleItem(Long id) {
         // List<RmsMenu> getMultiple = new ArrayList<RmsMenu>();
        Optional<RmsMenu> multipleMenuOptional = rmsRepository.findById(id);
        try {
            multipleMenuOptional.ifPresent(s -> System.out.println("Item already added to cart"));
            rmsMenu = rmsRepository.save(new RmsMenu());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //return (List<RmsMenu>) rmsMenu;
        return getMultipleItem(id);
        }

    public List<RmsMenu> showAllItem() {
        return rmsRepository.findAll();
    }
}

