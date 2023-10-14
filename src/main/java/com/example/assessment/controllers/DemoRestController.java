package com.example.assessment.controllers;

import com.example.assessment.entity.Match;
import com.example.assessment.entity.MatchOdd;
import com.example.assessment.enumType.Sport;
import com.example.assessment.service.MatchOddsService;
import com.example.assessment.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DemoRestController {
    private MatchService matchService;
    private MatchOddsService matchOddsService;

    @Autowired //optional because of one constructor
    public DemoRestController(MatchService matchService,MatchOddsService matchOddsService) {
        this.matchService = matchService;
        this.matchOddsService = matchOddsService;
    }

    @GetMapping("/matchOdd")
    public List<MatchOdd> getAllMatchOdds(){
        return matchOddsService.findAll();
    }
    @GetMapping("/matchOdd/{matchOddId}")
    public MatchOdd getMatchOddById(@PathVariable int matchOddId){
        MatchOdd matchOdd = matchOddsService.findById(matchOddId);
        if (matchOdd == null){
            throw new RuntimeException("MatchOdd id not found");
        }
        return  matchOdd;
    }
    @PostMapping("/matchOdd")
    public MatchOdd updateMatchOdd(@RequestBody MatchOdd matchOdd){
        if (matchOdd.getId()==null || matchOdd.getId() < 0){
            matchOdd.setId(0); // ensure variable is correctly initialised
        }
        return matchOddsService.save(matchOdd);
    }
    @DeleteMapping("/matchOdd/{matchOddId}")
    public String deleteMatchOdd(@PathVariable int matchOddId){
        matchOddsService.deleteById(matchOddId);
        return "Successfully deleted matchOdd with id: "+matchOddId;
    }
    @GetMapping("/match")
    public List<Match> updateRecMatch(){
        return matchService.findAll();
    }
    @GetMapping("/match/{matchId}")
    public Match getMatchById(@PathVariable int matchId){
        Match match = matchService.findById(matchId);
        if (match == null){
            throw new RuntimeException("MatchOdd id not found");
        }
        return match;
    }
    @PostMapping("/match")
    public Match updateMatch(@RequestBody Match theMatch){
        if (theMatch.getId() == null || theMatch.getId() < 0){
            theMatch.setId(0); // ensure variable is correctly initialised
        }
        return matchService.save(theMatch);
    }
    @DeleteMapping("/match/{matchId}")
    public String deleteMatch(@PathVariable int matchId){
        matchService.deleteById(matchId);
        return "deleted match with id: "+matchId;
    }

}
