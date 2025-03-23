package org.keyin.tournament;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;

@Service
public class TournamentService {
    private final TournamentRepository tournamentRepository;

    @Autowired
    public TournamentService(TournamentRepository tournamentRepository) {
        this.tournamentRepository = tournamentRepository;
    }

    public ArrayList<Tournament> getAllTournaments() {
        return (ArrayList<Tournament>) tournamentRepository.findAll();
    }

    public Tournament getTournamentById(Long id) {
        return tournamentRepository.findById(id).orElse(null);
    }

    public ArrayList<Tournament> getTournamentsByTourneyName(String tourneyName) {
        return tournamentRepository.findByTourneyName(tourneyName);
    }

    public ArrayList<Tournament> getTournamentsByLocation(String location) {
        return tournamentRepository.findByLocation(location);
    }

    public ArrayList<Tournament> getTournamentsByStartDate(LocalDate startDate) {
        return tournamentRepository.findByStartDate(startDate);
    }
}

