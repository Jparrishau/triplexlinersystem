package com.mcneil.technologies.triplexlinersystem.model;

import jakarta.persistence.*;

@Entity
public class LinerPatternCreationInfo {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "pattern_by")
    private String patternCreatedBy;
    @Column(name = "felt_cut_by")
    private String feltCutBy;
    @Column(name = "liner_cut_assembled_by")
    private String linerCutAssembledBy;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPatternCreatedBy() {
        return patternCreatedBy;
    }

    public void setPatternCreatedBy(String patternCreatedBy) {
        this.patternCreatedBy = patternCreatedBy;
    }

    public String getFeltCutBy() {
        return feltCutBy;
    }

    public void setFeltCutBy(String feltCutBy) {
        this.feltCutBy = feltCutBy;
    }

    public String getLinerCutAssembledBy() {
        return linerCutAssembledBy;
    }

    public void setLinerCutAssembledBy(String linerCutAssembledBy) {
        this.linerCutAssembledBy = linerCutAssembledBy;
    }
}
