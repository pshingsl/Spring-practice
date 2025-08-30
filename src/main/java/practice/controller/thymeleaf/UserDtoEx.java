package practice.controller.thymeleaf;

import practice.dto_vo.UserDTO;

public class UserDtoEx {
    public static void main(String[] args) {
        UserDTO u1 = new UserDTO(1L, "Jay", "test@naver.com", 23);
        System.out.println(u1.toString());
    }
}
