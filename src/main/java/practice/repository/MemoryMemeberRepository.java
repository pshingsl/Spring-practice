package practice.repository;

import org.springframework.stereotype.Repository;
import practice.domain.Member;

import java.util.*;

@Repository
public class MemoryMemeberRepository implements MemberRepository {
    // save는 저장을 하기위해 Map 사용
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(long id) {
        return Optional.of(store.get(id)); // 널 값이 올 수 있어 Optional 감싸서 사용하면 널이 와도 문제 없음
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
