package com.glowDM.BP.member;

import com.glowDM.BP.member.data.Member;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByLoginId(String loginId);
    boolean existsByLoginId(String loginId);
}
