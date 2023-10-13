package com.example.assessment.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "match_odds")
public class MatchOdd {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial",nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "match_id", nullable = false)
    private Match match;

    @Column(name = "specifier", length = Integer.MAX_VALUE)
    private String specifier;

    @Column(name = "odd")
    private Double odd;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public String getSpecifier() {
        return specifier;
    }

    public void setSpecifier(String specifier) {
        this.specifier = specifier;
    }

    public Double getOdd() {
        return odd;
    }

    public void setOdd(Double odd) {
        this.odd = odd;
    }

    @Override
    public String toString() {
        return "MatchOdd{" +
                "id=" + id +
                ", match=" + match +
                ", specifier='" + specifier + '\'' +
                ", odd=" + odd +
                '}';
    }
}