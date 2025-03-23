package org.keyin.member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    ArrayList<Member> findByName(String name);
    ArrayList<Member> findByEmail(String email);
    ArrayList<Member> findByPhone(String phone);
}