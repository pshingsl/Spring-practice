package practice.controller.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ThymePracController {
    @GetMapping("/nai")
    public String age(Model model){
        int age = 21;
        model.addAttribute("age", age);
        System.out.println(20);

        // 겟터 안만들면 값 불러오지 못함
        List<Person> person = new ArrayList<>();
        person.add(new Person("kim", 10));
        person.add(new Person("lee", 20));
        person.add(new Person("hong", 30));
        person.add(new Person("park", 40));
        person.add(new Person("shin", 50));
        model.addAttribute("person", person);
        return "_01_thymeleaf/tprac";
    }

    class Person{
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }
}
