package practice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/*
* 테이블명과 클래스명이 다르지만 자바에서 이름이 다르는것 상관없다는 듯이 사용
* @Setter를 안쓰는 이유
* - 객체의 일관성과 안정성을 보장하기위해서이다.
* - 엔티티는 데이터베이스의 테이블과 직접 매핑되는 중요한 객체이므로 데이터 무결성을 유지해야함
* */

@Entity
@Table(name = "users")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String username;

    @Column(nullable = false, length = 100)
    private String email;

    @Column(name = "created_at", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createAt;

    @PrePersist // 엔ㅌ티가 데이터베이스에 저장되기 전에 필요한 초기화 작업 수행
    protected void onCreate(){
        // 엔티티가 처음 저장될 때 createdAt필드에 현재 시각에 저장
        // 메소드 이름 자유롭게 설정 가능(단, 메소드의 반환타입 void로 고정, 매개변수 존재x)
        createAt = LocalDateTime.now();
    }
}
