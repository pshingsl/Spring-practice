package practice.mapper;

import org.apache.ibatis.annotations.*;
import practice.domain.User;

import java.util.List;

@Mapper // 해당 인터페이스가 Mybatis mapper임을 나타냄
public interface UserMapper {

    /* case1. 어노테이션 기반 매퍼
     * - 간단한 SQL(쿼리)의 경우 간결하게 표현
     * - Java코드 내에서 SQL문을 직접 볼 수 있어 즉각적인 이해 가능
     * - @Select, @Insert, @Update, @Delete 어노테이션 사용
     */

    // 전체 유저 조회
    @Select("SELECT * FROM users")
    List<User> findAll();

    // 유저 아이디 조회
    @Select("SELECT * FROM users WHERE id = #{id}")
    User findById(Long id);

    // 유저 생성
    @Insert("INSERT INTO users (username, email) VALUES (#{username}, #{email}")
    @Options(useGeneratedKeys = true, keyColumn = "id")
    void create(User user);

    // 유저 수정
    @Update("UPDATE users SET username = #{username}, email = #{email} WHERE id = #{id}")
    void update(User user);

    // 유저 삭제
    @Delete("DELETE FROM users WHERE id = #{id}")
    void delete(Long id);
}
