package com.example.assessment.dao;

import com.example.assessment.entity.Match;
import com.example.assessment.entity.MatchOdd;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchOddsRepository extends JpaRepository<MatchOdd,Integer> {
}
