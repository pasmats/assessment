package com.example.assessment.entity;

import com.example.assessment.enumType.Sport;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.ColumnTransformer;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "match")
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial",nullable = false)
    private Integer id;

    @Column(name = "description", length = 50)
    private String description;

    @Column(name = "match_date")
    private LocalDate matchDate;

    @Column(name = "match_time")
    private LocalTime matchTime;

    @Column(name = "team_a", length = 50)
    private String teamA;

    @Column(name = "team_b", length = 50)
    private String teamB;

    @Column(name = "sport")
    @Enumerated(EnumType.STRING)
    private Sport sport;

    @OneToMany(mappedBy = "match",fetch = FetchType.LAZY)
    @JsonIgnore
    private List<MatchOdd> matchOdds = new ArrayList<>();

    public List<MatchOdd> getMatchOdds() {
        return matchOdds;
    }

    public void setMatchOdds(List<MatchOdd> matchOdds) {
        this.matchOdds = matchOdds;
    }

    public Match() {
    }

    public Match(Integer id, String description, LocalDate matchDate, LocalTime matchTime, String teamA, String teamB, Sport sport) {
        this.id = id;
        this.description = description;
        this.matchDate = matchDate;
        this.matchTime = matchTime;
        this.teamA = teamA;
        this.teamB = teamB;
        this.sport = sport;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(LocalDate matchDate) {
        this.matchDate = matchDate;
    }

    public LocalTime getMatchTime() {
        return matchTime;
    }

    public void setMatchTime(LocalTime matchTime) {
        this.matchTime = matchTime;
    }

    public String getTeamA() {
        return teamA;
    }

    public void setTeamA(String teamA) {
        this.teamA = teamA;
    }

    public String getTeamB() {
        return teamB;
    }

    public void setTeamB(String teamB) {
        this.teamB = teamB;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }

    @Override
    public String toString() {
        return "Match{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", matchDate=" + matchDate +
                ", matchTime=" + matchTime +
                ", teamA='" + teamA + '\'' +
                ", teamB='" + teamB + '\'' +
                ", sport=" + sport +
                '}';
    }
}