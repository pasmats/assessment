package com.example.assessment.service;

import com.example.assessment.entity.Match;
import com.example.assessment.entity.MatchOdd;

import java.util.List;

public interface MatchOddsService {
    List<MatchOdd> findAll();
    MatchOdd findById(int theId);
    MatchOdd save(MatchOdd theSensor);

    void deleteById(int theId);
}
