package com.kabarret.predojo.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Match {

    private String id;
    private List<Kill> killList = new ArrayList<Kill>();
    private Date start;
    private Date end;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Kill> getKillList() {
        return killList;
    }

    public void setKillList(List<Kill> killList) {
        this.killList = killList;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }
}
