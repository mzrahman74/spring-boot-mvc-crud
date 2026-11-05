package com.mohammad.springboot.service;

import com.mohammad.springboot.entity.Family;

import java.util.List;

public interface FamilyService {
    List<Family> findAll();
    Family findById(int theId);

    Family save (Family theFamily);
    void deletedById(int theId);
}
