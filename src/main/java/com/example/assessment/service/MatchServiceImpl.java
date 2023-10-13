package com.example.assessment.service;

import com.example.assessment.dao.MatchRepository;
import com.example.assessment.entity.Match;
import com.example.assessment.entity.MatchOdd;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatchServiceImpl implements MatchService{
    private MatchRepository matchRepository;
    private EntityManager entityManager;

    @Autowired
    public MatchServiceImpl(MatchRepository matchRepository, EntityManager entityManager) {
        this.matchRepository = matchRepository;
        this.entityManager = entityManager;
    }

    @Override
    public List<Match> findAll() {
        return matchRepository.findAll();
    }

    @Override
    public Match findById(int theId) {
        Optional<Match> result = matchRepository.findById(theId);
        Match match = null;
        if (result.isPresent()){
            match = result.get();
        }else {
            throw new RuntimeException("Match with id: "+theId+" not found");
        }
        return match;
    }

    @Override
    public Match save(Match match) {
        return matchRepository.save(match);
    }

    @Override
    public void deleteById(int theId) { matchRepository.deleteById(theId); }
}
