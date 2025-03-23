package org.keyin.member;

import javax.persistence.*;
import java.time.temporal.ChronoUnit;
import java.time.LocalDate;

@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;
    private String email;
    private String phone;
    private LocalDate membershipStart;
    private String membershipLength;

    //Constructors
    public Member() {
    }

    public Member(String name, String address, String email, String phone, LocalDate membershipStart) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.membershipStart = membershipStart;
        this.membershipLength = getMembershipLength();
    }

    //Methods
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getMembershipStart() {
        return membershipStart;
    }

    public void setMembershipStart(LocalDate membershipStart) {
        this.membershipStart = membershipStart;
    }

    public String getMembershipLength() {
        if (membershipStart == null) {
            return "Membership start date not specified.";
        }

        LocalDate currentDate = LocalDate.now();
        long membershipDays = ChronoUnit.DAYS.between(membershipStart, currentDate);

        return membershipDays + " days";
    }
}
