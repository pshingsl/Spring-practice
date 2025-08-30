package practice.controller.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

/*
* @Controller
*  -Spring MVC에 Controller 클래스로 인식되어 Spring MVC가 제공하는 다양한 어노테이션 사용
*
*   클라이언트 요청에 대한 처리를 할 메소드 작성
*   Get /hi에 경로에 들어오면 hi() 메소드 실행
*   매개변수가 Model model로 실행 -> Spring MVC가 제공하는 타입(MVC가
*   제공하는 타입(MVC 패턴의 Model과는 별개, View에 값을 전달하는 상자역할)
*
*   model.addAttribute();는 속성과 키로 이루어진다.
*   return "뷰 주소";
*   어떤 템플릿 엔진을 보여줄 것인지 정한다(경로타입)
*   여기선 폴더/파일로 리턴을 한다.
*
* */

@Controller
public class ThymeController {

    @GetMapping("/hi")
    public String hi(Model model){

        model.addAttribute("msg", "Hello Spring");
        return "_01_thymeleaf/hi";
    }

    @GetMapping("/thymeleaf")
    public String thymeleaf(Model model) {

        // 변수 사용
        model.addAttribute("study", "취업 준비 중");

        // value
        model.addAttribute("won", "10000원");
        
        // with
        model.addAttribute("char", "임시저장");

        // switch
        model.addAttribute("admin", "?");

        // if
        model.addAttribute("time", 6);

       // each
       List<String> list = Arrays.asList("초콜릿", "사탕", "요거트");
       model.addAttribute("list",list);

       // class
        Book book = new Book("이별하는 방법을 가르켜줘");
        model.addAttribute("book", book);
        return "_01_thymeleaf/thyme";
    }

}
class Book{
    private String title;

    public Book(String title) {
        this.title = title;
    }


    public String getTitle() {
        return title;
    }
}

