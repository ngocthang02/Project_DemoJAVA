package com.poly.assignment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poly.assignment.entities.Account;

 

public interface AccountRepository extends JpaRepository<Account, String> {



}
