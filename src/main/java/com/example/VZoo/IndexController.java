package com.example.VZoo;

import com.example.VZoo.entities.Animais;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IndexController {
    @GetMapping("/index")
    public String home(Model model){

        model.addAttribute("index", new Index());
        return "index";
    }
    
    @PostMapping("/index")
    public String goToAnimais(@ModelAttribute Animais animais){
        return "animais";
    }
}
