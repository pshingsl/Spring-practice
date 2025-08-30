package practice.controller.api;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RestController {

    // GET
    @GetMapping("/")
    public String getMain(){
        return "_02_api/req";
    }

    /*
    * @RequestParam -> ?키=값을 나타낼때 사용
    * - Query String 중에서 name, key에 대한 value를 String name에 매핑
    * - required=true가 기본값 이므로 URL에서 name, key, age, key를 보내야함
    * - required=false일 때 기본값 안 적고 실행해도 실행됨
    * - age 값은 보내지 않으면 에러발생, String은 값 생략해도 잘 작동함
    * - age는 기본형 타입이지만 name은 문자열인데 빈 문자열도 유효한 값으로 취급되기 때문이다.
    * - 그럴 일은 없겠지만 기본형 타입을 값을 안넣고 설정하려면 required=false, defaultValue = "0"를 추가하면 실행 된다.
    *
    */
    @GetMapping("/get/res1")
    public String getRes1(@RequestParam(value = "name") String name, @RequestParam(value = "age") int age, Model model){
        model.addAttribute("name", name);
        model.addAttribute("age", age);
        return "_02_api/res";
    }

    @GetMapping("/get/res2")
    public String getRes2(@RequestParam(value = "name", required = false) String name, Model model){
        model.addAttribute("name", name);
        return "_02_api/res";
    }

    /*
    * @PathVariable(PathParam) -> /경로/값 나타 낼 때 사용
    *  - @PathVariable 처음 작성 후()를 사용하지 않으면 기본값 true로 인식함
    *  - (value="age") 들어오는 파람값 구별하기 위해서 사용
    *  - 기본적으로 path variable은 값을 가져야한다.(즉, 값이 없으면 404 에러 발생!)
    * */
    @GetMapping("/get/res3/{name}/{age}")
    public String getRes3(@PathVariable String name, @PathVariable(value = "age") int age, Model model) {
        model.addAttribute("age", age);
        model.addAttribute("name", name);
        return "_02_api/res";
    }

    /*
     * - path variable 중에서 name 필수 경로변수, age는 선택 경로변수 라면?
     * - 아까전 기본형은 값을 반드시 들어가야한다. 아래 이름만있는 경로만 들어가도 기본형인 값을 안넣어서 에러!
     * - 문제를 해결하기위해서 기본형(int)를 참조형(Integer)로 변환
     * - 선택 경로 변수에는 required=false가 들어가야 한다.
     * - 선택 경로 변수는 맨뒤에 가야한다.
     * - 필수 경로, 선택 경로로 하는방법
     * - {"필수경로", "선택경로"}
     */
    @GetMapping({"/get/res4/{name}/{age}","/get/res4/{name}"})
    public String getRes4(@PathVariable String name, @PathVariable(value = "age", required = false) Integer age, Model model) {
        model.addAttribute("age", age);
        model.addAttribute("name", name);
        return "_02_api/res";
    }
}
