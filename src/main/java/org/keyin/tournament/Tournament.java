package org.keyin.tournament;

import org.keyin.member.Member;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Tournament {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tourneyName;
    private Date startDate;
    private Date endDate;
    private String location;
    private double entryFee;
    private double tourneyPrize;

    @OneToMany
    private List<Member> tourneyMembers;

    //Methods
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
