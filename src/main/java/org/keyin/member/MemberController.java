package org.keyin.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/members")
public class MemberController {
    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberRepository memberRepository;

    @GetMapping
    public ArrayList<Member> getMembers() {
        return memberService.getAllMembers();
    }

    @GetMapping("/{id}")
    public Member getMember(@PathVariable Long id) {
        return memberService.getMemberById(id);
    }

    @GetMapping("/{name}")
    public ArrayList<Member> getMemberByName(@PathVariable String name) {
        return memberService.getMembersByName(name);
    }

    @GetMapping("/{email}")
    public ArrayList<Member> getMemberByEmail(@PathVariable String email) {
        return memberService.getMembersByEmail(email);
    }

    @GetMapping("/{phone}")
    public ArrayList<Member> getMemberByPhone(@PathVariable String phone) {
        return memberService.getMembersByPhone(phone);
    }

    @PostMapping
    public ResponseEntity<Member> createMember(@RequestBody Member member) {
        Member newMember = memberRepository.save(member);
        return new ResponseEntity<>(newMember, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMember(@PathVariable Long id) {
        if (memberRepository.existsById(id)) {
            memberRepository.deleteById(id);
            return new ResponseEntity<>("Member deleted successfully.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Member not found.", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Member> updateMember(@PathVariable Long id, @RequestBody Member updatedMember) {
        return memberRepository.findById(id)
                .map(existingMember -> {
                    existingMember.setName(updatedMember.getName());
                    existingMember.setAddress(updatedMember.getAddress());
                    existingMember.setEmail(updatedMember.getEmail());
                    existingMember.setPhone(updatedMember.getPhone());
                    existingMember.setMembershipStart(updatedMember.getMembershipStart());
                    Member savedMember = memberRepository.save(existingMember);
                    return new ResponseEntity<>(savedMember, HttpStatus.OK);
                })
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
