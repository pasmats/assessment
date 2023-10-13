package com.example.assessment.controllers;

import com.example.assessment.entity.Match;
import com.example.assessment.entity.MatchOdd;
import com.example.assessment.service.MatchOddsService;
import com.example.assessment.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class DemoWebController {
    private MatchService matchService;
    private MatchOddsService matchOddsService;

    @Autowired //optional because of one constructor
    public DemoWebController(MatchService matchService, MatchOddsService matchOddsService) {
        this.matchService = matchService;
        this.matchOddsService = matchOddsService;
    }

    @GetMapping("/")
    public String showHome(Model model){
        List<Match> matchList = matchService.findAll();
        model.addAttribute("matchList",matchList);

        return "home";
    }
    @GetMapping("/match/delete")
    public String deleteMatch(@RequestParam int matchId){
        matchService.deleteById(matchId);
        return "redirect:/";
    }
    @GetMapping("/match/matchAddForm")
    public String matchAddForm(Model model){
        Match match = new Match();
        model.addAttribute("match",match);
        return "match_form";
    }
    @PostMapping("/match/save")
    public String saveMatch(@ModelAttribute("match")Match theMatch){
        matchService.save(theMatch);
        return "redirect:/";
    }
    @GetMapping("/match/update")
    public String updateMatch(@RequestParam int matchId ,Model model){
        Match match = matchService.findById(matchId);
        model.addAttribute("match",match);
        return "match_form";
    }
    @GetMapping("/matchOdd/delete")
    public String deleteMatchOdd(@RequestParam int matchOddId, RedirectAttributes redirectAttributes){
        MatchOdd matchOdd = matchOddsService.findById(matchOddId);
        matchOddsService.deleteById(matchOddId);
        redirectAttributes.addAttribute("matchId", matchOdd.getMatch().getId());
        return "redirect:/match/update";
    }
    @PostMapping("/matchOdd/save")
    public String saveMatchOdd(@ModelAttribute("matchOdd")MatchOdd theMatchOdd,RedirectAttributes redirectAttributes){
        MatchOdd matchOdd = theMatchOdd;
        Match match = matchService.findById(matchOdd.getMatch().getId());
        matchOdd.setMatch(match);
        if (matchOdd.getId() == null || matchOdd.getId() < 0){
            matchOdd.setId(0); // ensure will save instead of update
        }
        matchOddsService.save(theMatchOdd);
        redirectAttributes.addAttribute("matchId", matchOdd.getMatch().getId());
        return "redirect:/match/update";
    }
    @GetMapping("/matchOdd/matchOddAddForm")
    public String matchOddAddForm(@RequestParam int matchId,Model model){
        MatchOdd matchOdd = new MatchOdd();
        matchOdd.setMatch(matchService.findById(matchId));
        model.addAttribute("matchOdd",matchOdd);
        return "matchOdd_form";
    }
    @GetMapping("/matchOdd/update")
    public String updateMatchOdd(@RequestParam int matchOddId ,Model model){
        MatchOdd matchOdd = matchOddsService.findById(matchOddId);
        model.addAttribute("matchOdd",matchOdd);
        return "matchOdd_form";
    }

}
