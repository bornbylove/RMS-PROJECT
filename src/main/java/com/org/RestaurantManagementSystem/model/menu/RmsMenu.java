package com.org.RestaurantManagementSystem.model.menu;

import com.org.RestaurantManagementSystem.repository.RmsRepository;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@NoArgsConstructor
public class RmsMenu {
    @Autowired
    private RmsRepository rmsRepository;

    private Long id;
}
