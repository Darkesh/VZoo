package com.example.VZoo;

import com.example.VZoo.entities.Animal;
import com.example.VZoo.entities.Attendant;
import com.example.VZoo.entities.Habitat;
import com.example.VZoo.repositories.HabitatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class HabitatsPageController {
    public static HabitatRepository habitatRepository;

    @Autowired
    public HabitatsPageController(HabitatRepository repository) {
        this.habitatRepository = repository;
    }

    @GetMapping("/createHabitat")
    public String createHabitat(Habitat habitat) {
        return "add-habitat";
    }

    @PostMapping("/addHabitat")
    public String addAttendant(@Valid Habitat habitat, BindingResult result, Model model) {
        habitatRepository.save(habitat);
        model.addAttribute("habitats", habitatRepository.findAll());
        return "habitatspage";
    }

    @GetMapping("/editHabitat/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Habitat habitat = habitatRepository.findById(id);
        model.addAttribute("habitat", habitat);
        return "update-habitat";
    }

    @PostMapping("/updateHabitat/{id}")
    public String updateHabitat(@PathVariable("id") long id, @Valid Habitat habitat, BindingResult result, Model model) {
        if (result.hasErrors()) {
            habitat.setId(id);
            return "update-habitat";
        }

        habitatRepository.save(habitat);
        model.addAttribute("habitats", habitatRepository.findAll());
        return "habitatspage";
    }

    @GetMapping("/deleteHabitat/{id}")
    public String deleteHabitat(@PathVariable("id") long id, Model model) {
        Habitat habitat = habitatRepository.findById(id);
        habitatRepository.delete(habitat);
        model.addAttribute("habitats", habitatRepository.findAll());
        return "habitatspage";
    }

    @GetMapping("/habitatspage")
    public String habitats(Model model)
    {
        model.addAttribute("habitats", habitatRepository.findAll());
        return "habitatspage";
    }

    @PostMapping("/habitatspage")
    public String goToHabitats(Model model)
    {
        model.addAttribute("habitats", habitatRepository.findAll());
        return "habitatspage";
    }
}
