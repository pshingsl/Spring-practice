package practice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("/hello")
    // "msg"라는 이름으로 "Hi~" 라는 데이터 모델을 담는다. -> 변수랑 같은 느낌
    public String getHi(Model model) {
        // Model은 스프링이 지원하는 기능 -> key와 value로 이루어져 있는 HashMap
        model.addAttribute("msg", "Hi~"); // 키, 값으로 구성됨
        return "hi"; // hi라는 html로 실행
    }

    @GetMapping("hello-mvc")
    // http://localhost:8080/hello-mvc?name=spring 아래 파라미터 사용법
    public String getHelloMvc(@RequestParam(name = "name", required = true) String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody // http(header, body)로 이루어짐 body에 값을 준다로 알자.
    public String getHelloString(@RequestParam("name") String name) {
        return "hello " + name; // name에 "hello" 들어가면 "hello-template hello"나옴
    }

    // json 방식으로 나옴 -> json 검색하기
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
        // "<html></html>" xml에 방식이라 번거로움 -> 번거로움 해결하기 위해 json을 많이 씀
        //  @ResponseBody 있으면 그대로 데이터를 넘겨야 한다.
    }

    static class Hello{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
