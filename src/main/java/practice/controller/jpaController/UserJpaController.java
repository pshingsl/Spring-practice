package practice.controller.jpaController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import practice.dto.UserJpaDTO;
import practice.service.UserJpaService;

import java.util.List;

@RestController
@RequestMapping("/test/user")
public class UserController {

    @Autowired
    private UserJpaService userJpaService;

    @GetMapping
    public List<UserJpaDTO> AllUsers(){
        return userJpaService.AllUsers();
    }
}
