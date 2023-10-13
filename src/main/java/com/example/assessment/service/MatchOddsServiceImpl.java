package com.example.assessment.service;

import com.example.assessment.dao.MatchOddsRepository;
import com.example.assessment.dao.MatchRepository;
import com.example.assessment.entity.Match;
import com.example.assessment.entity.MatchOdd;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatchOddsServiceImpl implements MatchOddsService{

    private MatchOddsRepository matchOddsRepository;
    private EntityManager entityManager;

    @Autowired
    public MatchOddsServiceImpl(MatchOddsRepository matchOddsRepository, EntityManager entityManager) {
        this.matchOddsRepository = matchOddsRepository;
        this.entityManager = entityManager;
    }

    @Override
    public List<MatchOdd> findAll() {
        return matchOddsRepository.findAll();
    }

    @Override
    public MatchOdd findById(int theId) {
        Optional<MatchOdd> result = matchOddsRepository.findById(theId);
        MatchOdd matchOdd = null;
        if (result.isPresent()){
            matchOdd = result.get();
        }else {
            throw new RuntimeException("MatchOdd with id: "+theId+" not found");
        }
        return matchOdd;
    }

    @Override
    public MatchOdd save(MatchOdd matchOdd) {
        return matchOddsRepository.save(matchOdd);
    }

    @Override
    public void deleteById(int theId) { matchOddsRepository.deleteById(theId); }
}
