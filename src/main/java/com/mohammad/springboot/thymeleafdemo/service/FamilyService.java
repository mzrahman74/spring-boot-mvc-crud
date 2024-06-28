package com.mohammad.springboot.thymeleafdemo.service;

import com.mohammad.springboot.thymeleafdemo.entity.Family;

import java.util.List;

public interface FamilyService {
    List<Family> findAll();
    Family findById(int theId);

    Family save (Family theFamily);
    void deletedById(int theId);
}
