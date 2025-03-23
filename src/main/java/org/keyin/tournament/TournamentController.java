package org.keyin.tournament;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/tournaments")
public class TournamentController {
    @Autowired
    private TournamentService tournamentService;

    @Autowired
    private TournamentRepository tournamentRepository;

    @GetMapping
    public ArrayList<Tournament> getTournaments() {
        return tournamentService.getAllTournaments();
    }

    @GetMapping("/{id}")
    public Tournament getTournament(@PathVariable Long id) {
        return tournamentService.getTournamentById(id);
    }

    @GetMapping("/search")
    public ResponseEntity<ArrayList<Tournament>> searchTournaments(
            @RequestParam(required = false) String tourneyName,
            @RequestParam(required = false) String location,
            @RequestParam(required = false) LocalDate startDate){

        ArrayList<Tournament> results = new ArrayList<>();

        if (tourneyName != null) {
            results = tournamentService.getTournamentsByTourneyName(tourneyName);
        } else if (location != null) {
            results = tournamentService.getTournamentsByLocation(location);
        } else if (startDate != null) {
            results = tournamentService.getTournamentsByStartDate(startDate);
        }

        return results.isEmpty() ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(results, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Tournament> createTournament(@RequestBody Tournament tournament) {
        Tournament newTournament = tournamentRepository.save(tournament);
        return new ResponseEntity<>(newTournament, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTournament(@PathVariable Long id) {
        if (tournamentRepository.existsById(id)) {
            tournamentRepository.deleteById(id);
            return new ResponseEntity<>("Tournament deleted successfully.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Tournament not found.", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tournament> updateTournament(@PathVariable Long id, @RequestBody Tournament updatedTournament) {
        return tournamentRepository.findById(id)
                .map(existingTournament -> {
                    existingTournament.setTourneyName(updatedTournament.getTourneyName());
                    existingTournament.setStartDate(updatedTournament.getStartDate());
                    existingTournament.setEndDate(updatedTournament.getEndDate());
                    existingTournament.setLocation(updatedTournament.getLocation());
                    existingTournament.setEntryFee(updatedTournament.getEntryFee());
                    existingTournament.setTourneyPrize(updatedTournament.getTourneyPrize());
                    existingTournament.setTourneyMembers(updatedTournament.getTourneyMembers());
                    Tournament savedTournament = tournamentRepository.save(existingTournament);
                    return new ResponseEntity<>(savedTournament, HttpStatus.OK);
                })
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));}
    }
