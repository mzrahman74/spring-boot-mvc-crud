package com.mohammad.springboot.thymeleafdemo.service;

import com.mohammad.springboot.thymeleafdemo.dao.FamilyRepository;
import com.mohammad.springboot.thymeleafdemo.entity.Family;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FamilyServiceImpl implements FamilyService {
    private FamilyRepository familyRepository;

    @Autowired
    public FamilyServiceImpl(FamilyRepository theFamilyRepository) {
        familyRepository =  theFamilyRepository;
    }
    @Override
    public List<Family> findAll() {
        return familyRepository.findAll(Sort.by(Sort.Order.asc("firstName")));
    }

    @Override
    public Family findById(int theId) {
        Optional<Family> result = familyRepository.findById(theId);
        Family theFamily = null;
        if(result.isPresent()) {
            theFamily = result.get();
        } else {
            throw new RuntimeException("Did not find employee id - " + theId);
        }
        return theFamily;
    }

    @Override
    public Family save(Family theFamily) {
    return familyRepository.save(theFamily);
    }

    @Override
    public void deletedById(int theId) {
        familyRepository.deleteById(theId);

    }
}
