package practice.controller.api;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import practice.VO.UserVO;
import practice.dto.UserDTO;

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

    /*
    * post
    * 쿼리스트링으로 출력이되지 않은 이유 req.hmtl의 form 태그의 method 속성값이 post이기 때문이다.
    * 폼 데이터를 URL에 노출시키지 않고 HTTP 요청 본문(Body)에 숨겨서 보내주기 때문이다.
    * */
    @PostMapping("/post/res1")
    public String post1(@RequestParam String name,
                        @RequestParam int age,
                        Model model){
        model.addAttribute("name", name);
        model.addAttribute("age", age);
        return "_02_api/res";
    }

    @PostMapping("/post/res2")
    public String post2(@RequestParam String name,
                        @RequestParam int age,
                        Model model){
        model.addAttribute("name", name);
        model.addAttribute("age", age);
        return "_02_api/res";
    }

    /*
    * @ResponseBody
    * - 응답 시 객체를 JSON or XML 등으로 리턴할 때 사용
    * - 즉,응답 객체를 전달 (node express res.send()와 유사)
    * */
    @PostMapping("/post/res3")
    @ResponseBody
    public String post3(@RequestParam String name,
                        @RequestParam int age,
                        Model model){
        model.addAttribute("name", name);
        model.addAttribute("age", age);
        return name+", "+age;
    }

    /*
     * DTO
     * - 클라이언트 요청 시 전달된 값을 담는데 사용할 객체
     *
     * @ModelAttribute UserDTO userDTO
     * - 요청 파라미터 DTO 객체에 바인딩
     * - 폼 Input name 속성들 (name, age)이 userDTO 필드명과 일치하면 자동매핑
     * - 매핑 ? DTO의 Setter를 사용해서 생성 및 연결
     * - ex) ?name=Jax&age=2013 -> setName("Jax"), setAge(2013);
     */
    @GetMapping("/dto/res1")
    @ResponseBody
    public String dto1(@ModelAttribute UserDTO userDTO){

        return userDTO.getName()+ ", " +userDTO.getAge();
    }

    /*
    * - @ModelAttribute는 생략이 가능하다
    * - 파라미터 UserDTO 타입 앞에 아무것도 없으면 @ModelAttribute 어노테이션 자동 추가된다.
    * - @RequestParam이나 @RequestBody 같은 특정 어노테이션이 없는 커스텀 객체
    *   타입일 경우, 스프링은 자동으로 @ModelAttribute 어노테이션이 붙은것 처럼 동작
    * */
    @PostMapping("/dto/res2")
    @ResponseBody
    public String dto2(UserDTO userDTO){
        return userDTO.getName()+ ", " +userDTO.getAge();
    }

    /*
    * 에러 발생!
    * @RequestBody 어노테이션
    * - 요청의 본문(req.body)에 있는 데이터를 읽어와서 객체에 매핑
    * - 매핑? -> 필드값을 주입하는 것이다,
    * - 반환 값을 HTTP 본문에 직접 작성하게된다.
    * - (전제 조건) 단! 요청의 형식이 JSON또는 XML일 때 사용
    * - 지금은 "일반 폼 전송"으로 해서 에러가 발생!
    *
    * 415 에러
    * - 서버가 클라이언트로부터 받은 요청의 미디어 타입(Content-type)을 지원하지
    *   않거나 이해할 수 없는 경우 발생
    * - 해당 요청은 MIME Type의 x-www-form-urlencoded
    * - @RequestBody 어노테이션 사용시 오류 발생
    *
    * 오류 해결 방법
    * - "일반 폼 전송"을 하고 있으니 ModelAttribute를 사용
    * - 클라이언트측에서, js 코드를 사용해 폼 데이터를 json 변환하여 작성
    * */
    @PostMapping("/dto/res3")
    @ResponseBody
    public String dto3(@RequestBody UserDTO userDTO){
        return userDTO.getName()+ ", " +userDTO.getAge();
    }

    /*
    * VO
    * @ModelAttribute UserVO userVO
    * - /vo/res1 실행 시 null과 0으로 나온다.
    * - 이유는 @ModelAttribute는 setter를 이용해 객체에 값을 주입한다.
    * - VO에는 getter의 값만 가진다. 따라서 폼에서 전송한 데이터가 주입되지 않는다.
    * - 따라서 name, age 필드는 초기화되지 않은 상태인 null, 0으로 남게된다.
    * */

    @GetMapping("/vo/res1")
    @ResponseBody
    public String vo1(@ModelAttribute UserVO userVO){
        return userVO.getName() + ", "+ userVO.getAge();
    }

    /*
     * /vo/res1 이랑 같은 이유
     */
    @PostMapping("/vo/res2")
    @ResponseBody
    public String vo2(UserVO userVO){
        return userVO.getName() + ", "+ userVO.getAge();
    }

    /*
    * @RequestBody
    * - /vo/res3 에러 발생
    * - 요청 본문 데이터를 vo객체로 변환시도 "일반 폼 전송"인데
    *   @RequestBody는 JSON 또는 XML로 받아야 하는데 둘 중 하나라도 아니여서 에러발생!
    *
    * 올바르게 사용밥업
    * - @RequestBody 제거하고 ModelAttribute 사용
    * - 클라이언트 측에서 js를 이용해 폼 데이터를 JSON으로 변환해서 동적 폼 데이터로 전송
    * */
    @PostMapping("/vo/res3")
    @ResponseBody
    public String vo3(@RequestBody UserVO userVO){
        return userVO.getName() + ", "+ userVO.getAge();
    }

    // axios
    @GetMapping("/axios/res1")
    @ResponseBody
    public String axios(@RequestParam String name, @RequestParam int age, Model model){
        model.addAttribute("name", name);
        model.addAttribute("age", age);
        return name + ", " +age;
    }


    @GetMapping("/axios/res2")
    @ResponseBody
    public String axiosDTO2(UserDTO userDTO, Model model){
      model.addAttribute("name", userDTO.getName());
      model.addAttribute("age", userDTO.getAge());

      return userDTO.getName() +", "+userDTO.getAge();
    }

    /*
    * /axios/res3 에러 발생
    * - axios는 JSON 데이터를 받기위해 @RequestBody를 사용해야한다.
    * - @ResponseBody는 JSON이나 XML로 값을 주입하는데
    *   @RequestParam을 사용해서 쿼리스트팅/폼데이터 형식으로 주입해서 에러발생
    * */
    @PostMapping("/axios/res3")
    @ResponseBody
    public String axios3(@RequestParam String name, @RequestParam int age, Model model){
        model.addAttribute("name", name);
        model.addAttribute("age", age);

        return name + ", " +age;
    }

    /*
     * /axios/res4 에러 발생
     * - 원인: Axios가 JSON 데이터를 보내는 반면,
     * @ModelAttribute는 폼 데이터 형식만 처리 가능하기 때문.
     * - 해결: JSON 데이터를 받으려면 메서드 파라미터에 `@RequestBody`를 명시해야 함.
     * - @ResponseBody는 응답을 JSON/XML로 보낼 때 사용.
     */
    @PostMapping("/axios/res4")
    @ResponseBody
    public String axiosDTO4(UserDTO userDTO, Model model){
        model.addAttribute("name", userDTO.getName());
        model.addAttribute("age", userDTO.getAge());

        return userDTO.getName() +", "+userDTO.getAge();
    }

    // axios/res4의 에레 발생 해결버전
    @PostMapping("/axios/res5")
    @ResponseBody
    public String axiosDTO5(@RequestBody  UserDTO userDTO, Model model){
        model.addAttribute("name", userDTO.getName());
        model.addAttribute("age", userDTO.getAge());

        return userDTO.getName() +", "+userDTO.getAge();
    }

    // vo with axios
    @GetMapping("/axios/vo/res1")
    @ResponseBody
    public String axiosvo(@RequestParam String name, @RequestParam int age, Model model){
        return name +", "+age;
    }

    @GetMapping("/axios/vo/res2")
    @ResponseBody
    public String axiosvo2(UserVO userVO, Model model){
        model.addAttribute("name", userVO.getName());
        model.addAttribute("age", userVO.getAge());

        return userVO.getName() +", "+ userVO.getName();
    }

    /*
     * /axios/vo/res3는 에러 발생
     * - 이유는: axios는 JSON으로 받아와야하는데
     * - 메서드 매개변수는 @RequestParam는 쿼리스트링/ 폼 데이터만 처리가능하다
     * - @ResponseBody는 JSON/XML로 보낼 때 사용
     * */
    @PostMapping("/axios/vo/res3")
    @ResponseBody
    public String axiosvo3(@RequestParam String name, @RequestParam int age, Model model){
        model.addAttribute("name", name);
        model.addAttribute("age", age);

        return name +", "+ age;
    }

    /*
     * null, 0 출력!
     * - axios는 JSON으로 받음
     * - @ResponseBody는 JSON/XML로 데이터를 보낼 때 사용
     * - 지금 메소드에는 커스텀으로 사용해서 @ModelAttribute가 생략이 되어 있지만 있다.
     */
    @PostMapping("/axios/vo/res4")
    @ResponseBody
    public String axiosvo4(UserVO userVO, Model model){
        model.addAttribute("name", userVO.getName());
        model.addAttribute("age", userVO.getAge());

        return userVO.getName() +", "+ userVO.getAge();
    }

    @PostMapping("/axios/vo/res5")
    @ResponseBody
    public String axiosvo5(@RequestBody UserVO userVO, Model model){
        model.addAttribute("name", userVO.getName());
        model.addAttribute("age", userVO.getAge());

        return userVO.getName() +", "+ userVO.getAge();
    }
}
