package practice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import practice.domain.User;
import practice.dto.UserDTO2;
import practice.mapper.UserMapper;

import java.util.ArrayList;
import java.util.List;

@Service // 이 클래스가 서비스 계츠으이 컴포넌트을 나타냄
public class UserService {
    @Autowired
    private UserMapper userMapper;

    // 모든 사용자 정보(DB로 부터 읽어 온 domain.User 리스트)를 UserDTO 변환
    public List<UserDTO2> findAll(){
        // 모든 도메인에 있는 User객체를 가져옴
        List<User> users = userMapper.findAll();

        // 새로운 DTO 객체 생성 -> 다른 곳에서 사용
        List<UserDTO2> userDTO2s = new ArrayList<>();

        // 반복문을 이용해서 User 객체를 UserDTO2로 변환하고 출력
        for(User user: users){
            UserDTO2 userDTO2 = convertToDto(user);
            userDTO2s.add(userDTO2);
        }
        // UserDTO2 리스트 변환
    return userDTO2s;
    }

    // 특정 사용자
    public UserDTO2 getById(Long id){
        User user = userMapper.findById(id);
        return convertToDto(user);
    }

    // 생성
    public void create(UserDTO2 userDTO2){
        // DTO를 domain로 변환
        User user = convertTOEntity(userDTO2);
        userMapper.create(user);
    }

    // 업데이트
    public void update(UserDTO2 userDTO2){
        // DTO를 domain로 변환
        User user = convertTOEntity(userDTO2);
        userMapper.update(user);
    }

    // 삭제
    public void delete(Long id){
        userMapper.delete(id);
    }

    private User convertTOEntity(UserDTO2 dto){
        User user = new User();
        user.setId(dto.getId());
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        return user;

    }

    private UserDTO2 convertToDto(User user){
        UserDTO2 dto = new UserDTO2();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        dto.setNo((int) (user.getId()+100));

        return dto;
    }
}

/*
 * 참고. domain.User와 dto.UserDTO2를 서로 변환하는 이유
 *  - domain.User : 데이터베이스 엔티티를 표현한다.
 *  - dto.UserDTO2: 클라이언트와 데이터 전송에 사용
 *  - DTO를 사용하게 되면 클라이언트의 요구사항에 맞춰서 데이터구조를 쉽게
 *    변경가능 필요한 데이터만 클라이언튼에 전송해서 네트워크 부하도 줄일 수 있다.
 *  - API 버전 관리 용이(엔티티(도메인) 변경시 DTO를 통해 이전 버전과 호한성 유지 가능
 */

