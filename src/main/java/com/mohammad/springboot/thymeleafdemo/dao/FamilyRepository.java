package com.mohammad.springboot.thymeleafdemo.dao;

import com.mohammad.springboot.thymeleafdemo.entity.Family;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface FamilyRepository extends JpaRepository<Family, Integer > {
// that's it ... no need to write any code LOL!

// add a method to sort by first name
public List<Family> findAll(Sort sort);

}