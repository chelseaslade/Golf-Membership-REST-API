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

    //Constructors
    public Tournament() {}

    public Tournament(String tourneyName, Date startDate, Date endDate, String location, double entryFee, double tourneyPrize) {
        this.tourneyName = tourneyName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.location = location;
        this.entryFee = entryFee;
        this.tourneyPrize = tourneyPrize;
    }

    //Methods
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getTourneyName() {
        return tourneyName;
    }

    public void setTourneyName(String tourneyName) {
        this.tourneyName = tourneyName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getEntryFee() {
        return entryFee;
    }

    public void setEntryFee(double entryFee) {
        this.entryFee = entryFee;
    }

    public double getTourneyPrize() {
        return tourneyPrize;
    }

    public void setTourneyPrize(double tourneyPrize) {
        this.tourneyPrize = tourneyPrize;
    }
}
