package practice.controller.api;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import practice.VO.AxiosVO;

@Controller
public class RtestController {

    /*
    * @ResponseBody
    * - 자바 객체를 HttpResponse의 본문 responseBody의 내용으로 매핑하는 역할
    * - 메소드가 반환한 객체를 자동으로 JSON이나 XML 등의 형태로 변환해준다.
    * - 아래 return "내 이름은 " + name; 는 템플릿 파일 명이 아닌 문자 + 변수가 화면에 나온다.
    * */

    @GetMapping("/introduce/{name}")
    @ResponseBody
    public String intro(@PathVariable(value = "name") String name, Model model){
        model.addAttribute("name", name);
        return "내 이름은 " + name;
    }

    @GetMapping("/introduce2")
    @ResponseBody
    public String intro2(@RequestParam(value = "name") String name,
                         @RequestParam(value = "age") int age, Model model){
        model.addAttribute("name", name);
        model.addAttribute("age", age);
        return "내 이름은 " + name + "\n  내 나이는 " + age ;
    }

    @GetMapping("/form")
    public String form(Model model){
        return "_02_api/intro";
    }

    /*
    *  폼 로그인
    * - 해당 템플릿 엔진에 있는 폼으로 겟으로 이동
    * - 제출 방식은 포스트로 해야함 -> 리턴을 템플릿 엔지으로 안해도 됨
    * - 리퀘스트 변수과 html name 속성 이름이 같아야 한다.
    * - 리턴은 http의 본문을 가져오기 위해 @ResponseBody 사용
    * */
    @PostMapping("/form")
    @ResponseBody
    public String formCreate(@RequestParam(value = "name") String name,
                             @RequestParam(value = "gen") String gen,
                             @RequestParam(value = "year") String year,
                             @RequestParam(value = "month") String month,
                             @RequestParam(value = "day") String day,
                             @RequestParam(value = "interest") String interst,
                             Model model){
        return "이름 : "+name+"<br>"+
                "성별 : "+gen+"<br>"+
                "생년월일 : "+year+"-"+month+"-"+day+"<br>"+
                "관심사 : "+interst;
    }

    @GetMapping("form-test")
    public String form2(Model model){
        return "_02_api/form";
    }

    @PostMapping("form-test")
    @ResponseBody
    public String formCreate(AxiosVO axiosVO, Model model){

        return axiosVO.getName()+"가입 성공";
    }
}
