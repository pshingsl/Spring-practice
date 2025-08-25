package practice.repository;

import practice.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    // 회원 저장
    Member save(Member member);
    // 널을 처리하는 방법으로 Optional 사용
    Optional<Member> findById(long id);
    Optional<Member> findByName(String name);
    // 회원의 아이디, 이름을 리스트 형식으로 저장
    List<Member> findAll();
}
