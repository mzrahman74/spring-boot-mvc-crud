package com.mohammad.springboot.dao;

import com.mohammad.springboot.entity.Family;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface FamilyRepository extends JpaRepository<Family, Integer > {
// that's it ... no need to write any code LOL!

// add a method to sort by first name
public List<Family> findAll(Sort sort);

}