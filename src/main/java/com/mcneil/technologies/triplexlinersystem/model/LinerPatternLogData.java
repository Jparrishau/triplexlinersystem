package com.mcneil.technologies.triplexlinersystem.model;

import jakarta.persistence.*;

@Entity
@Table(name = "liner_pattern_log_data")
public class LinerPatternLogData {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Column(name = "log_data")
    private String logData;
    @Column(name = "log_type")
    private String logType;
    @Column(name = "log_date")
    private String logDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogData() {
        return logData;
    }

    public void setLogData(String logData) {
        this.logData = logData;
    }

    public String getLogType() {
        return logType;
    }

    public void setLogType(String logType) {
        this.logType = logType;
    }

    public String getLogDate() {
        return logDate;
    }

    public void setLogDate(String logDate) {
        this.logDate = logDate;
    }
}