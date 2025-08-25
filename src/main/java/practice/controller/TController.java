package practice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class TController {
    @GetMapping("/people")
    public String getPeople(Model model){
        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person("kim", 10));
        list.add(new Person("lee", 20));
        list.add(new Person("hong", 30));
        list.add(new Person("park", 40));
        list.add(new Person("shin", 50));

        model.addAttribute("people", list);
        return "people.html";
    }
}
