package com.mcneil.technologies.triplexlinersystem.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class LinerPatternBasicInfo {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "date")
    private Date date;
    @Column(name = "job_num")
    private String jobNumber;
    @Column(name = "utility_id")
    private int utilityId;
    @Column(name = "mct_num")
    private String mctNumber;

    public Integer getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(String jobNumber) {
        this.jobNumber = jobNumber;
    }

    public int getUtilityId() {
        return utilityId;
    }

    public void setUtilityId(int utilityId) {
        this.utilityId = utilityId;
    }

    public String getMctNumber() {
        return mctNumber;
    }

    public void setMctNumber(String mctNumber) {
        this.mctNumber = mctNumber;
    }
}
