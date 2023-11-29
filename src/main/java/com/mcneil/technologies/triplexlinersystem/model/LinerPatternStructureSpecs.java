package com.mcneil.technologies.triplexlinersystem.model;

import jakarta.persistence.*;

@Entity
public class LinerPatternStructureSpecs {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "reinforcements_correct")
    private boolean reinforcementsCorrect;
    @Column(name = "measurements_match_pattern")
    private boolean measurementsMatchPattern;
    @Column(name = "2_inch_cut")
    private boolean twoInchCut;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isReinforcementsCorrect() {
        return reinforcementsCorrect;
    }

    public void setReinforcementsCorrect(boolean reinforcementsCorrect) {
        this.reinforcementsCorrect = reinforcementsCorrect;
    }

    public boolean isMeasurementsMatchPattern() {
        return measurementsMatchPattern;
    }

    public void setMeasurementsMatchPattern(boolean measurementsMatchPattern) {
        this.measurementsMatchPattern = measurementsMatchPattern;
    }

    public boolean isTwoInchCut() {
        return twoInchCut;
    }

    public void setTwoInchCut(boolean twoInchCut) {
        this.twoInchCut = twoInchCut;
    }
}
