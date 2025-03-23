package org.keyin.tournament;

import org.keyin.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;

@Repository
public interface TournamentRepository extends JpaRepository<Tournament, Long> {
    ArrayList<Tournament> findByName(String name);
    ArrayList<Tournament> findByLocation(String location);
    ArrayList<Tournament> findByStartDate(LocalDate startDate);
}
