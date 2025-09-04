package practice.controller.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import practice.dto.UserDTO2;
import practice.service.UserService;

import java.util.List;

@RestController // RESTful 웹 서비스의 컨트롤러 해당 클래스 모든 메소드의 반환 값이 자동으로 JSON 형식으로 HTTP 응답 본문에 포함
@RequestMapping("/api/users") // 해당 클래스의 기본 요청 경로를 지정
public class UserController {

    // Controller 계층은 Service 게층을 사용 -> 의존한다. -> @Autowired
    @Autowired
    private UserService userService;

    // 모든 사용자 정보를 리스트 변환
    // GET /api/users: 모든 사용자 정보를 리스트 변환
    @GetMapping
    public List<UserDTO2> listUsers() {
        return userService.getAlls();
    }

    // POST /api/users : 새  사용자를 생성하고 생성된 사용자 정보 변환
    @PostMapping
    public UserDTO2 createUser(@RequestBody UserDTO2 userDTO2) {
        // @RequestBody: HTTP 요청 본문을 자바 객체로 변환
        userService.create(userDTO2);
        return userDTO2;
    }

    // GET /api/users/:id : 특정 ID의 사용자 정보를 반환
    // @Pathvariable은 String, Long 등과 같은 단일 기본 타입을 받도록 해야한다
    @GetMapping("/{id}")
    public UserDTO2 getUsers(@PathVariable Long id) {
        return userService.getById(id);
    }

    // PUT /api/users/:id : 특정 ID의 사용자 정보를 업데이트하고 업데이트된 정보를 반환
    @PutMapping("/{id}")
    public UserDTO2 updateUsers(@PathVariable Long id, @RequestBody UserDTO2 userDTO2){
        userDTO2.setId(id);
        userService.update(userDTO2);
        return userDTO2;
    }

    // DELETE /api/users/:id : 특정 ID 의 사용자 삭제
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.delete(id);
    }
}