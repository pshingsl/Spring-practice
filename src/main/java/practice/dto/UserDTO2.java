package practice.dto;

import lombok.*;

/*
* dto.UserDTO2
* - 데이터 전송 객체(DTO)로 클라이언트와 서버 간의 데이터 교환에 사용
* - 클라이언트에게 노출하고 싶지 않은 정보를 domain.User에만 표현하고,
*   DTO 과정에서는 제외할 수 있다.(CreateAt 필드)
*
* - "no" 필드: 실제 데이터베이스 존재하는 컬럼은 아니지만 서비스 로직에서 no
* */

@Getter
@Setter
@NoArgsConstructor // 매개변수 없는 생성자
@AllArgsConstructor
@Builder
public class UserDTO2 {
    private Long id;
    private String username;
    private String email;
    private int no;
}
