package com.mcneil.technologies.triplexlinersystem.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
public class LinerPatternMeasurementInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer lidDiameter = 0;
    private Integer chimneyDiameter = 0;
    private Integer chimneyDepth = 0;
    private Integer chimneyDepth2 = 0;
    private Integer chimneyDepth3 = 0;
    private Integer chimneyDepth4 = 0;
    private Integer corbelDepth = 0;
    private Integer corbelSlope = 0;
    private Integer bodyDiameterA = 0;
    private Integer bodyDiameterB = 0;
    private Integer bodyDiameter1 = 0;
    private Integer bodyDiameter2 = 0;
    private Integer bodyDiameter3 = 0;
    private Integer benchDepth = 0;
    private Integer invertDepth = 0;
    private Integer invertDiameter = 0;
    private Integer canisterDiameter = 0;
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

    public Integer getLidDiameter() {
        return lidDiameter;
    }

    public void setLidDiameter(Integer lidDiameter) {
        this.lidDiameter = lidDiameter;
    }

    public Integer getChimneyDiameter() {
        return chimneyDiameter;
    }

    public void setChimneyDiameter(Integer chimneyDiameter) {
        this.chimneyDiameter = chimneyDiameter;
    }

    public Integer getChimneyDepth() {
        return chimneyDepth;
    }

    public void setChimneyDepth(Integer chimneyDepth) {
        this.chimneyDepth = chimneyDepth;
    }

    public Integer getChimneyDepth2() {
        return chimneyDepth2;
    }

    public void setChimneyDepth2(Integer chimneyDepth2) {
        this.chimneyDepth2 = chimneyDepth2;
    }

    public Integer getChimneyDepth3() {
        return chimneyDepth3;
    }

    public void setChimneyDepth3(Integer chimneyDepth3) {
        this.chimneyDepth3 = chimneyDepth3;
    }

    public Integer getChimneyDepth4() {
        return chimneyDepth4;
    }

    public void setChimneyDepth4(Integer chimneyDepth4) {
        this.chimneyDepth4 = chimneyDepth4;
    }

    public Integer getCorbelDepth() {
        return corbelDepth;
    }

    public void setCorbelDepth(Integer corbelDepth) {
        this.corbelDepth = corbelDepth;
    }

    public Integer getCorbelSlope() {
        return corbelSlope;
    }

    public void setCorbelSlope(Integer corbelSlope) {
        this.corbelSlope = corbelSlope;
    }

    public Integer getBodyDiameterA() {
        return bodyDiameterA;
    }

    public void setBodyDiameterA(Integer bodyDiameterA) {
        this.bodyDiameterA = bodyDiameterA;
    }

    public Integer getBodyDiameterB() {
        return bodyDiameterB;
    }

    public void setBodyDiameterB(Integer bodyDiameterB) {
        this.bodyDiameterB = bodyDiameterB;
    }

    public Integer getBodyDiameter1() {
        return bodyDiameter1;
    }

    public void setBodyDiameter1(Integer bodyDiameter1) {
        this.bodyDiameter1 = bodyDiameter1;
    }

    public Integer getBodyDiameter2() {
        return bodyDiameter2;
    }

    public void setBodyDiameter2(Integer bodyDiameter2) {
        this.bodyDiameter2 = bodyDiameter2;
    }

    public Integer getBodyDiameter3() {
        return bodyDiameter3;
    }

    public void setBodyDiameter3(Integer bodyDiameter3) {
        this.bodyDiameter3 = bodyDiameter3;
    }

    public Integer getBenchDepth() {
        return benchDepth;
    }

    public void setBenchDepth(Integer benchDepth) {
        this.benchDepth = benchDepth;
    }

    public Integer getInvertDiameter() {
        return invertDiameter;
    }

    public void setInvertDiameter(Integer invertDiameter) {
        this.invertDiameter = invertDiameter;
    }

    public Integer getInvertDepth() {
        return invertDepth;
    }

    public void setInvertDepth(Integer invertDepth) {
        this.invertDepth = invertDepth;
    }

    public Integer getCanisterDiameter() {
        return canisterDiameter;
    }

    public void setCanisterDiameter(Integer canisterDiameter) {
        this.canisterDiameter = canisterDiameter;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
}
