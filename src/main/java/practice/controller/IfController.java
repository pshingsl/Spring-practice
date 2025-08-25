package practice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IfController {
    @GetMapping("/age")
    public String getAge(Model model){
        int age = 21;
        model.addAttribute("age", age);
        return "age";
    }
}
