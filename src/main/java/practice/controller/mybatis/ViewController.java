package practice.controller.mybatis;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class ViewController {

    // GET 요청시 /users 경로로 리다이렉트
    @GetMapping("/")
    public String redirectToUsers() {
        return "redirect:/users";
    }

    // GET /users 요청 시 userList.html 템플릿 뷰 반환
    @GetMapping("/users")
    public String users1() {

        return "_03_myBatis/userList";
    }
    // GET /users/new 요청 시 userFrom.html 템플릿 뷰 반환
    @GetMapping("/users/new")
    public String users2() {
        return "_03_myBatis/userForm";
    }

    // 요청 경로 영어 문자로 된건 그대로 적고 유저아이디는 @PathVariable로 받기
    // GET /users/유저아이디/edit 요청 시 userForm.html 템플릿 뷰 변환
    @GetMapping("/mybatis/users/{id}/edit")
    public String users3(@PathVariable String id, Model model) {
        model.addAttribute("id", id);
        return "_03_myBatis/userForm";
    }

}
