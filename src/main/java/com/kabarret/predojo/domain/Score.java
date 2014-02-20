package com.kabarret.predojo.domain;

import com.kabarret.predojo.enums.ScoreType;

import java.util.Date;

public class Score {

    private ScoreType scoreType;
    private Date timeEvent;

    public Score(ScoreType scoreType, Date timeEvent) {
        this.scoreType = scoreType;
        this.timeEvent = timeEvent;
    }

    public ScoreType getScoreType() {
        return scoreType;
    }

    public void setScoreType(ScoreType scoreType) {
        this.scoreType = scoreType;
    }

    public Date getTimeEvent() {
        return timeEvent;
    }

    public void setTimeEvent(Date timeEvent) {
        this.timeEvent = timeEvent;
    }
}
