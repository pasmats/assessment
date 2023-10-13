package com.example.assessment.service;

import com.example.assessment.entity.Match;

import java.util.List;

public interface MatchService {
    List<Match> findAll();
    Match findById(int theId);
    Match save(Match theSensor);

    void deleteById(int theId);
}
