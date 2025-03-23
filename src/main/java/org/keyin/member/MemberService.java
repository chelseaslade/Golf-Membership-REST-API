package org.keyin.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public ArrayList<Member> getAllMembers() {
        return (ArrayList<Member>) memberRepository.findAll();
    }

    public Member getMemberById(Long id) {
        return memberRepository.findById(id).orElse(null);
    }

    public ArrayList<Member> getMembersByName(String name) {
        return memberRepository.findByName(name);
    }

    public ArrayList<Member> getMembersByEmail(String email) {
        return memberRepository.findByEmail(email);
    }

    public ArrayList<Member> getMembersByPhone(String phone) {
        return memberRepository.findByPhone(phone);
    }
}