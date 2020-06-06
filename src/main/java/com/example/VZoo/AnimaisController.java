package com.example.VZoo;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AnimaisController {

    @GetMapping("/animais")
    public String animais(Model model)
    {
        return "animais";
    }

    @PostMapping("/animais")
    public String goToAnimais(Model model)
    {
        return "animais";
    }

}
