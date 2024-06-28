package com.mohammad.springboot.thymeleafdemo.cotroller;


import com.mohammad.springboot.thymeleafdemo.entity.Family;
import com.mohammad.springboot.thymeleafdemo.service.FamilyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/families")
public class FamilyController {
    private FamilyService familyService;

    public FamilyController(FamilyService theFamilyService) {
        familyService = theFamilyService;
    }

    @GetMapping("/list")
    public String listEmployees(Model theModel) {
        // get the employees from db
        List<Family> theFamily = familyService.findAll();
        // add to the spring model

        theModel.addAttribute("families", theFamily);

        return "families/list-families";
    }
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel){
        Family theFamily = new Family();
        System.out.println("Age value: " + theFamily.getAge());
        theModel.addAttribute("family", theFamily);
        return "families/family-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("familyId") int theId, Model theModel) {
        Family theFamily = familyService.findById(theId);
        theModel.addAttribute("family", theFamily);
        return "families/family-form";
    }
    @PostMapping("/save")
    public String saveFamily(@ModelAttribute("family") Family theFamily) {
        familyService.save(theFamily);
        return "redirect:/families/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("familyId") int theId) {
        familyService.deletedById(theId);
        return "redirect:/families/list";
    }

}
