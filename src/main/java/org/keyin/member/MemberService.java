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
        ArrayList<Member> members = new ArrayList<>();
        for (Member member : memberRepository.findAll()) {
            if (member.getName().equals(name)) {
                members.add(member);
                break;
            }
        }
        return members;
    }

    public ArrayList<Member> getMembersByEmail(String email) {
        ArrayList<Member> members = new ArrayList<>();
        for (Member member : memberRepository.findAll()) {
            if (member.getEmail().equals(email)) {
                members.add(member);
                break;
            }
        }
        return members;
    }

    public ArrayList<Member> getMembersByPhone(String phone) {
        ArrayList<Member> members = new ArrayList<>();
        for (Member member : memberRepository.findAll()) {
            if (member.getPhone().equals(phone)) {
                members.add(member);
                break;
            }
        }
        return members;
    }
}