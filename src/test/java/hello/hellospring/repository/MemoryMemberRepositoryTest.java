package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach // 메소드가 끝날때마다 동작
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("mirutree");

        repository.save(member);
        Member result = repository.findById(member.getId()).get();
//        System.out.println("result = " + (result == member)); // true
//        Assertions.assertEquals(member, result);
        assertThat(member).isEqualTo(result);
        // 단축키 alt + enter : add on-demand static import
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1); // 녹색
//        assertThat(result).isEqualTo(member2);
    }
    
    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);
        // shift + f6 한꺼번에 문구 수정

        // Ctrl+Alt+V : Extract/Introduce variable
        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
//        assertThat(result.size()).isEqualTo(3);
    }

}
