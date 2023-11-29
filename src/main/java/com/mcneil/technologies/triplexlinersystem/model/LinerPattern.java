package com.mcneil.technologies.triplexlinersystem.model;


import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import java.util.Date;
import java.util.List;

@Entity
public class LinerPattern {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private LinerPatternBasicInfo linerPatternBasicInfo;
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private LinerPatternCreationInfo linerPatternCreationInfo;
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private LinerPatternLicenseeInfo linerPatternLicenseeInfo;
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private LinerPatternStructureSpecs linerPatternStructureSpecs;
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private LinerPatternMeasurementInfo linerPatternMeasurementInfo;
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "liner_pattern_id")
    @Where(clause = "imageType='before'")
    private List<LinerPatternImageData> linerPatternBeforeImageData;
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "liner_pattern_id")
    @Where(clause = "imageType='location'")
    private List<LinerPatternImageData> linerPatternLocationImageData;
    @CreationTimestamp
    private Date dateCreated;
    @UpdateTimestamp
    private Date lastUpdated;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LinerPatternLicenseeInfo getLinerPatternLicenseeInfo() {
        return linerPatternLicenseeInfo;
    }

    public void setLinerPatternLicenseeInfo(LinerPatternLicenseeInfo linerPatternLicenseeInfo) {
        this.linerPatternLicenseeInfo = linerPatternLicenseeInfo;
    }

    public LinerPatternStructureSpecs getLinerPatternStructureSpecs() {
        return linerPatternStructureSpecs;
    }

    public void setLinerPatternStructureSpecs(LinerPatternStructureSpecs linerPatternStructureSpecs) {
        this.linerPatternStructureSpecs = linerPatternStructureSpecs;
    }

    public LinerPatternMeasurementInfo getLinerPatternMeasurementInfo() {
        return linerPatternMeasurementInfo;
    }

    public void setLinerPatternMeasurementInfo(LinerPatternMeasurementInfo linerPatternMeasurementInfo) {
        this.linerPatternMeasurementInfo = linerPatternMeasurementInfo;
    }

    public List<LinerPatternImageData> getLinerPatternBeforeImageData() {
        return linerPatternBeforeImageData;
    }

    public void setLinerPatternBeforeImageData(List<LinerPatternImageData> linerPatternBeforeImageData) {
        this.linerPatternBeforeImageData = linerPatternBeforeImageData;
    }

    public List<LinerPatternImageData> getLinerPatternLocationImageData() {
        return linerPatternLocationImageData;
    }

    public void setLinerPatternLocationImageData(List<LinerPatternImageData> linerPatternLocationImageData) {
        this.linerPatternLocationImageData = linerPatternLocationImageData;
    }

    public void setLinerPatternCreationInfo(LinerPatternCreationInfo linerPatternCreationInfo) {
        this.linerPatternCreationInfo = linerPatternCreationInfo;
    }

    public LinerPatternBasicInfo getLinerPatternBasicInfo() {
        return linerPatternBasicInfo;
    }

    public void setLinerPatternBasicInfo(LinerPatternBasicInfo linerPatternBasicInfo) {
        this.linerPatternBasicInfo = linerPatternBasicInfo;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
}