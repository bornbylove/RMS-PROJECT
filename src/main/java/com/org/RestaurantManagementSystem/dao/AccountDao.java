package com.org.RestaurantManagementSystem.dao;

import com.org.RestaurantManagementSystem.entity.Account;
import com.org.RestaurantManagementSystem.repository.RmsRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class AccountDao {
    @Autowired
    private RmsRepository rmsRepository;
    @Autowired
    private Account account;

    public Account findAccount(String UserName){
        Optional<Account> findAccount = rmsRepository.findByUserName(account.getUserName());
        return account;
    }
}