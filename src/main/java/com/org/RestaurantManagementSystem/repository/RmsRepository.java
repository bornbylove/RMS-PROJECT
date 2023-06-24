package com.org.RestaurantManagementSystem.repository;

import com.org.RestaurantManagementSystem.entity.Account;
import com.org.RestaurantManagementSystem.model.menu.RmsMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RmsRepository extends JpaRepository<RmsMenu, Long> {
   // String sql = "Select  * from  #{#Order}";
    @Query("SELECT * FROM Order WHERE ")
    Optional<Account> findByUserName(String UserName);

}
