package org.keyin.member;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;
    private String email;
    private String phone;
    private Date membershipStart;
    private String membershipLength;

    //Methods
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
