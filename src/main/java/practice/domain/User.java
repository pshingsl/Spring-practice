package practice.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

/*
* domain User 클래스
* - 데이터베이스 엔티티(객체) 표현하는 도메인 -> 여기서 객체가 4개다
* - 실제 데이터의 역할이므로 "테이블 구조"와 동일해야한다.
* */
public class User {
    private Long id;
    private String username;
    private String email;
    private String createAt;
}
